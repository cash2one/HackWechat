package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class el extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fPG = "debugType".hashCode();
    private static final int gwQ = "RecordId".hashCode();
    private static final int gwR = "AppId".hashCode();
    private static final int gwS = "AppName".hashCode();
    private static final int gwT = "UserName".hashCode();
    private static final int gwU = "IconUrl".hashCode();
    private static final int gwV = "BriefIntro".hashCode();
    private static final int gwW = "isSync".hashCode();
    private boolean fNB = true;
    private boolean fPz = true;
    public String field_AppId;
    public String field_AppName;
    public String field_BriefIntro;
    public String field_IconUrl;
    public String field_RecordId;
    public String field_UserName;
    public long field_createTime;
    public int field_debugType;
    public boolean field_isSync;
    private boolean gwJ = true;
    private boolean gwK = true;
    private boolean gwL = true;
    private boolean gwM = true;
    private boolean gwN = true;
    private boolean gwO = true;
    private boolean gwP = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gwQ == hashCode) {
                    this.field_RecordId = cursor.getString(i);
                    this.gwJ = true;
                } else if (gwR == hashCode) {
                    this.field_AppId = cursor.getString(i);
                } else if (gwS == hashCode) {
                    this.field_AppName = cursor.getString(i);
                } else if (gwT == hashCode) {
                    this.field_UserName = cursor.getString(i);
                } else if (gwU == hashCode) {
                    this.field_IconUrl = cursor.getString(i);
                } else if (gwV == hashCode) {
                    this.field_BriefIntro = cursor.getString(i);
                } else if (gwW == hashCode) {
                    this.field_isSync = cursor.getInt(i) != 0;
                } else if (fPG == hashCode) {
                    this.field_debugType = cursor.getInt(i);
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
        if (this.gwJ) {
            contentValues.put("RecordId", this.field_RecordId);
        }
        if (this.gwK) {
            contentValues.put("AppId", this.field_AppId);
        }
        if (this.gwL) {
            contentValues.put("AppName", this.field_AppName);
        }
        if (this.gwM) {
            contentValues.put("UserName", this.field_UserName);
        }
        if (this.gwN) {
            contentValues.put("IconUrl", this.field_IconUrl);
        }
        if (this.gwO) {
            contentValues.put("BriefIntro", this.field_BriefIntro);
        }
        if (this.gwP) {
            contentValues.put("isSync", Boolean.valueOf(this.field_isSync));
        }
        if (this.fPz) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
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
