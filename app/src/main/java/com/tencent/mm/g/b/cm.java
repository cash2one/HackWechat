package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cm extends c {
    public static final String[] fMK = new String[0];
    private static final int fMS = "msgId".hashCode();
    private static final int fMT = "rowid".hashCode();
    private static final int gem = "isRead".hashCode();
    private static final int gmd = "msgContentXml".hashCode();
    private boolean fMO = true;
    public String field_isRead;
    public String field_msgContentXml;
    public String field_msgId;
    private boolean ged = true;
    private boolean gmc = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fMS == hashCode) {
                    this.field_msgId = cursor.getString(i);
                    this.fMO = true;
                } else if (gmd == hashCode) {
                    this.field_msgContentXml = cursor.getString(i);
                } else if (gem == hashCode) {
                    this.field_isRead = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fMO) {
            contentValues.put("msgId", this.field_msgId);
        }
        if (this.gmc) {
            contentValues.put("msgContentXml", this.field_msgContentXml);
        }
        if (this.ged) {
            contentValues.put("isRead", this.field_isRead);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
