package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class v extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fRJ = "brandUserName".hashCode();
    private static final int fSv = "userId".hashCode();
    private boolean fRv = true;
    private boolean fSu = true;
    public String field_brandUserName;
    public String field_userId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fRJ == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                    this.fRv = true;
                } else if (fSv == hashCode) {
                    this.field_userId = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fRv) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.fSu) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
