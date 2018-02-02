package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class df extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fNV = "userName".hashCode();
    private static final int fZk = "md5".hashCode();
    private static final int gqb = "newerIds".hashCode();
    private static final int gqc = "bgId".hashCode();
    private static final int gqd = "bgUrl".hashCode();
    private static final int gqe = "older_bgId".hashCode();
    private static final int gqf = "local_flag".hashCode();
    private static final int gqg = "istyle".hashCode();
    private static final int gqh = "iFlag".hashCode();
    private static final int gqi = "icount".hashCode();
    private static final int gqj = "faultS".hashCode();
    private static final int gqk = "snsBgId".hashCode();
    private static final int gql = "snsuser".hashCode();
    private static final int gqm = "adsession".hashCode();
    private static final int gqn = "lastFirstPageRequestErrCode".hashCode();
    private static final int gqo = "lastFirstPageRequestErrType".hashCode();
    private boolean fNz = true;
    private boolean fYL = true;
    public byte[] field_adsession;
    public String field_bgId;
    public String field_bgUrl;
    public byte[] field_faultS;
    public int field_iFlag;
    public int field_icount;
    public int field_istyle;
    public int field_lastFirstPageRequestErrCode;
    public int field_lastFirstPageRequestErrType;
    public int field_local_flag;
    public String field_md5;
    public String field_newerIds;
    public String field_older_bgId;
    public long field_snsBgId;
    public byte[] field_snsuser;
    public String field_userName;
    private boolean gpN = true;
    private boolean gpO = true;
    private boolean gpP = true;
    private boolean gpQ = true;
    private boolean gpR = true;
    private boolean gpS = true;
    private boolean gpT = true;
    private boolean gpU = true;
    private boolean gpV = true;
    private boolean gpW = true;
    private boolean gpX = true;
    private boolean gpY = true;
    private boolean gpZ = true;
    private boolean gqa = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNV == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.fNz = true;
                } else if (fZk == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gqb == hashCode) {
                    this.field_newerIds = cursor.getString(i);
                } else if (gqc == hashCode) {
                    this.field_bgId = cursor.getString(i);
                } else if (gqd == hashCode) {
                    this.field_bgUrl = cursor.getString(i);
                } else if (gqe == hashCode) {
                    this.field_older_bgId = cursor.getString(i);
                } else if (gqf == hashCode) {
                    this.field_local_flag = cursor.getInt(i);
                } else if (gqg == hashCode) {
                    this.field_istyle = cursor.getInt(i);
                } else if (gqh == hashCode) {
                    this.field_iFlag = cursor.getInt(i);
                } else if (gqi == hashCode) {
                    this.field_icount = cursor.getInt(i);
                } else if (gqj == hashCode) {
                    this.field_faultS = cursor.getBlob(i);
                } else if (gqk == hashCode) {
                    this.field_snsBgId = cursor.getLong(i);
                } else if (gql == hashCode) {
                    this.field_snsuser = cursor.getBlob(i);
                } else if (gqm == hashCode) {
                    this.field_adsession = cursor.getBlob(i);
                } else if (gqn == hashCode) {
                    this.field_lastFirstPageRequestErrCode = cursor.getInt(i);
                } else if (gqo == hashCode) {
                    this.field_lastFirstPageRequestErrType = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.fNz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fYL) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gpN) {
            contentValues.put("newerIds", this.field_newerIds);
        }
        if (this.gpO) {
            contentValues.put("bgId", this.field_bgId);
        }
        if (this.gpP) {
            contentValues.put("bgUrl", this.field_bgUrl);
        }
        if (this.gpQ) {
            contentValues.put("older_bgId", this.field_older_bgId);
        }
        if (this.gpR) {
            contentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
        }
        if (this.gpS) {
            contentValues.put("istyle", Integer.valueOf(this.field_istyle));
        }
        if (this.gpT) {
            contentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
        }
        if (this.gpU) {
            contentValues.put("icount", Integer.valueOf(this.field_icount));
        }
        if (this.gpV) {
            contentValues.put("faultS", this.field_faultS);
        }
        if (this.gpW) {
            contentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
        }
        if (this.gpX) {
            contentValues.put("snsuser", this.field_snsuser);
        }
        if (this.gpY) {
            contentValues.put("adsession", this.field_adsession);
        }
        if (this.gpZ) {
            contentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
        }
        if (this.gqa) {
            contentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
