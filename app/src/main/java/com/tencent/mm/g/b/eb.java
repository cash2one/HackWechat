package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class eb extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNj = DownloadSettingTable$Columns.VALUE.hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fPj = "size".hashCode();
    private static final int gek = "expireTime".hashCode();
    private static final int gep = "weight".hashCode();
    private static final int guV = "appIdKey".hashCode();
    private static final int guW = "timeStamp".hashCode();
    private boolean fNb = true;
    private boolean fOu = true;
    private boolean fPg = true;
    public String field_appId;
    public String field_appIdKey;
    public long field_expireTime;
    public long field_size;
    public long field_timeStamp;
    public String field_value;
    public String field_weight;
    private boolean geb = true;
    private boolean geg = true;
    private boolean guT = true;
    private boolean guU = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (guV == hashCode) {
                    this.field_appIdKey = cursor.getString(i);
                    this.guT = true;
                } else if (fNj == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (gep == hashCode) {
                    this.field_weight = cursor.getString(i);
                } else if (gek == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (guW == hashCode) {
                    this.field_timeStamp = cursor.getLong(i);
                } else if (fPj == hashCode) {
                    this.field_size = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.guT) {
            contentValues.put("appIdKey", this.field_appIdKey);
        }
        if (this.fNb) {
            contentValues.put(DownloadSettingTable$Columns.VALUE, this.field_value);
        }
        if (this.geg) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.geb) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.guU) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.fPg) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
