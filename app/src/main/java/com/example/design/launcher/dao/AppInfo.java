package com.example.design.launcher.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class AppInfo {
    @Id(autoincrement = true)
    private Long id;
    private String packageName;
    private boolean isLocal;
    @Generated(hash = 1412180378)
    public AppInfo(Long id, String packageName, boolean isLocal) {
        this.id = id;
        this.packageName = packageName;
        this.isLocal = isLocal;
    }
    @Generated(hash = 1656151854)
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
    public boolean getIsLocal() {
        return this.isLocal;
    }
    public void setIsLocal(boolean isLocal) {
        this.isLocal = isLocal;
    }
}
