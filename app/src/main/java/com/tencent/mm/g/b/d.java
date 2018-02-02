package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class d extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNk = "expId".hashCode();
    private static final int fNl = "sequence".hashCode();
    private static final int fNm = "prioritylevel".hashCode();
    private static final int fNn = "startTime".hashCode();
    private static final int fNo = "endTime".hashCode();
    private static final int fNu = "layerId".hashCode();
    private static final int fNv = "business".hashCode();
    private static final int fNw = "needReport".hashCode();
    private static final int fNx = "rawXML".hashCode();
    private boolean fNc = true;
    private boolean fNd = true;
    private boolean fNe = true;
    private boolean fNf = true;
    private boolean fNg = true;
    private boolean fNq = true;
    private boolean fNr = true;
    private boolean fNs = true;
    private boolean fNt = true;
    public String field_business;
    public long field_endTime;
    public String field_expId;
    public String field_layerId;
    public boolean field_needReport;
    public int field_prioritylevel;
    public String field_rawXML;
    public long field_sequence;
    public long field_startTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNu == hashCode) {
                    this.field_layerId = cursor.getString(i);
                    this.fNq = true;
                } else if (fNv == hashCode) {
                    this.field_business = cursor.getString(i);
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
                } else if (fNw == hashCode) {
                    this.field_needReport = cursor.getInt(i) != 0;
                } else if (fNx == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fNq) {
            contentValues.put("layerId", this.field_layerId);
        }
        if (this.fNr) {
            contentValues.put("business", this.field_business);
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
        if (this.fNs) {
            contentValues.put("needReport", Boolean.valueOf(this.field_needReport));
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.fNt) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
