package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class x extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNV = "userName".hashCode();
    private static final int fSO = "qyUin".hashCode();
    private static final int fSP = "userUin".hashCode();
    private static final int fSQ = "userFlag".hashCode();
    private static final int fSR = "wwExposeTimes".hashCode();
    private static final int fSS = "wwMaxExposeTimes".hashCode();
    private static final int fST = "wwCorpId".hashCode();
    private static final int fSU = "wwUserVid".hashCode();
    private static final int fSV = "userType".hashCode();
    private static final int fSW = "chatOpen".hashCode();
    private static final int fSX = "wwUnreadCnt".hashCode();
    private static final int fSY = "show_confirm".hashCode();
    private static final int fSZ = "use_preset_banner_tips".hashCode();
    private boolean fNz = true;
    private boolean fSC = true;
    private boolean fSD = true;
    private boolean fSE = true;
    private boolean fSF = true;
    private boolean fSG = true;
    private boolean fSH = true;
    private boolean fSI = true;
    private boolean fSJ = true;
    private boolean fSK = true;
    private boolean fSL = true;
    private boolean fSM = true;
    private boolean fSN = true;
    public boolean field_chatOpen;
    public int field_qyUin;
    public boolean field_show_confirm;
    public boolean field_use_preset_banner_tips;
    public int field_userFlag;
    public String field_userName;
    public int field_userType;
    public int field_userUin;
    public long field_wwCorpId;
    public int field_wwExposeTimes;
    public int field_wwMaxExposeTimes;
    public int field_wwUnreadCnt;
    public long field_wwUserVid;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNV == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.fNz = true;
                } else if (fSO == hashCode) {
                    this.field_qyUin = cursor.getInt(i);
                } else if (fSP == hashCode) {
                    this.field_userUin = cursor.getInt(i);
                } else if (fSQ == hashCode) {
                    this.field_userFlag = cursor.getInt(i);
                } else if (fSR == hashCode) {
                    this.field_wwExposeTimes = cursor.getInt(i);
                } else if (fSS == hashCode) {
                    this.field_wwMaxExposeTimes = cursor.getInt(i);
                } else if (fST == hashCode) {
                    this.field_wwCorpId = cursor.getLong(i);
                } else if (fSU == hashCode) {
                    this.field_wwUserVid = cursor.getLong(i);
                } else if (fSV == hashCode) {
                    this.field_userType = cursor.getInt(i);
                } else if (fSW == hashCode) {
                    this.field_chatOpen = cursor.getInt(i) != 0;
                } else if (fSX == hashCode) {
                    this.field_wwUnreadCnt = cursor.getInt(i);
                } else if (fSY == hashCode) {
                    this.field_show_confirm = cursor.getInt(i) != 0;
                } else if (fSZ == hashCode) {
                    this.field_use_preset_banner_tips = cursor.getInt(i) != 0;
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fNz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fSC) {
            contentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
        }
        if (this.fSD) {
            contentValues.put("userUin", Integer.valueOf(this.field_userUin));
        }
        if (this.fSE) {
            contentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
        }
        if (this.fSF) {
            contentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
        }
        if (this.fSG) {
            contentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
        }
        if (this.fSH) {
            contentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
        }
        if (this.fSI) {
            contentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
        }
        if (this.fSJ) {
            contentValues.put("userType", Integer.valueOf(this.field_userType));
        }
        if (this.fSK) {
            contentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
        }
        if (this.fSL) {
            contentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
        }
        if (this.fSM) {
            contentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
        }
        if (this.fSN) {
            contentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
