package com.example.design.launcher.manager;

import android.content.Context;

import com.example.design.launcher.dao.AppInfo;
import com.example.design.launcher.dao.AppInfoDao;
import com.example.design.launcher.dao.DaoMaster;
import com.example.design.launcher.dao.DaoSession;
import com.example.design.launcher.dao.HomeAppInfo;
import com.example.design.launcher.dao.HomeAppInfoDao;

import org.greenrobot.greendao.database.Database;

import java.util.List;

public class DataBaseManager {
    private static final String TAG = DataBaseManager.class.getSimpleName();
    private Database database;
    private HomeAppInfoDao homeAppInfoDao;
    private AppInfoDao appInfoDao;
    private Context context;
    public static final String DATABASE_NAME = "app.db";

    public DataBaseManager(Context context) {
        this.context = context;
    }

    public void init() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DATABASE_NAME);
        database = helper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        homeAppInfoDao = daoSession.getHomeAppInfoDao();
        appInfoDao = daoSession.getAppInfoDao();
    }

    public void destroy() {
        database.close();
    }

    public List<HomeAppInfo> queryHomeAppInfoList() {
        return homeAppInfoDao.queryBuilder().orderAsc(HomeAppInfoDao.Properties.Position).list();
    }

    public long insetInHome(HomeAppInfo appInfo) {
        return homeAppInfoDao.insertOrReplace(appInfo);
    }

    public void deleteInHome(HomeAppInfo appInfo) {
        homeAppInfoDao.delete(appInfo);
    }

    public void updateInHome(HomeAppInfo appInfo) {
        homeAppInfoDao.update(appInfo);
    }

    public List<AppInfo> queryAllAppInfoList() {
        return appInfoDao.queryBuilder().orderAsc(AppInfoDao.Properties.Id).list();
    }

    public long insertInAll(AppInfo appInfo) {
        return appInfoDao.insertOrReplace(appInfo);
    }

    public void deleteInAll(AppInfo appInfo) {
        appInfoDao.delete(appInfo);
    }

}
