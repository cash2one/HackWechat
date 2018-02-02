package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class z extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fPr = "updateTime".hashCode();
    private static final int fQt = "openId".hashCode();
    private static final int fTG = "brandUsername".hashCode();
    private static final int fTH = "headImgUrl".hashCode();
    private static final int fTI = "nickname".hashCode();
    private static final int fTJ = "kfType".hashCode();
    private boolean fPW = true;
    private boolean fPn = true;
    private boolean fTC = true;
    private boolean fTD = true;
    private boolean fTE = true;
    private boolean fTF = true;
    public String field_brandUsername;
    public String field_headImgUrl;
    public int field_kfType;
    public String field_nickname;
    public String field_openId;
    public long field_updateTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fQt == hashCode) {
                    this.field_openId = cursor.getString(i);
                    this.fPW = true;
                } else if (fTG == hashCode) {
                    this.field_brandUsername = cursor.getString(i);
                } else if (fTH == hashCode) {
                    this.field_headImgUrl = cursor.getString(i);
                } else if (fTI == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (fTJ == hashCode) {
                    this.field_kfType = cursor.getInt(i);
                } else if (fPr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fPW) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.field_brandUsername == null) {
            this.field_brandUsername = "";
        }
        if (this.fTC) {
            contentValues.put("brandUsername", this.field_brandUsername);
        }
        if (this.fTD) {
            contentValues.put("headImgUrl", this.field_headImgUrl);
        }
        if (this.fTE) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.fTF) {
            contentValues.put("kfType", Integer.valueOf(this.field_kfType));
        }
        if (this.fPn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
