package com.tencent.mm.az;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.FileUtils;

public final class m {
    int fDt = -1;
    private String fus = (this.id + "_" + this.fvM);
    public int fvM = 0;
    String hJL = "";
    private String hls = "";
    private String hlt = "";
    private int hlu = 0;
    private int hlv = 0;
    public int id = 0;
    String name = "";
    int size = 0;
    public int status = 0;
    public int version = 0;

    public final void b(Cursor cursor) {
        this.version = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.size = cursor.getInt(4);
        this.hJL = cursor.getString(5);
        this.status = cursor.getInt(6);
        this.hls = cursor.getString(8);
        this.hlt = cursor.getString(9);
        this.fvM = cursor.getInt(7);
        this.hlv = cursor.getInt(11);
        this.id = cursor.getInt(1);
        this.hlu = cursor.getInt(10);
        this.fus = cursor.getString(0);
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if ((this.fDt & 2) != 0) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.id));
        }
        if ((this.fDt & 4) != 0) {
            contentValues.put("version", Integer.valueOf(this.version));
        }
        if ((this.fDt & 8) != 0) {
            contentValues.put("name", this.name == null ? "" : this.name);
        }
        if ((this.fDt & 16) != 0) {
            contentValues.put("size", Integer.valueOf(this.size));
        }
        if ((this.fDt & 32) != 0) {
            contentValues.put("packname", QD());
        }
        if ((this.fDt & 64) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.fDt & FileUtils.S_IWUSR) != 0) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.fvM));
        }
        if ((this.fDt & 256) != 0) {
            contentValues.put("reserved1", this.hls == null ? "" : this.hls);
        }
        if ((this.fDt & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved2", this.hlt == null ? "" : this.hlt);
        }
        if ((this.fDt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hlu));
        }
        if ((this.fDt & 2048) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hlv));
        }
        if ((this.fDt & 1) != 0) {
            contentValues.put("localId", this.id + "_" + this.fvM);
        }
        return contentValues;
    }

    public final String QD() {
        return this.hJL == null ? "" : this.hJL;
    }
}
