package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dn extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int fQt = "openId".hashCode();
    private boolean fOu = true;
    private boolean fPW = true;
    private boolean fPs = true;
    public String field_appId;
    public String field_openId;
    public String field_username;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fQt == hashCode) {
                    this.field_openId = cursor.getString(i);
                    this.fPW = true;
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPW) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
