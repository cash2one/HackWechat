package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class o extends c {
    public static final String[] fMK = new String[0];
    private static final int fMS = "msgId".hashCode();
    private static final int fMT = "rowid".hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fRe = "xml".hashCode();
    private static final int fRf = "title".hashCode();
    private static final int fRg = "description".hashCode();
    private static final int fRh = "source".hashCode();
    private boolean fMO = true;
    private boolean fNE = true;
    private boolean fOu = true;
    private boolean fRa = true;
    private boolean fRb = true;
    private boolean fRc = true;
    private boolean fRd = true;
    public String field_appId;
    public String field_description;
    public long field_msgId;
    public String field_source;
    public String field_title;
    public int field_type;
    public String field_xml;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fMS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.fMO = true;
                } else if (fRe == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fRf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (fRg == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (fRh == hashCode) {
                    this.field_source = cursor.getString(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fMO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.fRa) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fRb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fRc) {
            contentValues.put("description", this.field_description);
        }
        if (this.fRd) {
            contentValues.put("source", this.field_source);
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
