package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bs extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fRf = "title".hashCode();
    private static final int ggb = "appusername".hashCode();
    private static final int gge = "score".hashCode();
    private boolean fRb;
    public String field_appusername;
    public int field_score;
    public String field_title;
    private boolean gfY;
    private boolean ggd;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggb == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (fRf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (gge == hashCode) {
                    this.field_score = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gfY) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.fRb) {
            contentValues.put("title", this.field_title);
        }
        if (this.ggd) {
            contentValues.put("score", Integer.valueOf(this.field_score));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
