package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ce extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fRf = "title".hashCode();
    private static final int gjf = "loan_jump_url".hashCode();
    private static final int gjg = "red_dot_index".hashCode();
    private static final int gjh = "is_show_entry".hashCode();
    private static final int gji = "tips".hashCode();
    private static final int gjj = "is_overdue".hashCode();
    private static final int gjk = "available_otb".hashCode();
    private boolean fRb = true;
    public String field_available_otb;
    public int field_is_overdue;
    public int field_is_show_entry;
    public String field_loan_jump_url;
    public int field_red_dot_index;
    public String field_tips;
    public String field_title;
    private boolean giZ = true;
    private boolean gja = true;
    private boolean gjb = true;
    private boolean gjc = true;
    private boolean gjd = true;
    private boolean gje = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fRf == hashCode) {
                    this.field_title = cursor.getString(i);
                    this.fRb = true;
                } else if (gjf == hashCode) {
                    this.field_loan_jump_url = cursor.getString(i);
                } else if (gjg == hashCode) {
                    this.field_red_dot_index = cursor.getInt(i);
                } else if (gjh == hashCode) {
                    this.field_is_show_entry = cursor.getInt(i);
                } else if (gji == hashCode) {
                    this.field_tips = cursor.getString(i);
                } else if (gjj == hashCode) {
                    this.field_is_overdue = cursor.getInt(i);
                } else if (gjk == hashCode) {
                    this.field_available_otb = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fRb) {
            contentValues.put("title", this.field_title);
        }
        if (this.giZ) {
            contentValues.put("loan_jump_url", this.field_loan_jump_url);
        }
        if (this.gja) {
            contentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
        }
        if (this.gjb) {
            contentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
        }
        if (this.gjc) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.gjd) {
            contentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
        }
        if (this.gje) {
            contentValues.put("available_otb", this.field_available_otb);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
