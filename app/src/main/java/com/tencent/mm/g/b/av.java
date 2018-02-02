package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class av extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fQm = "modifyTime".hashCode();
    private static final int fRk = "flag".hashCode();
    private static final int gac = "prodcutID".hashCode();
    private static final int gad = "totalCount".hashCode();
    private static final int gae = "continuCount".hashCode();
    private static final int gaf = "showTipsTime".hashCode();
    private static final int gag = "setFlagTime".hashCode();
    private boolean fPP = true;
    private boolean fRi = true;
    private boolean fZX = true;
    private boolean fZY = true;
    private boolean fZZ = true;
    public int field_continuCount;
    public int field_flag;
    public long field_modifyTime;
    public String field_prodcutID;
    public long field_setFlagTime;
    public long field_showTipsTime;
    public int field_totalCount;
    private boolean gaa = true;
    private boolean gab = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gac == hashCode) {
                    this.field_prodcutID = cursor.getString(i);
                    this.fZX = true;
                } else if (gad == hashCode) {
                    this.field_totalCount = cursor.getInt(i);
                } else if (gae == hashCode) {
                    this.field_continuCount = cursor.getInt(i);
                } else if (fRk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (fQm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (gaf == hashCode) {
                    this.field_showTipsTime = cursor.getLong(i);
                } else if (gag == hashCode) {
                    this.field_setFlagTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fZX) {
            contentValues.put("prodcutID", this.field_prodcutID);
        }
        if (this.fZY) {
            contentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
        }
        if (this.fZZ) {
            contentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
        }
        if (this.fRi) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fPP) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.gaa) {
            contentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
        }
        if (this.gab) {
            contentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
