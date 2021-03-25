package com.example.design.launcher.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class AppInfo {
    @Id(autoincrement = true)
    private Long id;
    private String packageName;
    private int position;
    @Generated(hash = 1709039024)
    public AppInfo(Long id, String packageName, int position) {
        this.id = id;
        this.packageName = packageName;
        this.position = position;
    }
    public AppInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPackageName() {
        return this.packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
