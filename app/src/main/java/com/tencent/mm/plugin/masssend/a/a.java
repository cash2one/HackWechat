package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;

public final class a {
    int fDt = -1;
    public int fdR = 0;
    public String filename = "";
    String hOU = "";
    int hVC = 0;
    public long hVE = 0;
    long hVF = 0;
    String hhn = "";
    String hho = "";
    public int msgType = 0;
    String omM = "";
    public String omN = "";
    public int omO = 0;
    public int omP = 0;
    int omQ = 0;
    int omR = 0;
    public int omS = 0;
    public int omT = 0;
    int status = 0;

    public final void b(Cursor cursor) {
        this.hOU = cursor.getString(0);
        this.status = cursor.getInt(1);
        this.hVE = cursor.getLong(2);
        this.hVF = cursor.getLong(3);
        this.filename = cursor.getString(4);
        this.omM = cursor.getString(5);
        this.omN = cursor.getString(6);
        this.omO = cursor.getInt(7);
        this.msgType = cursor.getInt(8);
        this.omP = cursor.getInt(9);
        this.omQ = cursor.getInt(10);
        this.fdR = cursor.getInt(11);
        this.hVC = cursor.getInt(12);
        this.omR = cursor.getInt(13);
        this.omS = cursor.getInt(14);
        this.omT = cursor.getInt(15);
        this.hhn = cursor.getString(16);
        this.hho = cursor.getString(17);
    }

    public final String aYv() {
        return this.hOU == null ? "" : this.hOU;
    }

    public final String aYw() {
        return this.filename == null ? "" : this.filename;
    }

    public final String aYx() {
        return this.omM == null ? "" : this.omM;
    }

    public final String aYy() {
        return this.omN == null ? "" : this.omN;
    }
}
