package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class w extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNV = "userName".hashCode();
    private static final int fRJ = "brandUserName".hashCode();
    private static final int fSA = "UserVersion".hashCode();
    private static final int fSB = "profileUrl".hashCode();
    private static final int fSk = "headImageUrl".hashCode();
    private static final int fSo = "needToUpdate".hashCode();
    private static final int fSp = "bitFlag".hashCode();
    private static final int fSt = "addMemberUrl".hashCode();
    private static final int fSv = "userId".hashCode();
    private static final int fSz = "userNamePY".hashCode();
    private boolean fNz = true;
    private boolean fRY = true;
    private boolean fRv = true;
    private boolean fSc = true;
    private boolean fSd = true;
    private boolean fSh = true;
    private boolean fSu = true;
    private boolean fSw = true;
    private boolean fSx = true;
    private boolean fSy = true;
    public int field_UserVersion;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public String field_brandUserName;
    public String field_headImageUrl;
    public boolean field_needToUpdate;
    public String field_profileUrl;
    public String field_userId;
    public String field_userName;
    public String field_userNamePY;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fSv == hashCode) {
                    this.field_userId = cursor.getString(i);
                    this.fSu = true;
                } else if (fNV == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (fSz == hashCode) {
                    this.field_userNamePY = cursor.getString(i);
                } else if (fRJ == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (fSA == hashCode) {
                    this.field_UserVersion = cursor.getInt(i);
                } else if (fSo == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (fSk == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (fSB == hashCode) {
                    this.field_profileUrl = cursor.getString(i);
                } else if (fSp == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (fSt == hashCode) {
                    this.field_addMemberUrl = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fSu) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.fNz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.field_userNamePY == null) {
            this.field_userNamePY = "";
        }
        if (this.fSw) {
            contentValues.put("userNamePY", this.field_userNamePY);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.fRv) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.fSx) {
            contentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
        }
        if (this.fSc) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.fRY) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.fSy) {
            contentValues.put("profileUrl", this.field_profileUrl);
        }
        if (this.fSd) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.fSh) {
            contentValues.put("addMemberUrl", this.field_addMemberUrl);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
