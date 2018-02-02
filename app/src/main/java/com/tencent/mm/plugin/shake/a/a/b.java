package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class b extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int qnv = "lastshaketime".hashCode();
    private static final int qnw = "isshowed".hashCode();
    private boolean fPs;
    public boolean field_isshowed;
    public int field_lastshaketime;
    public String field_username;
    private boolean qnt;
    private boolean qnu;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPs = true;
                } else if (qnv == hashCode) {
                    this.field_lastshaketime = cursor.getInt(i);
                } else if (qnw == hashCode) {
                    this.field_isshowed = cursor.getInt(i) != 0;
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
        if (this.qnt) {
            contentValues.put("lastshaketime", Integer.valueOf(this.field_lastshaketime));
        }
        if (this.qnu) {
            contentValues.put("isshowed", Boolean.valueOf(this.field_isshowed));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
