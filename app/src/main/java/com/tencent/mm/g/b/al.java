package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class al extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fPq = "versionType".hashCode();
    private static final int fXA = "extJson".hashCode();
    private boolean fOu = true;
    private boolean fPm = true;
    private boolean fXz = true;
    public String field_appId;
    public String field_extJson;
    public int field_versionType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fPq == hashCode) {
                    this.field_versionType = cursor.getInt(i);
                } else if (fXA == hashCode) {
                    this.field_extJson = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fPm) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.fXz) {
            contentValues.put("extJson", this.field_extJson);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
