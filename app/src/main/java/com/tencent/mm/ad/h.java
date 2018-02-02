package com.tencent.mm.ad;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bh;

public final class h {
    public int fDt = -1;
    public int fWe = 0;
    int hlA = 0;
    int hlw = 0;
    public String hlx = "";
    public String hly = "";
    private int hlz = 0;
    public String username = "";

    public final void b(Cursor cursor) {
        this.username = cursor.getString(0);
        this.fWe = cursor.getInt(1);
        this.hlw = cursor.getInt(2);
        this.hly = cursor.getString(3);
        this.hlx = cursor.getString(4);
        this.hlz = cursor.getInt(5);
        this.hlA = cursor.getInt(6);
    }

    public final ContentValues JF() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("imgflag", Integer.valueOf(this.fWe));
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("lastupdatetime", Integer.valueOf(this.hlw));
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("reserved1", JG());
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("reserved2", JH());
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hlz));
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hlA));
        }
        return contentValues;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String JG() {
        return this.hly == null ? "" : this.hly;
    }

    public final void jl(String str) {
        this.hlx = str;
    }

    public final String JH() {
        return this.hlx == null ? "" : this.hlx;
    }

    public final void bA(boolean z) {
        this.hlz = z ? 1 : 0;
    }

    public final void JI() {
        this.hlA = (int) (bh.Wo() / 60);
        this.fDt |= 64;
    }
}
