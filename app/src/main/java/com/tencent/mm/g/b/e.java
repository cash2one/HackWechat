package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class e extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNU = "snsId".hashCode();
    private static final int fNV = "userName".hashCode();
    private static final int fNW = "localFlag".hashCode();
    private static final int fNX = "createTime".hashCode();
    private static final int fNY = "head".hashCode();
    private static final int fNZ = "localPrivate".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fOb = "sourceType".hashCode();
    private static final int fOc = "likeFlag".hashCode();
    private static final int fOd = "pravited".hashCode();
    private static final int fOe = "stringSeq".hashCode();
    private static final int fOf = "content".hashCode();
    private static final int fOg = "attrBuf".hashCode();
    private static final int fOh = "postBuf".hashCode();
    private static final int fOi = "adinfo".hashCode();
    private static final int fOj = "adxml".hashCode();
    private static final int fOk = "createAdTime".hashCode();
    private static final int fOl = "exposureTime".hashCode();
    private static final int fOm = "firstControlTime".hashCode();
    private static final int fOn = "recxml".hashCode();
    private static final int fOo = "subType".hashCode();
    private static final int fOp = "exposureCount".hashCode();
    private boolean fNA = true;
    private boolean fNB = true;
    private boolean fNC = true;
    private boolean fND = true;
    private boolean fNE = true;
    private boolean fNF = true;
    private boolean fNG = true;
    private boolean fNH = true;
    private boolean fNI = true;
    private boolean fNJ = true;
    private boolean fNK = true;
    private boolean fNL = true;
    private boolean fNM = true;
    private boolean fNN = true;
    private boolean fNO = true;
    private boolean fNP = true;
    private boolean fNQ = true;
    private boolean fNR = true;
    private boolean fNS = true;
    private boolean fNT = true;
    private boolean fNy = true;
    private boolean fNz = true;
    public String field_adinfo;
    public String field_adxml;
    public byte[] field_attrBuf;
    public byte[] field_content;
    public int field_createAdTime;
    public int field_createTime;
    public int field_exposureCount;
    public int field_exposureTime;
    public int field_firstControlTime;
    public int field_head;
    public int field_likeFlag;
    public int field_localFlag;
    public int field_localPrivate;
    public byte[] field_postBuf;
    public int field_pravited;
    public String field_recxml;
    public long field_snsId;
    public int field_sourceType;
    public String field_stringSeq;
    public int field_subType;
    public int field_type;
    public String field_userName;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNU == hashCode) {
                    this.field_snsId = cursor.getLong(i);
                } else if (fNV == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (fNW == hashCode) {
                    this.field_localFlag = cursor.getInt(i);
                } else if (fNX == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (fNY == hashCode) {
                    this.field_head = cursor.getInt(i);
                } else if (fNZ == hashCode) {
                    this.field_localPrivate = cursor.getInt(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fOb == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (fOc == hashCode) {
                    this.field_likeFlag = cursor.getInt(i);
                } else if (fOd == hashCode) {
                    this.field_pravited = cursor.getInt(i);
                } else if (fOe == hashCode) {
                    this.field_stringSeq = cursor.getString(i);
                } else if (fOf == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (fOg == hashCode) {
                    this.field_attrBuf = cursor.getBlob(i);
                } else if (fOh == hashCode) {
                    this.field_postBuf = cursor.getBlob(i);
                } else if (fOi == hashCode) {
                    this.field_adinfo = cursor.getString(i);
                } else if (fOj == hashCode) {
                    this.field_adxml = cursor.getString(i);
                } else if (fOk == hashCode) {
                    this.field_createAdTime = cursor.getInt(i);
                } else if (fOl == hashCode) {
                    this.field_exposureTime = cursor.getInt(i);
                } else if (fOm == hashCode) {
                    this.field_firstControlTime = cursor.getInt(i);
                } else if (fOn == hashCode) {
                    this.field_recxml = cursor.getString(i);
                } else if (fOo == hashCode) {
                    this.field_subType = cursor.getInt(i);
                } else if (fOp == hashCode) {
                    this.field_exposureCount = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fNy) {
            contentValues.put("snsId", Long.valueOf(this.field_snsId));
        }
        if (this.fNz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fNA) {
            contentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
        }
        if (this.fNB) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.fNC) {
            contentValues.put("head", Integer.valueOf(this.field_head));
        }
        if (this.fND) {
            contentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fNF) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.fNG) {
            contentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
        }
        if (this.fNH) {
            contentValues.put("pravited", Integer.valueOf(this.field_pravited));
        }
        if (this.fNI) {
            contentValues.put("stringSeq", this.field_stringSeq);
        }
        if (this.fNJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.fNK) {
            contentValues.put("attrBuf", this.field_attrBuf);
        }
        if (this.fNL) {
            contentValues.put("postBuf", this.field_postBuf);
        }
        if (this.fNM) {
            contentValues.put("adinfo", this.field_adinfo);
        }
        if (this.fNN) {
            contentValues.put("adxml", this.field_adxml);
        }
        if (this.fNO) {
            contentValues.put("createAdTime", Integer.valueOf(this.field_createAdTime));
        }
        if (this.fNP) {
            contentValues.put("exposureTime", Integer.valueOf(this.field_exposureTime));
        }
        if (this.fNQ) {
            contentValues.put("firstControlTime", Integer.valueOf(this.field_firstControlTime));
        }
        if (this.fNR) {
            contentValues.put("recxml", this.field_recxml);
        }
        if (this.fNS) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.fNT) {
            contentValues.put("exposureCount", Integer.valueOf(this.field_exposureCount));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
