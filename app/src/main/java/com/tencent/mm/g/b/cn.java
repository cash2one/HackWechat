package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cn extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int gmg = "cardUserId".hashCode();
    private static final int gmh = "retryCount".hashCode();
    public String field_cardUserId;
    public int field_retryCount;
    private boolean gme = true;
    private boolean gmf = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gmg == hashCode) {
                    this.field_cardUserId = cursor.getString(i);
                    this.gme = true;
                } else if (gmh == hashCode) {
                    this.field_retryCount = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gme) {
            contentValues.put("cardUserId", this.field_cardUserId);
        }
        if (this.gmf) {
            contentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
