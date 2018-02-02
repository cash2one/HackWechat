package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ec extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPo = "recordId".hashCode();
    private static final int fRf = "title".hashCode();
    private static final int fRh = "source".hashCode();
    private static final int guW = "timeStamp".hashCode();
    private static final int guZ = "link".hashCode();
    private static final int gva = "imgUrl".hashCode();
    private boolean fPk = true;
    private boolean fRb = true;
    private boolean fRd = true;
    public String field_imgUrl;
    public String field_link;
    public String field_recordId;
    public String field_source;
    public long field_timeStamp;
    public String field_title;
    private boolean guU = true;
    private boolean guX = true;
    private boolean guY = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPo == hashCode) {
                    this.field_recordId = cursor.getString(i);
                    this.fPk = true;
                } else if (guZ == hashCode) {
                    this.field_link = cursor.getString(i);
                } else if (fRf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (fRh == hashCode) {
                    this.field_source = cursor.getString(i);
                } else if (gva == hashCode) {
                    this.field_imgUrl = cursor.getString(i);
                } else if (guW == hashCode) {
                    this.field_timeStamp = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPk) {
            contentValues.put("recordId", this.field_recordId);
        }
        if (this.guX) {
            contentValues.put("link", this.field_link);
        }
        if (this.fRb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fRd) {
            contentValues.put("source", this.field_source);
        }
        if (this.guY) {
            contentValues.put("imgUrl", this.field_imgUrl);
        }
        if (this.guU) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
