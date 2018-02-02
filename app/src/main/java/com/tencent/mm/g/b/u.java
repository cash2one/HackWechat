package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class u extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fRJ = "brandUserName".hashCode();
    private static final int fRS = "chatType".hashCode();
    private static final int fSi = "bizChatLocalId".hashCode();
    private static final int fSj = "bizChatServId".hashCode();
    private static final int fSk = "headImageUrl".hashCode();
    private static final int fSl = "chatName".hashCode();
    private static final int fSm = "chatNamePY".hashCode();
    private static final int fSn = "chatVersion".hashCode();
    private static final int fSo = "needToUpdate".hashCode();
    private static final int fSp = "bitFlag".hashCode();
    private static final int fSq = "maxMemberCnt".hashCode();
    private static final int fSr = "ownerUserId".hashCode();
    private static final int fSs = "userList".hashCode();
    private static final int fSt = "addMemberUrl".hashCode();
    private boolean fRE = true;
    private boolean fRW = true;
    private boolean fRX = true;
    private boolean fRY = true;
    private boolean fRZ = true;
    private boolean fRv = true;
    private boolean fSa = true;
    private boolean fSb = true;
    private boolean fSc = true;
    private boolean fSd = true;
    private boolean fSe = true;
    private boolean fSf = true;
    private boolean fSg = true;
    private boolean fSh = true;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public long field_bizChatLocalId;
    public String field_bizChatServId;
    public String field_brandUserName;
    public String field_chatName;
    public String field_chatNamePY;
    public int field_chatType;
    public int field_chatVersion;
    public String field_headImageUrl;
    public int field_maxMemberCnt;
    public boolean field_needToUpdate;
    public String field_ownerUserId;
    public String field_userList;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fSi == hashCode) {
                    this.field_bizChatLocalId = cursor.getLong(i);
                    this.fRW = true;
                } else if (fSj == hashCode) {
                    this.field_bizChatServId = cursor.getString(i);
                } else if (fRJ == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (fRS == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (fSk == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (fSl == hashCode) {
                    this.field_chatName = cursor.getString(i);
                } else if (fSm == hashCode) {
                    this.field_chatNamePY = cursor.getString(i);
                } else if (fSn == hashCode) {
                    this.field_chatVersion = cursor.getInt(i);
                } else if (fSo == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (fSp == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (fSq == hashCode) {
                    this.field_maxMemberCnt = cursor.getInt(i);
                } else if (fSr == hashCode) {
                    this.field_ownerUserId = cursor.getString(i);
                } else if (fSs == hashCode) {
                    this.field_userList = cursor.getString(i);
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
        if (this.fRW) {
            contentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
        }
        if (this.fRX) {
            contentValues.put("bizChatServId", this.field_bizChatServId);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.fRv) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.fRE) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.fRY) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.field_chatName == null) {
            this.field_chatName = "";
        }
        if (this.fRZ) {
            contentValues.put("chatName", this.field_chatName);
        }
        if (this.field_chatNamePY == null) {
            this.field_chatNamePY = "";
        }
        if (this.fSa) {
            contentValues.put("chatNamePY", this.field_chatNamePY);
        }
        if (this.fSb) {
            contentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
        }
        if (this.fSc) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.fSd) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.fSe) {
            contentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
        }
        if (this.fSf) {
            contentValues.put("ownerUserId", this.field_ownerUserId);
        }
        if (this.fSg) {
            contentValues.put("userList", this.field_userList);
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
