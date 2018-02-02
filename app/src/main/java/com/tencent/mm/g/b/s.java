package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class s extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNn = "startTime".hashCode();
    private static final int fNo = "endTime".hashCode();
    private static final int fRq = "sessionName".hashCode();
    private boolean fNf = true;
    private boolean fNg = true;
    private boolean fRn = true;
    public long field_endTime;
    public String field_sessionName;
    public long field_startTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fRq == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (fNn == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (fNo == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.fRn) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.fNf) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fNg) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
