package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bw extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOf = "content".hashCode();
    private static final int fRU = "msgType".hashCode();
    private static final int fRf = "title".hashCode();
    private static final int gaR = "svrId".hashCode();
    private static final int gem = "isRead".hashCode();
    private static final int ggx = "pushTime".hashCode();
    private static final int ggy = "descUrl".hashCode();
    private boolean fNJ = true;
    private boolean fRG = true;
    private boolean fRb = true;
    public String field_content;
    public String field_descUrl;
    public short field_isRead;
    public int field_msgType;
    public long field_pushTime;
    public long field_svrId;
    public String field_title;
    private boolean gaO = true;
    private boolean ged = true;
    private boolean ggv = true;
    private boolean ggw = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaR == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                    this.gaO = true;
                } else if (gem == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (fRf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (ggx == hashCode) {
                    this.field_pushTime = cursor.getLong(i);
                } else if (fRU == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (ggy == hashCode) {
                    this.field_descUrl = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gaO) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.ged) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.fRb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fNJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.ggv) {
            contentValues.put("pushTime", Long.valueOf(this.field_pushTime));
        }
        if (this.fRG) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.ggw) {
            contentValues.put("descUrl", this.field_descUrl);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
