package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dq extends c {
    public static final String[] fMK = new String[0];
    private static final int fMS = "msgId".hashCode();
    private static final int fMT = "rowid".hashCode();
    private static final int fOf = "content".hashCode();
    private static final int grC = "cmsgId".hashCode();
    private boolean fMO = true;
    private boolean fNJ = true;
    public String field_cmsgId;
    public String field_content;
    public long field_msgId;
    private boolean grB = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fMS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.fMO = true;
                } else if (grC == hashCode) {
                    this.field_cmsgId = cursor.getString(i);
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fMO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.grB) {
            contentValues.put("cmsgId", this.field_cmsgId);
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.fNJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
