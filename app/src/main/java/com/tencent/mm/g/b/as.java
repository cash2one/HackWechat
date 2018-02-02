package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class as extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOf = "content".hashCode();
    private static final int fZU = "designerIDAndType".hashCode();
    private boolean fNJ = true;
    private boolean fZT = true;
    public byte[] field_content;
    public String field_designerIDAndType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fZU == hashCode) {
                    this.field_designerIDAndType = cursor.getString(i);
                    this.fZT = true;
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fZT) {
            contentValues.put("designerIDAndType", this.field_designerIDAndType);
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
