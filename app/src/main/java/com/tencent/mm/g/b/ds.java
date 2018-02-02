package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ds extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int gtc = "bulletin_scene".hashCode();
    private static final int gtd = "bulletin_content".hashCode();
    private static final int gte = "bulletin_url".hashCode();
    public String field_bulletin_content;
    public String field_bulletin_scene;
    public String field_bulletin_url;
    private boolean gsZ = true;
    private boolean gta = true;
    private boolean gtb = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gtc == hashCode) {
                    this.field_bulletin_scene = cursor.getString(i);
                    this.gsZ = true;
                } else if (gtd == hashCode) {
                    this.field_bulletin_content = cursor.getString(i);
                } else if (gte == hashCode) {
                    this.field_bulletin_url = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gsZ) {
            contentValues.put("bulletin_scene", this.field_bulletin_scene);
        }
        if (this.gta) {
            contentValues.put("bulletin_content", this.field_bulletin_content);
        }
        if (this.gtb) {
            contentValues.put("bulletin_url", this.field_bulletin_url);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
