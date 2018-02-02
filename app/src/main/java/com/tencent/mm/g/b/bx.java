package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bx extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int ggC = "countryCode".hashCode();
    private static final int ggD = "callTimeCount".hashCode();
    private static final int ggE = "lastCallTime".hashCode();
    public long field_callTimeCount;
    public int field_countryCode;
    public long field_lastCallTime;
    private boolean ggA = true;
    private boolean ggB = true;
    private boolean ggz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggC == hashCode) {
                    this.field_countryCode = cursor.getInt(i);
                    this.ggz = true;
                } else if (ggD == hashCode) {
                    this.field_callTimeCount = cursor.getLong(i);
                } else if (ggE == hashCode) {
                    this.field_lastCallTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.ggz) {
            contentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
        }
        if (this.ggA) {
            contentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
        }
        if (this.ggB) {
            contentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
