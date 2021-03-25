package com.example.design.launcher.manager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;

import com.example.design.R;
import com.example.design.launcher.dao.AppInfo;
import com.example.design.launcher.dao.HomeAppInfo;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppDataManager {
    private static final String TAG = AppDataManager.class.getSimpleName();
    private Context context;
    private List<String> homeList = new ArrayList<>();
    private List<String> localList = new ArrayList<>();
    private List<String> cloudList = new ArrayList<>();

    private List<HomeAppInfo> homeAppInfoList = new ArrayList<HomeAppInfo>();
    private DataBaseManager dataBaseManager;
    private static AppDataManager instance;

    public static AppDataManager getInstance(Context context) {
        if (instance == null) {
            instance = new AppDataManager(context);
        }
        return instance;
    }

    private AppDataManager(Context context) {
        this.context = context;
        dataBaseManager = new DataBaseManager(this.context);
        dataBaseManager.init();
        loadAllApp();
    }

    private void loadAllApp() {
        Log.d(TAG, "loadAllApp");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                homeAppInfoList.clear();
                homeList.clear();
                localList.clear();
                cloudList.clear();
                List<Integer> toBeDeleted = new ArrayList<>();
                List<AppInfo> dbApps = dataBaseManager.queryAllAppInfoList();
                Log.d(TAG,
                        "loadAllApp BEGIN: dbApps = " + dbApps + ", homeAppInfoList = " + homeAppInfoList);
                List<AppXmlInfo> appXmlInfos = getAppInfoFromXml();
                Log.d(TAG, "loadAllApp BEGIN: appXmlInfos = " + appXmlInfos);
                for (int i = 0; i < dbApps.size(); i++) {
                    AppInfo dbApp = dbApps.get(i);
                    boolean founded = false;
                    for (AppXmlInfo appXmlInfo : appXmlInfos) {
                        if (appXmlInfo.getPackageName().equals(dbApp.getPackageName())) {
                            founded = true;
                            break;
                        }
                    }
                    if (!founded) {
                        dataBaseManager.deleteInAll(dbApp);
                        toBeDeleted.add(i);

                        for (HomeAppInfo homeAppInfo : homeAppInfoList) {
                            if (homeAppInfo.getPackageName().equals(dbApp.getPackageName())) {
                                homeAppInfoList.remove(homeAppInfo);
                                break;
                            }
                        }
                    }

                }
                if (toBeDeleted.size() != 0) {
                    dbApps.remove(toBeDeleted);
                }

                for (AppXmlInfo appXmlInfo : appXmlInfos) {
                    boolean founded = false;
                    for (AppInfo dbApp : dbApps) {
                        if (appXmlInfo.getPackageName().equals(dbApp.getPackageName())) {
                            founded = true;
                            break;
                        }
                    }
                    if (!founded) {
                        long id = dataBaseManager.insertInAll(appXmlInfo);
                        appXmlInfo.setId(id);
                        dbApps.add(appXmlInfo);
                        if (appXmlInfo.isHome()) {
                            HomeAppInfo homeAppInfo = new HomeAppInfo();
                            homeAppInfo.setPackageName(appXmlInfo.getPackageName());
                            homeAppInfo.setPosition(homeAppInfoList.size());
                            long homeId = dataBaseManager.insetInHome(homeAppInfo);
                            homeAppInfo.setId(homeId);
                            homeAppInfoList.add(homeAppInfo);
                        }
                    }
                }
                Log.d(TAG,
                        "loadAllApp BEGIN: dbApps = " + dbApps + ", homeAppInfoList = " + homeAppInfoList);
                for (HomeAppInfo info : homeAppInfoList) {
                    homeList.add(info.getPackageName());
                }

            }

        });
        thread.start();

    }

    private List<AppXmlInfo> getAppInfoFromXml() {
        List<AppXmlInfo> list = null;
        AppXmlInfo appXmlInfo = null;
        Resources resources = context.getResources();
        XmlResourceParser xmlResourceParser = resources.getXml(R.xml.defualt_workspace);

        try {
            int eventType = xmlResourceParser.getEventType();
            while (eventType != xmlResourceParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlResourceParser.START_DOCUMENT:
                        Log.d(TAG, "xml 解析开始");
                        list = new ArrayList<>();
                        break;
                    case XmlPullParser.START_TAG:
                        String xppName = xmlResourceParser.getName();
                        Log.d(TAG, "当前的标签名称是：" + xppName);
                        if ("card_item".equals(xppName)) {
                            appXmlInfo = new AppXmlInfo();
                            appXmlInfo.setHome(true);
                            if (xmlResourceParser.getAttributeBooleanValue(null, "isLocal",
                                    false)) {
                                appXmlInfo.setIsLocal(true);
                            } else {
                                appXmlInfo.setIsLocal(false);
                            }
                            appXmlInfo.setPackageName(xmlResourceParser.getAttributeValue(null,
                                    "package"));
                        } else if ("item".equals(xppName)) {
                            appXmlInfo = new AppXmlInfo();
                            appXmlInfo.setHome(false);
                            if (xmlResourceParser.getAttributeBooleanValue(null, "isLocal",
                                    false)) {
                                appXmlInfo.setIsLocal(true);
                            } else {
                                appXmlInfo.setIsLocal(false);
                            }
                            appXmlInfo.setPackageName(xmlResourceParser.getAttributeValue(null,
                                    "package"));
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("item".equals(xmlResourceParser.getName())) {
                            list.add(appXmlInfo);
                            appXmlInfo = null;
                        }
                        if ("card_item".equals(xmlResourceParser.getName())) {
                            list.add(appXmlInfo);
                            appXmlInfo = null;
                        }
                        break;
                    default:
                        //do nothing
                        break;
                }
                eventType = xmlResourceParser.next();
            }

        } catch (XmlPullParserException e) {
            Log.d(TAG, e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void destroy() {
        Log.d(TAG, "AppDataManager destroy>>>");
        instance = null;
        dataBaseManager.destroy();
        homeList.clear();
        cloudList.clear();
        localList.clear();
        homeAppInfoList.clear();
    }

    public List<String> getHomeList() {
        if (homeList != null) {
            Log.d(TAG, "homeList size is " + homeList.size());
            return homeList;
        }
        return null;
    }
}
