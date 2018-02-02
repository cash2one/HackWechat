package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class dh extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fNj = DownloadSettingTable$Columns.VALUE.hashCode();
    private static final int fOR = "offset".hashCode();
    private static final int gqs = "logtime".hashCode();
    private static final int gqt = "logsize".hashCode();
    private static final int gqu = "errorcount".hashCode();
    private boolean fNb = true;
    private boolean fOA = true;
    public int field_errorcount;
    public int field_logsize;
    public long field_logtime;
    public int field_offset;
    public byte[] field_value;
    private boolean gqp = true;
    private boolean gqq = true;
    private boolean gqr = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gqs == hashCode) {
                    this.field_logtime = cursor.getLong(i);
                } else if (fOR == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (gqt == hashCode) {
                    this.field_logsize = cursor.getInt(i);
                } else if (gqu == hashCode) {
                    this.field_errorcount = cursor.getInt(i);
                } else if (fNj == hashCode) {
                    this.field_value = cursor.getBlob(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gqp) {
            contentValues.put("logtime", Long.valueOf(this.field_logtime));
        }
        if (this.fOA) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.gqq) {
            contentValues.put("logsize", Integer.valueOf(this.field_logsize));
        }
        if (this.gqr) {
            contentValues.put("errorcount", Integer.valueOf(this.field_errorcount));
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
