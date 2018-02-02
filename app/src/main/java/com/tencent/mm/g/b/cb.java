package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class cb extends c {
    public static final String[] fMK = new String[0];
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fNk = "expId".hashCode();
    private static final int fNl = "sequence".hashCode();
    private static final int fNm = "prioritylevel".hashCode();
    private static final int ghQ = "LabsAppId".hashCode();
    private static final int ghR = "Type".hashCode();
    private static final int ghS = "BizType".hashCode();
    private static final int ghT = "Switch".hashCode();
    private static final int ghU = "AllVer".hashCode();
    private static final int ghV = "DetailURL".hashCode();
    private static final int ghW = "WeAppUser".hashCode();
    private static final int ghX = "WeAppPath".hashCode();
    private static final int ghY = "Pos".hashCode();
    private static final int ghZ = "TitleKey_android".hashCode();
    private static final int giA = "Icon".hashCode();
    private static final int giB = "ImgUrl_cn".hashCode();
    private static final int giC = "ImgUrl_hk".hashCode();
    private static final int giD = "ImgUrl_tw".hashCode();
    private static final int giE = "ImgUrl_en".hashCode();
    private static final int gia = "Title_cn".hashCode();
    private static final int gib = "Title_hk".hashCode();
    private static final int gic = "Title_tw".hashCode();
    private static final int gid = "Title_en".hashCode();
    private static final int gie = "Desc_cn".hashCode();
    private static final int gif = "Desc_hk".hashCode();
    private static final int gig = "Desc_tw".hashCode();
    private static final int gih = "Desc_en".hashCode();
    private static final int gii = "Introduce_cn".hashCode();
    private static final int gij = "Introduce_hk".hashCode();
    private static final int gik = "Introduce_tw".hashCode();
    private static final int gil = "Introduce_en".hashCode();
    private static final int gim = "starttime".hashCode();
    private static final int gin = "endtime".hashCode();
    private static final int gio = "ThumbUrl_cn".hashCode();
    private static final int gip = "ThumbUrl_hk".hashCode();
    private static final int giq = "ThumbUrl_tw".hashCode();
    private static final int gir = "ThumbUrl_en".hashCode();
    private static final int gis = "ImgUrl_android_cn".hashCode();
    private static final int git = "ImgUrl_android_hk".hashCode();
    private static final int giu = "ImgUrl_android_tw".hashCode();
    private static final int giv = "ImgUrl_android_en".hashCode();
    private static final int giw = "RedPoint".hashCode();
    private static final int gix = "WeAppDebugMode".hashCode();
    private static final int giy = "idkey".hashCode();
    private static final int giz = "idkeyValue".hashCode();
    private boolean fMW = true;
    private boolean fNc = true;
    private boolean fNd = true;
    private boolean fNe = true;
    public int field_AllVer;
    public int field_BizType;
    public String field_Desc_cn;
    public String field_Desc_en;
    public String field_Desc_hk;
    public String field_Desc_tw;
    public String field_DetailURL;
    public String field_Icon;
    public String field_ImgUrl_android_cn;
    public String field_ImgUrl_android_en;
    public String field_ImgUrl_android_hk;
    public String field_ImgUrl_android_tw;
    public String field_ImgUrl_cn;
    public String field_ImgUrl_en;
    public String field_ImgUrl_hk;
    public String field_ImgUrl_tw;
    public String field_Introduce_cn;
    public String field_Introduce_en;
    public String field_Introduce_hk;
    public String field_Introduce_tw;
    public String field_LabsAppId;
    public int field_Pos;
    public int field_RedPoint;
    public int field_Switch;
    public String field_ThumbUrl_cn;
    public String field_ThumbUrl_en;
    public String field_ThumbUrl_hk;
    public String field_ThumbUrl_tw;
    public String field_TitleKey_android;
    public String field_Title_cn;
    public String field_Title_en;
    public String field_Title_hk;
    public String field_Title_tw;
    public int field_Type;
    public int field_WeAppDebugMode;
    public String field_WeAppPath;
    public String field_WeAppUser;
    public long field_endtime;
    public String field_expId;
    public int field_idkey;
    public int field_idkeyValue;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_starttime;
    public int field_status;
    private boolean ghA = true;
    private boolean ghB = true;
    private boolean ghC = true;
    private boolean ghD = true;
    private boolean ghE = true;
    private boolean ghF = true;
    private boolean ghG = true;
    private boolean ghH = true;
    private boolean ghI = true;
    private boolean ghJ = true;
    private boolean ghK = true;
    private boolean ghL = true;
    private boolean ghM = true;
    private boolean ghN = true;
    private boolean ghO = true;
    private boolean ghP = true;
    private boolean ghb = true;
    private boolean ghc = true;
    private boolean ghd = true;
    private boolean ghe = true;
    private boolean ghf = true;
    private boolean ghg = true;
    private boolean ghh = true;
    private boolean ghi = true;
    private boolean ghj = true;
    private boolean ghk = true;
    private boolean ghl = true;
    private boolean ghm = true;
    private boolean ghn = true;
    private boolean gho = true;
    private boolean ghp = true;
    private boolean ghq = true;
    private boolean ghr = true;
    private boolean ghs = true;
    private boolean ght = true;
    private boolean ghu = true;
    private boolean ghv = true;
    private boolean ghw = true;
    private boolean ghx = true;
    private boolean ghy = true;
    private boolean ghz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ghQ == hashCode) {
                    this.field_LabsAppId = cursor.getString(i);
                    this.ghb = true;
                } else if (fNk == hashCode) {
                    this.field_expId = cursor.getString(i);
                } else if (ghR == hashCode) {
                    this.field_Type = cursor.getInt(i);
                } else if (ghS == hashCode) {
                    this.field_BizType = cursor.getInt(i);
                } else if (ghT == hashCode) {
                    this.field_Switch = cursor.getInt(i);
                } else if (ghU == hashCode) {
                    this.field_AllVer = cursor.getInt(i);
                } else if (ghV == hashCode) {
                    this.field_DetailURL = cursor.getString(i);
                } else if (ghW == hashCode) {
                    this.field_WeAppUser = cursor.getString(i);
                } else if (ghX == hashCode) {
                    this.field_WeAppPath = cursor.getString(i);
                } else if (ghY == hashCode) {
                    this.field_Pos = cursor.getInt(i);
                } else if (ghZ == hashCode) {
                    this.field_TitleKey_android = cursor.getString(i);
                } else if (gia == hashCode) {
                    this.field_Title_cn = cursor.getString(i);
                } else if (gib == hashCode) {
                    this.field_Title_hk = cursor.getString(i);
                } else if (gic == hashCode) {
                    this.field_Title_tw = cursor.getString(i);
                } else if (gid == hashCode) {
                    this.field_Title_en = cursor.getString(i);
                } else if (gie == hashCode) {
                    this.field_Desc_cn = cursor.getString(i);
                } else if (gif == hashCode) {
                    this.field_Desc_hk = cursor.getString(i);
                } else if (gig == hashCode) {
                    this.field_Desc_tw = cursor.getString(i);
                } else if (gih == hashCode) {
                    this.field_Desc_en = cursor.getString(i);
                } else if (gii == hashCode) {
                    this.field_Introduce_cn = cursor.getString(i);
                } else if (gij == hashCode) {
                    this.field_Introduce_hk = cursor.getString(i);
                } else if (gik == hashCode) {
                    this.field_Introduce_tw = cursor.getString(i);
                } else if (gil == hashCode) {
                    this.field_Introduce_en = cursor.getString(i);
                } else if (gim == hashCode) {
                    this.field_starttime = cursor.getLong(i);
                } else if (gin == hashCode) {
                    this.field_endtime = cursor.getLong(i);
                } else if (fNl == hashCode) {
                    this.field_sequence = cursor.getLong(i);
                } else if (fNm == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gio == hashCode) {
                    this.field_ThumbUrl_cn = cursor.getString(i);
                } else if (gip == hashCode) {
                    this.field_ThumbUrl_hk = cursor.getString(i);
                } else if (giq == hashCode) {
                    this.field_ThumbUrl_tw = cursor.getString(i);
                } else if (gir == hashCode) {
                    this.field_ThumbUrl_en = cursor.getString(i);
                } else if (gis == hashCode) {
                    this.field_ImgUrl_android_cn = cursor.getString(i);
                } else if (git == hashCode) {
                    this.field_ImgUrl_android_hk = cursor.getString(i);
                } else if (giu == hashCode) {
                    this.field_ImgUrl_android_tw = cursor.getString(i);
                } else if (giv == hashCode) {
                    this.field_ImgUrl_android_en = cursor.getString(i);
                } else if (giw == hashCode) {
                    this.field_RedPoint = cursor.getInt(i);
                } else if (gix == hashCode) {
                    this.field_WeAppDebugMode = cursor.getInt(i);
                } else if (giy == hashCode) {
                    this.field_idkey = cursor.getInt(i);
                } else if (giz == hashCode) {
                    this.field_idkeyValue = cursor.getInt(i);
                } else if (giA == hashCode) {
                    this.field_Icon = cursor.getString(i);
                } else if (giB == hashCode) {
                    this.field_ImgUrl_cn = cursor.getString(i);
                } else if (giC == hashCode) {
                    this.field_ImgUrl_hk = cursor.getString(i);
                } else if (giD == hashCode) {
                    this.field_ImgUrl_tw = cursor.getString(i);
                } else if (giE == hashCode) {
                    this.field_ImgUrl_en = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vI() {
        ContentValues contentValues = new ContentValues();
        if (this.ghb) {
            contentValues.put("LabsAppId", this.field_LabsAppId);
        }
        if (this.field_expId == null) {
            this.field_expId = "";
        }
        if (this.fNc) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.ghc) {
            contentValues.put("Type", Integer.valueOf(this.field_Type));
        }
        if (this.ghd) {
            contentValues.put("BizType", Integer.valueOf(this.field_BizType));
        }
        if (this.ghe) {
            contentValues.put("Switch", Integer.valueOf(this.field_Switch));
        }
        if (this.ghf) {
            contentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
        }
        if (this.ghg) {
            contentValues.put("DetailURL", this.field_DetailURL);
        }
        if (this.ghh) {
            contentValues.put("WeAppUser", this.field_WeAppUser);
        }
        if (this.ghi) {
            contentValues.put("WeAppPath", this.field_WeAppPath);
        }
        if (this.ghj) {
            contentValues.put("Pos", Integer.valueOf(this.field_Pos));
        }
        if (this.ghk) {
            contentValues.put("TitleKey_android", this.field_TitleKey_android);
        }
        if (this.ghl) {
            contentValues.put("Title_cn", this.field_Title_cn);
        }
        if (this.ghm) {
            contentValues.put("Title_hk", this.field_Title_hk);
        }
        if (this.ghn) {
            contentValues.put("Title_tw", this.field_Title_tw);
        }
        if (this.gho) {
            contentValues.put("Title_en", this.field_Title_en);
        }
        if (this.ghp) {
            contentValues.put("Desc_cn", this.field_Desc_cn);
        }
        if (this.ghq) {
            contentValues.put("Desc_hk", this.field_Desc_hk);
        }
        if (this.ghr) {
            contentValues.put("Desc_tw", this.field_Desc_tw);
        }
        if (this.ghs) {
            contentValues.put("Desc_en", this.field_Desc_en);
        }
        if (this.ght) {
            contentValues.put("Introduce_cn", this.field_Introduce_cn);
        }
        if (this.ghu) {
            contentValues.put("Introduce_hk", this.field_Introduce_hk);
        }
        if (this.ghv) {
            contentValues.put("Introduce_tw", this.field_Introduce_tw);
        }
        if (this.ghw) {
            contentValues.put("Introduce_en", this.field_Introduce_en);
        }
        if (this.ghx) {
            contentValues.put("starttime", Long.valueOf(this.field_starttime));
        }
        if (this.ghy) {
            contentValues.put("endtime", Long.valueOf(this.field_endtime));
        }
        if (this.fNd) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.fNe) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.ghz) {
            contentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
        }
        if (this.ghA) {
            contentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
        }
        if (this.ghB) {
            contentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
        }
        if (this.ghC) {
            contentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
        }
        if (this.ghD) {
            contentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
        }
        if (this.ghE) {
            contentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
        }
        if (this.ghF) {
            contentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
        }
        if (this.ghG) {
            contentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
        }
        if (this.ghH) {
            contentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
        }
        if (this.ghI) {
            contentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
        }
        if (this.ghJ) {
            contentValues.put("idkey", Integer.valueOf(this.field_idkey));
        }
        if (this.ghK) {
            contentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
        }
        if (this.ghL) {
            contentValues.put("Icon", this.field_Icon);
        }
        if (this.ghM) {
            contentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
        }
        if (this.ghN) {
            contentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
        }
        if (this.ghO) {
            contentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
        }
        if (this.ghP) {
            contentValues.put("ImgUrl_en", this.field_ImgUrl_en);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }
}
