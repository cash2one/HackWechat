package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dl extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int gqL = "tableHash".hashCode();
    private static final int gqM = "tableSQLMD5".hashCode();
    public int field_tableHash;
    public String field_tableSQLMD5;
    private boolean gqJ = true;
    private boolean gqK = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gqL == hashCode) {
                    this.field_tableHash = cursor.getInt(i);
                    this.gqJ = true;
                } else if (gqM == hashCode) {
                    this.field_tableSQLMD5 = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gqJ) {
            contentValues.put("tableHash", Integer.valueOf(this.field_tableHash));
        }
        if (this.gqK) {
            contentValues.put("tableSQLMD5", this.field_tableSQLMD5);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
