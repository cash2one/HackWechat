package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class l extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandStarAppUpdateTimeIndex ON AppBrandStarApp(updateTime)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fPq = "versionType".hashCode();
    private static final int fPr = "updateTime".hashCode();
    private static final int fPt = "username".hashCode();
    private boolean fPm = true;
    private boolean fPn = true;
    private boolean fPs = true;
    public long field_updateTime;
    public String field_username;
    public int field_versionType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (fPq == hashCode) {
                    this.field_versionType = cursor.getInt(i);
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
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.fPm) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
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
