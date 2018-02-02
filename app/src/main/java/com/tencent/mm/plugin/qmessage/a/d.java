package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

public final class d {
    String extInfo = "";
    public int fDt = -1;
    int hhl = 0;
    int hlu = 0;
    int hlv = 0;
    long hwR = 0;
    int hwo = 0;
    public int pnt = 0;
    public long pnu = 0;
    public long pnv = 0;
    String pnw = "";
    String pnx = "";
    String pny = "";
    String pnz = "";
    public String username = "";

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("qq", Long.valueOf(this.hwR));
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("extinfo", bjW());
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.pnt));
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("extupdateseq", Long.valueOf(this.pnu));
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("imgupdateseq", Long.valueOf(this.pnv));
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.hhl));
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.hwo));
        }
        if ((this.fDt & 256) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hlu));
        }
        if ((this.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hlv));
        }
        if ((this.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved5", this.pnw == null ? "" : this.pnw);
        }
        if ((this.fDt & 2048) != 0) {
            contentValues.put("reserved6", this.pnx == null ? "" : this.pnx);
        }
        if ((this.fDt & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("reserved7", this.pny == null ? "" : this.pny);
        }
        if ((this.fDt & 8192) != 0) {
            contentValues.put("reserved8", this.pnz == null ? "" : this.pnz);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String bjW() {
        return this.extInfo == null ? "" : this.extInfo;
    }
}
