package com.tencent.mm.ad;

import android.content.ContentValues;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.FileUtils;

public final class f {
    int fDt = -1;
    int hlm;
    int hln;
    String hlo;
    int hlp;
    int hlq;
    int hlr;
    String hls;
    String hlt;
    int hlu;
    int hlv;
    String username;

    public f() {
        reset();
    }

    public final void reset() {
        this.username = "";
        this.hlm = 0;
        this.hln = 0;
        this.hlo = "";
        this.hlp = 0;
        this.hlq = 0;
        this.hlr = 0;
        this.hls = "";
        this.hlt = "";
        this.hlu = 0;
        this.hlv = 0;
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put("username", this.username == null ? "" : this.username);
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("imgwidth", Integer.valueOf(this.hlm));
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("imgheigth", Integer.valueOf(this.hln));
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("imgformat", JE());
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.hlp));
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("startpos", Integer.valueOf(this.hlq));
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("headimgtype", Integer.valueOf(this.hlr));
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved1", this.hls == null ? "" : this.hls);
        }
        if ((this.fDt & 256) != 0) {
            contentValues.put("reserved2", this.hlt == null ? "" : this.hlt);
        }
        if ((this.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hlu));
        }
        if ((this.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hlv));
        }
        return contentValues;
    }

    public final String JE() {
        return this.hlo == null ? "" : this.hlo;
    }
}
