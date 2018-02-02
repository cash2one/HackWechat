package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.FileUtils;

public final class h {
    String bgo = "";
    int fDt = -1;
    int fWf = 0;
    public long fWh = 0;
    private String fWi = "";
    int fWo = 0;
    String fWp = "";
    String fWq = "";
    String gfN = "";
    String hvM = "";
    int hvN = 0;
    String hvm = "";
    String hvn = "";
    String signature = "";
    public int status = 0;
    private int type = 0;
    String username = "";

    public final void b(Cursor cursor) {
        this.fWh = cursor.getLong(0);
        this.hvM = cursor.getString(1);
        this.hvN = cursor.getInt(2);
        this.status = cursor.getInt(3);
        this.username = cursor.getString(4);
        this.bgo = cursor.getString(5);
        this.hvm = cursor.getString(6);
        this.hvn = cursor.getString(7);
        this.fWf = cursor.getInt(8);
        this.fWo = cursor.getInt(9);
        this.fWp = cursor.getString(10);
        this.fWq = cursor.getString(11);
        this.signature = cursor.getString(12);
        this.gfN = cursor.getString(13);
        this.type = cursor.getInt(14);
        this.fWi = cursor.getString(15);
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 1) != 0) {
            contentValues.put("fbid", Long.valueOf(this.fWh));
        }
        if ((this.fDt & 2) != 0) {
            contentValues.put("fbname", NF());
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("fbimgkey", Integer.valueOf(this.hvN));
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("nickname", Nw());
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put("nicknamepyinitial", this.hvm == null ? "" : this.hvm);
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put("nicknamequanpin", this.hvn == null ? "" : this.hvn);
        }
        if ((this.fDt & 256) != 0) {
            contentValues.put("sex", Integer.valueOf(this.fWf));
        }
        if ((this.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.fWo));
        }
        if ((this.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("province", this.fWp == null ? "" : this.fWp);
        }
        if ((this.fDt & 2048) != 0) {
            contentValues.put("city", this.fWq == null ? "" : this.fWq);
        }
        if ((this.fDt & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("signature", this.signature == null ? "" : this.signature);
        }
        if ((this.fDt & 8192) != 0) {
            contentValues.put("alias", this.gfN == null ? "" : this.gfN);
        }
        if ((this.fDt & 16384) != 0) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.type));
        }
        if ((this.fDt & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("email", this.fWi == null ? "" : this.fWi);
        }
        return contentValues;
    }

    public final String NF() {
        return this.hvM == null ? "" : this.hvM;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String Nw() {
        return this.bgo == null ? "" : this.bgo;
    }
}
