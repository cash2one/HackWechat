package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ai extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fWV = "labelId".hashCode();
    private static final int fWW = "contactName".hashCode();
    private boolean fWT;
    private boolean fWU;
    public String field_contactName;
    public String field_labelId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fWV == hashCode) {
                    this.field_labelId = cursor.getString(i);
                } else if (fWW == hashCode) {
                    this.field_contactName = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fWT) {
            contentValues.put("labelId", this.field_labelId);
        }
        if (this.fWU) {
            contentValues.put("contactName", this.field_contactName);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
