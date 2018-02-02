package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.wcdb.FileUtils;

public final class bc {
    int fDt;
    public String name;
    int status;
    public a xzU;
    public int xzV;

    public static class a {
        private String fDC;
        private String fMh;

        public a(String str) {
            int indexOf = str.indexOf("@");
            if (indexOf >= 0) {
                this.fDC = str.substring(0, indexOf);
                this.fMh = str.substring(indexOf);
                return;
            }
            this.fDC = str;
            this.fMh = "";
        }

        public final String XH(String str) {
            return this.fMh != null ? this.fMh : str;
        }
    }

    public bc() {
        this.fDt = com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
        this.name = "";
        this.xzU = null;
        this.xzU = null;
        this.name = "";
        this.status = 0;
        this.xzV = 0;
    }

    public bc(String str, boolean z, int i) {
        this.fDt = com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
        this.name = "";
        this.xzU = null;
        this.xzU = new a(str);
        this.name = str;
        this.status = (z ? 1 : 0) | 2;
        this.xzV = i;
    }

    public final void ge(boolean z) {
        if (z) {
            this.status = (z ? 1 : 0) | this.status;
            return;
        }
        this.status &= -2;
    }

    public final boolean isEnable() {
        return (this.status & 1) != 0;
    }

    public final boolean cjS() {
        return (this.status & 2) != 0;
    }

    public final void b(Cursor cursor) {
        if ((this.fDt & 2) != 0) {
            this.name = cursor.getString(1);
            if (this.xzU == null) {
                this.xzU = new a(this.name);
            }
        }
        if ((this.fDt & 4) != 0) {
            this.status = cursor.getInt(2);
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            this.xzV = cursor.getInt(7);
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 2) != 0) {
            contentValues.put("name", this.name);
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("int_reserved1", Integer.valueOf(this.xzV));
        }
        return contentValues;
    }
}
