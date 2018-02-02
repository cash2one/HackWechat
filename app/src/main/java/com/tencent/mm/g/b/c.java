package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class c extends com.tencent.mm.sdk.e.c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNi = "abtestkey".hashCode();
    private static final int fNj = DownloadSettingTable$Columns.VALUE.hashCode();
    private static final int fNk = "expId".hashCode();
    private static final int fNl = "sequence".hashCode();
    private static final int fNm = "prioritylevel".hashCode();
    private static final int fNn = "startTime".hashCode();
    private static final int fNo = "endTime".hashCode();
    private static final int fNp = "noReport".hashCode();
    private boolean fNa = true;
    private boolean fNb = true;
    private boolean fNc = true;
    private boolean fNd = true;
    private boolean fNe = true;
    private boolean fNf = true;
    private boolean fNg = true;
    private boolean fNh = true;
    public String field_abtestkey;
    public long field_endTime;
    public String field_expId;
    public boolean field_noReport;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_startTime;
    public String field_value;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNi == hashCode) {
                    this.field_abtestkey = cursor.getString(i);
                    this.fNa = true;
                } else if (fNj == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (fNk == hashCode) {
                    this.field_expId = cursor.getString(i);
                } else if (fNl == hashCode) {
                    this.field_sequence = cursor.getLong(i);
                } else if (fNm == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i);
                } else if (fNn == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (fNo == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (fNp == hashCode) {
                    this.field_noReport = cursor.getInt(i) != 0;
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fNa) {
            contentValues.put("abtestkey", this.field_abtestkey);
        }
        if (this.fNb) {
            contentValues.put(DownloadSettingTable$Columns.VALUE, this.field_value);
        }
        if (this.fNc) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.fNd) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.fNe) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.fNf) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fNg) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.fNh) {
            contentValues.put("noReport", Boolean.valueOf(this.field_noReport));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
