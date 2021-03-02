package com.example.design.designCombat.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ORDER_INFO".
*/
public class OrderInfoDao extends AbstractDao<OrderInfo, Void> {

    public static final String TABLENAME = "ORDER_INFO";

    /**
     * Properties of entity OrderInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property OrderId = new Property(0, int.class, "OrderId", false, "ORDER_ID");
        public final static Property OrderName = new Property(1, String.class, "orderName", false, "ORDER_NAME");
        public final static Property OrderTime = new Property(2, String.class, "orderTime", false, "ORDER_TIME");
    }


    public OrderInfoDao(DaoConfig config) {
        super(config);
    }
    
    public OrderInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORDER_INFO\" (" + //
                "\"ORDER_ID\" INTEGER NOT NULL ," + // 0: OrderId
                "\"ORDER_NAME\" TEXT," + // 1: orderName
                "\"ORDER_TIME\" TEXT);"); // 2: orderTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORDER_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, OrderInfo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getOrderId());
 
        String orderName = entity.getOrderName();
        if (orderName != null) {
            stmt.bindString(2, orderName);
        }
 
        String orderTime = entity.getOrderTime();
        if (orderTime != null) {
            stmt.bindString(3, orderTime);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, OrderInfo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getOrderId());
 
        String orderName = entity.getOrderName();
        if (orderName != null) {
            stmt.bindString(2, orderName);
        }
 
        String orderTime = entity.getOrderTime();
        if (orderTime != null) {
            stmt.bindString(3, orderTime);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public OrderInfo readEntity(Cursor cursor, int offset) {
        OrderInfo entity = new OrderInfo( //
            cursor.getInt(offset + 0), // OrderId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // orderName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // orderTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, OrderInfo entity, int offset) {
        entity.setOrderId(cursor.getInt(offset + 0));
        entity.setOrderName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setOrderTime(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(OrderInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(OrderInfo entity) {
        return null;
    }

    @Override
    public boolean hasKey(OrderInfo entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
