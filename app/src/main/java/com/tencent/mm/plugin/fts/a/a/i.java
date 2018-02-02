package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;

public final class i {
    public String fDj = "";
    public long hil = 0;
    public int mLr = 0;
    public String mLs = "";
    public long mMd = 0;
    public long mMe = 0;
    public long mMf = 0;
    public String mMg = "";
    public long timestamp = 0;
    public int type = 0;

    public final void b(Cursor cursor) {
        this.mMd = cursor.getLong(0);
        this.fDj = cursor.getString(1);
        this.mMe = cursor.getLong(2);
        this.hil = cursor.getLong(3);
        this.mLs = cursor.getString(4);
        this.mMf = cursor.getLong(5);
        this.type = cursor.getInt(6);
        this.mLr = cursor.getInt(7);
        this.timestamp = cursor.getLong(8);
        this.mMg = cursor.getString(9);
    }
}
