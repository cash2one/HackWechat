package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class bf extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNj = DownloadSettingTable$Columns.VALUE.hashCode();
    private static final int fPd = "key".hashCode();
    private static final int fQm = "modifyTime".hashCode();
    private boolean fNb = true;
    private boolean fPP = true;
    private boolean fPc = true;
    public String field_key;
    public long field_modifyTime;
    public String field_value;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPd == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.fPc = true;
                } else if (fNj == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (fQm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
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
        if (this.fNb) {
            contentValues.put(DownloadSettingTable$Columns.VALUE, this.field_value);
        }
        if (this.fPP) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
