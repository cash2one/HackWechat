package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ed extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int gek = "expireTime".hashCode();
    private static final int gvc = "host".hashCode();
    public long field_expireTime;
    public String field_host;
    private boolean geb = true;
    private boolean gvb = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gvc == hashCode) {
                    this.field_host = cursor.getString(i);
                } else if (gek == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gvb) {
            contentValues.put("host", this.field_host);
        }
        if (this.geb) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
