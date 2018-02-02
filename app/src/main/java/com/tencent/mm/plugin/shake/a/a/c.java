package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c extends com.tencent.mm.sdk.e.c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPt = "username".hashCode();
    private static final int fRf = "title".hashCode();
    private static final int ggW = "createtime".hashCode();
    private static final int qnA = "iconurl".hashCode();
    private static final int qnz = "deeplink".hashCode();
    private boolean fPs = true;
    private boolean fRb = true;
    public long field_createtime;
    public String field_deeplink;
    public String field_iconurl;
    public String field_title;
    public String field_username;
    private boolean ggR = true;
    private boolean qnx = true;
    private boolean qny = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPs = true;
                } else if (qnz == hashCode) {
                    this.field_deeplink = cursor.getString(i);
                } else if (fRf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (qnA == hashCode) {
                    this.field_iconurl = cursor.getString(i);
                } else if (ggW == hashCode) {
                    this.field_createtime = cursor.getLong(i);
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
        if (this.field_deeplink == null) {
            this.field_deeplink = "";
        }
        if (this.qnx) {
            contentValues.put("deeplink", this.field_deeplink);
        }
        if (this.field_title == null) {
            this.field_title = "";
        }
        if (this.fRb) {
            contentValues.put("title", this.field_title);
        }
        if (this.field_iconurl == null) {
            this.field_iconurl = "";
        }
        if (this.qny) {
            contentValues.put("iconurl", this.field_iconurl);
        }
        if (this.ggR) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
