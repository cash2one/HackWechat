package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ar extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fZO = "desc".hashCode();
    private static final int fZS = "groupID".hashCode();
    private boolean fZK = true;
    private boolean fZR = true;
    public String field_desc;
    public String field_groupID;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fZS == hashCode) {
                    this.field_groupID = cursor.getString(i);
                } else if (fZO == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fZR) {
            contentValues.put("groupID", this.field_groupID);
        }
        if (this.fZK) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
