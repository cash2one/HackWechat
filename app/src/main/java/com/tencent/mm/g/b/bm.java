package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bm extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int get = "reqType".hashCode();
    private static final int geu = "cache".hashCode();
    public byte[] field_cache;
    public String field_reqType;
    private boolean ger = true;
    private boolean ges = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (get == hashCode) {
                    this.field_reqType = cursor.getString(i);
                    this.ger = true;
                } else if (geu == hashCode) {
                    this.field_cache = cursor.getBlob(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.ger) {
            contentValues.put("reqType", this.field_reqType);
        }
        if (this.ges) {
            contentValues.put("cache", this.field_cache);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
