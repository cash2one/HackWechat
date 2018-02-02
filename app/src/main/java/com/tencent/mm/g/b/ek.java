package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ek extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int giK = "appIdHash".hashCode();
    private static final int gwI = "openDebug".hashCode();
    private boolean fOu = true;
    public String field_appId;
    public int field_appIdHash;
    public boolean field_openDebug;
    private boolean giF = true;
    private boolean gwH = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (giK == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                    this.giF = true;
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gwI == hashCode) {
                    this.field_openDebug = cursor.getInt(i) != 0;
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.giF) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gwH) {
            contentValues.put("openDebug", Boolean.valueOf(this.field_openDebug));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
