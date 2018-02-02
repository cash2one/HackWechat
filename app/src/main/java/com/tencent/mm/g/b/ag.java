package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ag extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int fWI = "cmdbuf".hashCode();
    private boolean fPs = true;
    private boolean fWH = true;
    public byte[] field_cmdbuf;
    public String field_username;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPs = true;
                } else if (fWI == hashCode) {
                    this.field_cmdbuf = cursor.getBlob(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.fWH) {
            contentValues.put("cmdbuf", this.field_cmdbuf);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
