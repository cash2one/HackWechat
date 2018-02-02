package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dw extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int gtN = "pref_key".hashCode();
    private static final int gtO = "pref_title".hashCode();
    private static final int gtP = "pref_url".hashCode();
    private static final int gtQ = "is_show".hashCode();
    public int field_is_show;
    public String field_pref_key;
    public String field_pref_title;
    public String field_pref_url;
    private boolean gtJ = true;
    private boolean gtK = true;
    private boolean gtL = true;
    private boolean gtM = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gtN == hashCode) {
                    this.field_pref_key = cursor.getString(i);
                    this.gtJ = true;
                } else if (gtO == hashCode) {
                    this.field_pref_title = cursor.getString(i);
                } else if (gtP == hashCode) {
                    this.field_pref_url = cursor.getString(i);
                } else if (gtQ == hashCode) {
                    this.field_is_show = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gtJ) {
            contentValues.put("pref_key", this.field_pref_key);
        }
        if (this.gtK) {
            contentValues.put("pref_title", this.field_pref_title);
        }
        if (this.gtL) {
            contentValues.put("pref_url", this.field_pref_url);
        }
        if (this.gtM) {
            contentValues.put("is_show", Integer.valueOf(this.field_is_show));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
