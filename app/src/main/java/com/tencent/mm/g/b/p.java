package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class p extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fRk = "flag".hashCode();
    private static final int fRl = "sortId".hashCode();
    private boolean fOu = true;
    private boolean fRi = true;
    private boolean fRj = true;
    public String field_appId;
    public long field_flag;
    public int field_sortId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fRk == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fRl == hashCode) {
                    this.field_sortId = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fRi) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fRj) {
            contentValues.put("sortId", Integer.valueOf(this.field_sortId));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
