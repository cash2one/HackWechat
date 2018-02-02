package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ah extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fWO = "labelID".hashCode();
    private static final int fWP = "labelName".hashCode();
    private static final int fWQ = "labelPYFull".hashCode();
    private static final int fWR = "labelPYShort".hashCode();
    private static final int fWS = "isTemporary".hashCode();
    private boolean fNB = true;
    private boolean fWJ = true;
    private boolean fWK = true;
    private boolean fWL = true;
    private boolean fWM = true;
    private boolean fWN = true;
    public long field_createTime;
    public boolean field_isTemporary;
    public int field_labelID;
    public String field_labelName;
    public String field_labelPYFull;
    public String field_labelPYShort;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fWO == hashCode) {
                    this.field_labelID = cursor.getInt(i);
                    this.fWJ = true;
                } else if (fWP == hashCode) {
                    this.field_labelName = cursor.getString(i);
                } else if (fWQ == hashCode) {
                    this.field_labelPYFull = cursor.getString(i);
                } else if (fWR == hashCode) {
                    this.field_labelPYShort = cursor.getString(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fWS == hashCode) {
                    this.field_isTemporary = cursor.getInt(i) != 0;
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fWJ) {
            contentValues.put("labelID", Integer.valueOf(this.field_labelID));
        }
        if (this.fWK) {
            contentValues.put("labelName", this.field_labelName);
        }
        if (this.fWL) {
            contentValues.put("labelPYFull", this.field_labelPYFull);
        }
        if (this.fWM) {
            contentValues.put("labelPYShort", this.field_labelPYShort);
        }
        if (this.fNB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fWN) {
            contentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
