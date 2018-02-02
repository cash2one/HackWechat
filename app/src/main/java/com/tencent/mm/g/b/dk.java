package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dk extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fVQ = "conRemark".hashCode();
    private static final int fWa = "encryptUsername".hashCode();
    private static final int gqG = "contactLabels".hashCode();
    private static final int gqH = "conDescription".hashCode();
    private static final int gqI = "conPhone".hashCode();
    private boolean fVB = true;
    private boolean fVL = true;
    public String field_conDescription;
    public String field_conPhone;
    public String field_conRemark;
    public String field_contactLabels;
    public String field_encryptUsername;
    private boolean gqD = true;
    private boolean gqE = true;
    private boolean gqF = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fWa == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                    this.fVL = true;
                } else if (fVQ == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (gqG == hashCode) {
                    this.field_contactLabels = cursor.getString(i);
                } else if (gqH == hashCode) {
                    this.field_conDescription = cursor.getString(i);
                } else if (gqI == hashCode) {
                    this.field_conPhone = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.fVL) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.fVB) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_contactLabels == null) {
            this.field_contactLabels = "";
        }
        if (this.gqD) {
            contentValues.put("contactLabels", this.field_contactLabels);
        }
        if (this.field_conDescription == null) {
            this.field_conDescription = "";
        }
        if (this.gqE) {
            contentValues.put("conDescription", this.field_conDescription);
        }
        if (this.field_conPhone == null) {
            this.field_conPhone = "";
        }
        if (this.gqF) {
            contentValues.put("conPhone", this.field_conPhone);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
