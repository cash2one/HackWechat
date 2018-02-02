package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ak extends c {
    public static final String[] fMK = new String[0];
    private static final int fMS = "msgId".hashCode();
    private static final int fMT = "rowid".hashCode();
    private static final int fXy = "transferId".hashCode();
    private boolean fMO = true;
    private boolean fXx = true;
    public long field_msgId;
    public String field_transferId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fMS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.fMO = true;
                } else if (fXy == hashCode) {
                    this.field_transferId = cursor.getString(i);
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
        if (this.fXx) {
            contentValues.put("transferId", this.field_transferId);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
