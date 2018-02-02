package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class di extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fYK = "count".hashCode();
    private static final int gqA = "memberList".hashCode();
    private static final int gqy = "tagId".hashCode();
    private static final int gqz = "tagName".hashCode();
    private boolean fYk = true;
    public int field_count;
    public String field_memberList;
    public long field_tagId;
    public String field_tagName;
    private boolean gqv = true;
    private boolean gqw = true;
    private boolean gqx = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gqy == hashCode) {
                    this.field_tagId = cursor.getLong(i);
                } else if (gqz == hashCode) {
                    this.field_tagName = cursor.getString(i);
                } else if (fYK == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (gqA == hashCode) {
                    this.field_memberList = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gqv) {
            contentValues.put("tagId", Long.valueOf(this.field_tagId));
        }
        if (this.field_tagName == null) {
            this.field_tagName = "";
        }
        if (this.gqw) {
            contentValues.put("tagName", this.field_tagName);
        }
        if (this.fYk) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.field_memberList == null) {
            this.field_memberList = "";
        }
        if (this.gqx) {
            contentValues.put("memberList", this.field_memberList);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
