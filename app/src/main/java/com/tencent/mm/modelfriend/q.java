package com.tencent.mm.modelfriend;

import android.content.ContentValues;

public final class q {
    int fDt = -1;
    private int hhl = 0;
    private String hhn = "";
    private String hho = "";
    public int hpd = 0;
    public int hwn = 0;
    private int hwo = 0;
    public String username = "";

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("friendtype", Integer.valueOf(this.hwn));
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("updatetime", Integer.valueOf(this.hpd));
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.hhl));
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.hwo));
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("reserved3", this.hhn == null ? "" : this.hhn);
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("reserved4", this.hho == null ? "" : this.hho);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
