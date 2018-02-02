package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dv extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int geq = "receiveTime".hashCode();
    private static final int gmH = "receiveStatus".hashCode();
    private static final int gtF = "mNativeUrl".hashCode();
    private static final int gtG = "hbType".hashCode();
    private static final int gtH = "receiveAmount".hashCode();
    private static final int gtI = "hbStatus".hashCode();
    public int field_hbStatus;
    public int field_hbType;
    public String field_mNativeUrl;
    public long field_receiveAmount;
    public int field_receiveStatus;
    public long field_receiveTime;
    private boolean geh = true;
    private boolean gmF = true;
    private boolean gtB = true;
    private boolean gtC = true;
    private boolean gtD = true;
    private boolean gtE = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gtF == hashCode) {
                    this.field_mNativeUrl = cursor.getString(i);
                    this.gtB = true;
                } else if (gtG == hashCode) {
                    this.field_hbType = cursor.getInt(i);
                } else if (gtH == hashCode) {
                    this.field_receiveAmount = cursor.getLong(i);
                } else if (geq == hashCode) {
                    this.field_receiveTime = cursor.getLong(i);
                } else if (gmH == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i);
                } else if (gtI == hashCode) {
                    this.field_hbStatus = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gtB) {
            contentValues.put("mNativeUrl", this.field_mNativeUrl);
        }
        if (this.gtC) {
            contentValues.put("hbType", Integer.valueOf(this.field_hbType));
        }
        if (this.gtD) {
            contentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
        }
        if (this.geh) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.gmF) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.gtE) {
            contentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
