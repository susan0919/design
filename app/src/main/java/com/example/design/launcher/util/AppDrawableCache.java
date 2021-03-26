package com.example.design.launcher.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.defaultThreadFactory;

public class AppDrawableCache {

    private Context context;
    private List<AppDrawGeneratedListener> listenerList = new ArrayList<>();
    private HashMap<String, AppDrawable> drawableHashMap = new HashMap<>();
    private ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 5, 1, TimeUnit.SECONDS,
            new LinkedBlockingDeque<Runnable>(), defaultThreadFactory());
    private static AppDrawableCache instance;

    public static AppDrawableCache getInstance(Context context) {
        if (instance == null) {
            instance = new AppDrawableCache(context);
        }
        return instance;
    }

    private AppDrawableCache(Context context) {
        if (context == null) {
            return;
        }

        this.context = context;
    }

    public void setListenerList(AppDrawGeneratedListener listener) {

        synchronized (listenerList) {
            listenerList.add(listener);
        }
    }

    public AppDrawable getAppDrawable(String packageName) {
        return drawableHashMap.get(packageName);
    }


    public void setAppDrawable(String packageName, AppDrawable appDrawable) {
        if (containsAppDrawable(packageName)) {
            drawableHashMap.put(packageName, appDrawable);
        }
    }

    public boolean containsAppDrawable(String packageName) {
        return drawableHashMap.containsKey(packageName);
    }


    public void generateAppDrawable(final String packageName) {
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                AppDrawable appDrawable = new AppDrawable();
                Drawable drawable = PackageUtils.getIconDrawable(packageName, context);
                if (drawable != null) {
                    appDrawable.setIconNormal(drawable);
                    appDrawable.setIconPressed(PackageUtils.getIconPressedDrawable(drawable));

                }
                drawableHashMap.put(packageName, appDrawable);

                synchronized (listenerList) {
                    for (AppDrawGeneratedListener listener : listenerList) {
                        listener.onAppDrawGenerated(packageName);
                    }
                }
            }
        });

    }

    public void destroy() {
        instance = null;
    }

    public static class AppDrawable {

        private Drawable iconNormal;
        private Drawable iconPressed;
        private Drawable iconConnectedNormal;
        private Drawable getIconConnectedPressed;

        public AppDrawable() {
        }

        public Drawable getIconNormal() {
            return iconNormal;
        }

        public void setIconNormal(Drawable iconNormal) {
            this.iconNormal = iconNormal;
        }

        public Drawable getIconPressed() {
            return iconPressed;
        }

        public void setIconPressed(Drawable iconPressed) {
            this.iconPressed = iconPressed;
        }

        public Drawable getIconConnectedNormal() {
            return iconConnectedNormal;
        }

        public void setIconConnectedNormal(Drawable iconConnectedNormal) {
            this.iconConnectedNormal = iconConnectedNormal;
        }

        public Drawable getGetIconConnectedPressed() {
            return getIconConnectedPressed;
        }

        public void setGetIconConnectedPressed(Drawable getIconConnectedPressed) {
            this.getIconConnectedPressed = getIconConnectedPressed;
        }
    }


    public interface AppDrawGeneratedListener {
        void onAppDrawGenerated(String packageName);
    }
}
