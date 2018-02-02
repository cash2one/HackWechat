package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class ef extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNj = DownloadSettingTable$Columns.VALUE.hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fPd = "key".hashCode();
    private static final int fPo = "recordId".hashCode();
    private static final int gvs = "domin".hashCode();
    private boolean fNb = true;
    private boolean fOu = true;
    private boolean fPc = true;
    private boolean fPk = true;
    public String field_appId;
    public String field_domin;
    public String field_key;
    public int field_recordId;
    public String field_value;
    private boolean gvr = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPo == hashCode) {
                    this.field_recordId = cursor.getInt(i);
                    this.fPk = true;
                } else if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gvs == hashCode) {
                    this.field_domin = cursor.getString(i);
                } else if (fPd == hashCode) {
                    this.field_key = cursor.getString(i);
                } else if (fNj == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPk) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gvr) {
            contentValues.put("domin", this.field_domin);
        }
        if (this.fPc) {
            contentValues.put("key", this.field_key);
        }
        if (this.fNb) {
            contentValues.put(DownloadSettingTable$Columns.VALUE, this.field_value);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
