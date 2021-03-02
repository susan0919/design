package com.example.design.designCombat;

public interface OfflineStorageManager {
    void store(StockMessage message);

    Boolean getOffline();

    void setOffline();

    void removeByBatch(StockMessage message);

}
