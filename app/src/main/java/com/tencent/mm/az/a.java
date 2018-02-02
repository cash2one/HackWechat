package com.tencent.mm.az;

import android.content.ContentValues;
import android.database.Cursor;

public final class a {
    int fDt = -1;
    public int hJl = 0;
    private String hls = "";
    private String hlt = "";
    private int hlu = 0;
    private int hlv = 0;
    private String path = "";
    public String username = "";

    public final void b(Cursor cursor) {
        this.username = cursor.getString(0);
        this.hJl = cursor.getInt(1);
        this.path = cursor.getString(2);
        this.hls = cursor.getString(3);
        this.hlt = cursor.getString(4);
        this.hlu = cursor.getInt(5);
        this.hlv = cursor.getInt(6);
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("bgflag", Integer.valueOf(this.hJl));
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("path", this.path == null ? "" : this.path);
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("reserved1", this.hls == null ? "" : this.hls);
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("reserved2", this.hlt == null ? "" : this.hlt);
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hlu));
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hlv));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
