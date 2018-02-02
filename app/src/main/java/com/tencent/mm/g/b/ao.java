package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class ao extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fRk = "flag".hashCode();
    private static final int fYA = "packStatus".hashCode();
    private static final int fYB = "recommand".hashCode();
    private static final int fYC = "sync".hashCode();
    private static final int fYD = "idx".hashCode();
    private static final int fYE = "BigIconUrl".hashCode();
    private static final int fYF = "MutiLanName".hashCode();
    private static final int fYG = "recommandType".hashCode();
    private static final int fYH = "lang".hashCode();
    private static final int fYI = "recommandWord".hashCode();
    private static final int fYJ = "buttonType".hashCode();
    private static final int fYK = "count".hashCode();
    private static final int fYl = "productID".hashCode();
    private static final int fYm = "packIconUrl".hashCode();
    private static final int fYn = "packGrayIconUrl".hashCode();
    private static final int fYo = "packCoverUrl".hashCode();
    private static final int fYp = "packName".hashCode();
    private static final int fYq = "packDesc".hashCode();
    private static final int fYr = "packAuthInfo".hashCode();
    private static final int fYs = "packPrice".hashCode();
    private static final int fYt = "packType".hashCode();
    private static final int fYu = "packFlag".hashCode();
    private static final int fYv = "packExpire".hashCode();
    private static final int fYw = "packTimeStamp".hashCode();
    private static final int fYx = "packCopyright".hashCode();
    private static final int fYy = "sort".hashCode();
    private static final int fYz = "lastUseTime".hashCode();
    private boolean fMW = true;
    private boolean fNE = true;
    private boolean fRi = true;
    private boolean fXL = true;
    private boolean fXM = true;
    private boolean fXN = true;
    private boolean fXO = true;
    private boolean fXP = true;
    private boolean fXQ = true;
    private boolean fXR = true;
    private boolean fXS = true;
    private boolean fXT = true;
    private boolean fXU = true;
    private boolean fXV = true;
    private boolean fXW = true;
    private boolean fXX = true;
    private boolean fXY = true;
    private boolean fXZ = true;
    private boolean fYa = true;
    private boolean fYb = true;
    private boolean fYc = true;
    private boolean fYd = true;
    private boolean fYe = true;
    private boolean fYf = true;
    private boolean fYg = true;
    private boolean fYh = true;
    private boolean fYi = true;
    private boolean fYj = true;
    private boolean fYk = true;
    public String field_BigIconUrl;
    public String field_MutiLanName;
    public int field_buttonType;
    public int field_count;
    public int field_flag;
    public int field_idx;
    public String field_lang;
    public long field_lastUseTime;
    public String field_packAuthInfo;
    public String field_packCopyright;
    public String field_packCoverUrl;
    public String field_packDesc;
    public long field_packExpire;
    public int field_packFlag;
    public String field_packGrayIconUrl;
    public String field_packIconUrl;
    public String field_packName;
    public String field_packPrice;
    public int field_packStatus;
    public long field_packTimeStamp;
    public int field_packType;
    public String field_productID;
    public int field_recommand;
    public int field_recommandType;
    public String field_recommandWord;
    public int field_sort;
    public int field_status;
    public int field_sync;
    public int field_type;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fYl == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.fXL = true;
                } else if (fYm == hashCode) {
                    this.field_packIconUrl = cursor.getString(i);
                } else if (fYn == hashCode) {
                    this.field_packGrayIconUrl = cursor.getString(i);
                } else if (fYo == hashCode) {
                    this.field_packCoverUrl = cursor.getString(i);
                } else if (fYp == hashCode) {
                    this.field_packName = cursor.getString(i);
                } else if (fYq == hashCode) {
                    this.field_packDesc = cursor.getString(i);
                } else if (fYr == hashCode) {
                    this.field_packAuthInfo = cursor.getString(i);
                } else if (fYs == hashCode) {
                    this.field_packPrice = cursor.getString(i);
                } else if (fYt == hashCode) {
                    this.field_packType = cursor.getInt(i);
                } else if (fYu == hashCode) {
                    this.field_packFlag = cursor.getInt(i);
                } else if (fYv == hashCode) {
                    this.field_packExpire = cursor.getLong(i);
                } else if (fYw == hashCode) {
                    this.field_packTimeStamp = cursor.getLong(i);
                } else if (fYx == hashCode) {
                    this.field_packCopyright = cursor.getString(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fYy == hashCode) {
                    this.field_sort = cursor.getInt(i);
                } else if (fYz == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (fYA == hashCode) {
                    this.field_packStatus = cursor.getInt(i);
                } else if (fRk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (fYB == hashCode) {
                    this.field_recommand = cursor.getInt(i);
                } else if (fYC == hashCode) {
                    this.field_sync = cursor.getInt(i);
                } else if (fYD == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (fYE == hashCode) {
                    this.field_BigIconUrl = cursor.getString(i);
                } else if (fYF == hashCode) {
                    this.field_MutiLanName = cursor.getString(i);
                } else if (fYG == hashCode) {
                    this.field_recommandType = cursor.getInt(i);
                } else if (fYH == hashCode) {
                    this.field_lang = cursor.getString(i);
                } else if (fYI == hashCode) {
                    this.field_recommandWord = cursor.getString(i);
                } else if (fYJ == hashCode) {
                    this.field_buttonType = cursor.getInt(i);
                } else if (fYK == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.fXL) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.fXM) {
            contentValues.put("packIconUrl", this.field_packIconUrl);
        }
        if (this.fXN) {
            contentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
        }
        if (this.fXO) {
            contentValues.put("packCoverUrl", this.field_packCoverUrl);
        }
        if (this.fXP) {
            contentValues.put("packName", this.field_packName);
        }
        if (this.fXQ) {
            contentValues.put("packDesc", this.field_packDesc);
        }
        if (this.fXR) {
            contentValues.put("packAuthInfo", this.field_packAuthInfo);
        }
        if (this.fXS) {
            contentValues.put("packPrice", this.field_packPrice);
        }
        if (this.fXT) {
            contentValues.put("packType", Integer.valueOf(this.field_packType));
        }
        if (this.fXU) {
            contentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
        }
        if (this.fXV) {
            contentValues.put("packExpire", Long.valueOf(this.field_packExpire));
        }
        if (this.fXW) {
            contentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
        }
        if (this.fXX) {
            contentValues.put("packCopyright", this.field_packCopyright);
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fXY) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.fXZ) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.fYa) {
            contentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
        }
        if (this.fRi) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fYb) {
            contentValues.put("recommand", Integer.valueOf(this.field_recommand));
        }
        if (this.fYc) {
            contentValues.put("sync", Integer.valueOf(this.field_sync));
        }
        if (this.fYd) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.fYe) {
            contentValues.put("BigIconUrl", this.field_BigIconUrl);
        }
        if (this.fYf) {
            contentValues.put("MutiLanName", this.field_MutiLanName);
        }
        if (this.fYg) {
            contentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
        }
        if (this.fYh) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.fYi) {
            contentValues.put("recommandWord", this.field_recommandWord);
        }
        if (this.fYj) {
            contentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
        }
        if (this.fYk) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
