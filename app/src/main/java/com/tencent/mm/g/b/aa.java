package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aa extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fTM = "canvasId".hashCode();
    private static final int fTN = "canvasXml".hashCode();
    private boolean fNB = true;
    private boolean fTK = true;
    private boolean fTL = true;
    public long field_canvasId;
    public String field_canvasXml;
    public long field_createTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fTM == hashCode) {
                    this.field_canvasId = cursor.getLong(i);
                    this.fTK = true;
                } else if (fTN == hashCode) {
                    this.field_canvasXml = cursor.getString(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fTK) {
            contentValues.put("canvasId", Long.valueOf(this.field_canvasId));
        }
        if (this.fTL) {
            contentValues.put("canvasXml", this.field_canvasXml);
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
