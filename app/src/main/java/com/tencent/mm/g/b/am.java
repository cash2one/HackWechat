package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class am extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fXD = "bakLogId".hashCode();
    private static final int fXE = "valueStr".hashCode();
    private boolean fXB;
    private boolean fXC;
    public int field_bakLogId;
    public String field_valueStr;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fXD == hashCode) {
                    this.field_bakLogId = cursor.getInt(i);
                } else if (fXE == hashCode) {
                    this.field_valueStr = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fXB) {
            contentValues.put("bakLogId", Integer.valueOf(this.field_bakLogId));
        }
        if (this.fXC) {
            contentValues.put("valueStr", this.field_valueStr);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
