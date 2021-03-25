package com.example.design.launcher.dao;

import androidx.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class HomeAppInfo {
    @Id(autoincrement = true)
    private Long id;
    private String packageName;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public HomeAppInfo(Long id, String packageName, boolean isLocal, int position,
                       boolean isHome) {
        this.id = id;
        this.packageName = packageName;
    }

    public HomeAppInfo() {
    }

    @Generated(hash = 1968898885)
    public HomeAppInfo(Long id, String packageName, int position) {
        this.id = id;
        this.packageName = packageName;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }


    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
