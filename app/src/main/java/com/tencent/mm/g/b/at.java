package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class at extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOf = "content".hashCode();
    private static final int fYl = "productID".hashCode();
    private static final int fZW = "lan".hashCode();
    private boolean fNJ = true;
    private boolean fXL = true;
    private boolean fZV = true;
    public byte[] field_content;
    public String field_lan;
    public String field_productID;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fYl == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.fXL = true;
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (fZW == hashCode) {
                    this.field_lan = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fXL) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.fNJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_lan == null) {
            this.field_lan = "";
        }
        if (this.fZV) {
            contentValues.put("lan", this.field_lan);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
