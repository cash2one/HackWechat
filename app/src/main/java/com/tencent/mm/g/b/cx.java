package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class cx extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fOZ = "signature".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fPt = "username".hashCode();
    private static final int fTI = "nickname".hashCode();
    private static final int fZq = "reserved1".hashCode();
    private static final int fZr = "reserved2".hashCode();
    private static final int fZs = "reserved3".hashCode();
    private static final int fZt = "reserved4".hashCode();
    private static final int gfI = "lvbuffer".hashCode();
    private static final int goh = "shakeItemID".hashCode();
    private static final int goi = "province".hashCode();
    private static final int goj = "city".hashCode();
    private static final int gok = "distance".hashCode();
    private static final int gol = "sex".hashCode();
    private static final int gom = "imgstatus".hashCode();
    private static final int gon = "hasHDImg".hashCode();
    private static final int goo = "insertBatch".hashCode();
    private static final int goq = "regionCode".hashCode();
    private static final int gor = "snsFlag".hashCode();
    private static final int gos = "sns_bgurl".hashCode();
    private boolean fNE = true;
    private boolean fOI = true;
    private boolean fPs = true;
    private boolean fTE = true;
    private boolean fYR = true;
    private boolean fYS = true;
    private boolean fYT = true;
    private boolean fYU = true;
    public String field_city;
    public String field_distance;
    public int field_hasHDImg;
    public int field_imgstatus;
    public int field_insertBatch;
    public byte[] field_lvbuffer;
    public String field_nickname;
    public String field_province;
    public String field_regionCode;
    public int field_reserved1;
    public int field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public int field_sex;
    public int field_shakeItemID;
    public String field_signature;
    public int field_snsFlag;
    public String field_sns_bgurl;
    public int field_type;
    public String field_username;
    private boolean gfw = true;
    private boolean gnW = true;
    private boolean gnX = true;
    private boolean gnY = true;
    private boolean gnZ = true;
    private boolean goa = true;
    private boolean gob = true;
    private boolean goc = true;
    private boolean god = true;
    private boolean goe = true;
    private boolean gof = true;
    private boolean gog = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (goh == hashCode) {
                    this.field_shakeItemID = cursor.getInt(i);
                    this.gnW = true;
                } else if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (fTI == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (goi == hashCode) {
                    this.field_province = cursor.getString(i);
                } else if (goj == hashCode) {
                    this.field_city = cursor.getString(i);
                } else if (fOZ == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (gok == hashCode) {
                    this.field_distance = cursor.getString(i);
                } else if (gol == hashCode) {
                    this.field_sex = cursor.getInt(i);
                } else if (gom == hashCode) {
                    this.field_imgstatus = cursor.getInt(i);
                } else if (gon == hashCode) {
                    this.field_hasHDImg = cursor.getInt(i);
                } else if (goo == hashCode) {
                    this.field_insertBatch = cursor.getInt(i);
                } else if (fZq == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (fZr == hashCode) {
                    this.field_reserved2 = cursor.getInt(i);
                } else if (fZs == hashCode) {
                    this.field_reserved3 = cursor.getString(i);
                } else if (fZt == hashCode) {
                    this.field_reserved4 = cursor.getString(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gfI == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (goq == hashCode) {
                    this.field_regionCode = cursor.getString(i);
                } else if (gor == hashCode) {
                    this.field_snsFlag = cursor.getInt(i);
                } else if (gos == hashCode) {
                    this.field_sns_bgurl = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.gnW) {
            contentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
        }
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.fTE) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.gnX) {
            contentValues.put("province", this.field_province);
        }
        if (this.gnY) {
            contentValues.put("city", this.field_city);
        }
        if (this.fOI) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.gnZ) {
            contentValues.put("distance", this.field_distance);
        }
        if (this.goa) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if (this.gob) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if (this.goc) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if (this.god) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if (this.fYR) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.fYS) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if (this.fYT) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.fYU) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gfw) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.goe) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if (this.gof) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if (this.gog) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
