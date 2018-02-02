package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cp extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOs = "scene".hashCode();
    private static final int fPB = "version".hashCode();
    private static final int fPd = "key".hashCode();
    private static final int fPr = "updateTime".hashCode();
    private boolean fOq = true;
    private boolean fPc = true;
    private boolean fPn = true;
    private boolean fPu = true;
    public String field_key;
    public int field_scene;
    public long field_updateTime;
    public int field_version;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPd == hashCode) {
                    this.field_key = cursor.getString(i);
                } else if (fPB == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (fOs == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (fPr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPc) {
            contentValues.put("key", this.field_key);
        }
        if (this.fPu) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.fOq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fPn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
