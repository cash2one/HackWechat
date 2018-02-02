package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cv extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fZp = "name".hashCode();
    private static final int ggW = "createtime".hashCode();
    private static final int gnK = "uid".hashCode();
    private static final int gnL = "devicetype".hashCode();
    private boolean fYQ = true;
    public long field_createtime;
    public String field_devicetype;
    public String field_name;
    public String field_uid;
    private boolean ggR = true;
    private boolean gnI = true;
    private boolean gnJ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gnK == hashCode) {
                    this.field_uid = cursor.getString(i);
                    this.gnI = true;
                } else if (fZp == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (gnL == hashCode) {
                    this.field_devicetype = cursor.getString(i);
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
        if (this.field_uid == null) {
            this.field_uid = "";
        }
        if (this.gnI) {
            contentValues.put("uid", this.field_uid);
        }
        if (this.field_name == null) {
            this.field_name = "";
        }
        if (this.fYQ) {
            contentValues.put("name", this.field_name);
        }
        if (this.field_devicetype == null) {
            this.field_devicetype = "";
        }
        if (this.gnJ) {
            contentValues.put("devicetype", this.field_devicetype);
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
