package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dd extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPd = "key".hashCode();
    private static final int gpw = "position".hashCode();
    private boolean fPc = true;
    public String field_key;
    public int field_position;
    private boolean gpp = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPd == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.fPc = true;
                } else if (gpw == hashCode) {
                    this.field_position = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPc) {
            contentValues.put("key", this.field_key);
        }
        if (this.gpp) {
            contentValues.put("position", Integer.valueOf(this.field_position));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
