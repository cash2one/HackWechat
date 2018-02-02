package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class n extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fMZ = DownloadInfo.STATUS.hashCode();
    private static final int fOL = "appId".hashCode();
    private static final int fOZ = "signature".hashCode();
    private static final int fQA = "appSupportContentType".hashCode();
    private static final int fQB = "svrAppSupportContentType".hashCode();
    private static final int fQf = "appName".hashCode();
    private static final int fQg = "appDiscription".hashCode();
    private static final int fQh = "appIconUrl".hashCode();
    private static final int fQi = "appStoreUrl".hashCode();
    private static final int fQj = "appVersion".hashCode();
    private static final int fQk = "appWatermarkUrl".hashCode();
    private static final int fQl = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int fQm = "modifyTime".hashCode();
    private static final int fQn = "appName_en".hashCode();
    private static final int fQo = "appName_tw".hashCode();
    private static final int fQp = "appName_hk".hashCode();
    private static final int fQq = "appDiscription_en".hashCode();
    private static final int fQr = "appDiscription_tw".hashCode();
    private static final int fQs = "appType".hashCode();
    private static final int fQt = "openId".hashCode();
    private static final int fQu = "authFlag".hashCode();
    private static final int fQv = "appInfoFlag".hashCode();
    private static final int fQw = "lvbuff".hashCode();
    private static final int fQx = "serviceAppType".hashCode();
    private static final int fQy = "serviceAppInfoFlag".hashCode();
    private static final int fQz = "serviceShowFlag".hashCode();
    private boolean fMW = true;
    private boolean fOI = true;
    private boolean fOu = true;
    private boolean fPI = true;
    private boolean fPJ = true;
    private boolean fPK = true;
    private boolean fPL = true;
    private boolean fPM = true;
    private boolean fPN = true;
    private boolean fPO = true;
    private boolean fPP = true;
    private boolean fPQ = true;
    private boolean fPR = true;
    private boolean fPS = true;
    private boolean fPT = true;
    private boolean fPU = true;
    private boolean fPV = true;
    private boolean fPW = true;
    private boolean fPX = true;
    private boolean fPY = true;
    public boolean fPZ = true;
    public String fQC;
    public String fQD;
    public String fQE;
    public int fQF;
    public int fQG;
    public String fQH;
    public String fQI;
    public String fQJ;
    public String fQK;
    public String fQL;
    public String fQM;
    public int fQN;
    public String fQO;
    public String fQP;
    public String fQQ;
    public String fQR;
    public String fQS;
    public int fQT;
    public String fQU;
    private int fQV;
    public String fQW;
    public String fQX;
    public String fQY;
    public int fQZ;
    private boolean fQa = true;
    private boolean fQb = true;
    private boolean fQc = true;
    private boolean fQd = true;
    private boolean fQe = true;
    public String field_appDiscription;
    public String field_appDiscription_en;
    public String field_appDiscription_tw;
    public String field_appIconUrl;
    public String field_appId;
    public int field_appInfoFlag;
    public String field_appName;
    public String field_appName_en;
    public String field_appName_hk;
    public String field_appName_tw;
    public String field_appStoreUrl;
    public long field_appSupportContentType;
    public String field_appType;
    public int field_appVersion;
    public String field_appWatermarkUrl;
    public int field_authFlag;
    public byte[] field_lvbuff;
    public long field_modifyTime;
    public String field_openId;
    public String field_packageName;
    public int field_serviceAppInfoFlag;
    public int field_serviceAppType;
    public int field_serviceShowFlag;
    public String field_signature;
    public int field_status;
    public long field_svrAppSupportContentType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOL == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.fOu = true;
                } else if (fQf == hashCode) {
                    this.field_appName = cursor.getString(i);
                } else if (fQg == hashCode) {
                    this.field_appDiscription = cursor.getString(i);
                } else if (fQh == hashCode) {
                    this.field_appIconUrl = cursor.getString(i);
                } else if (fQi == hashCode) {
                    this.field_appStoreUrl = cursor.getString(i);
                } else if (fQj == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (fQk == hashCode) {
                    this.field_appWatermarkUrl = cursor.getString(i);
                } else if (fQl == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (fMZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fOZ == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (fQm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (fQn == hashCode) {
                    this.field_appName_en = cursor.getString(i);
                } else if (fQo == hashCode) {
                    this.field_appName_tw = cursor.getString(i);
                } else if (fQp == hashCode) {
                    this.field_appName_hk = cursor.getString(i);
                } else if (fQq == hashCode) {
                    this.field_appDiscription_en = cursor.getString(i);
                } else if (fQr == hashCode) {
                    this.field_appDiscription_tw = cursor.getString(i);
                } else if (fQs == hashCode) {
                    this.field_appType = cursor.getString(i);
                } else if (fQt == hashCode) {
                    this.field_openId = cursor.getString(i);
                } else if (fQu == hashCode) {
                    this.field_authFlag = cursor.getInt(i);
                } else if (fQv == hashCode) {
                    this.field_appInfoFlag = cursor.getInt(i);
                } else if (fQw == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (fQx == hashCode) {
                    this.field_serviceAppType = cursor.getInt(i);
                } else if (fQy == hashCode) {
                    this.field_serviceAppInfoFlag = cursor.getInt(i);
                } else if (fQz == hashCode) {
                    this.field_serviceShowFlag = cursor.getInt(i);
                } else if (fQA == hashCode) {
                    this.field_appSupportContentType = cursor.getLong(i);
                } else if (fQB == hashCode) {
                    this.field_svrAppSupportContentType = cursor.getLong(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                    u uVar = new u();
                    int br = uVar.br(this.field_lvbuff);
                    if (br != 0) {
                        x.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:" + br);
                        return;
                    }
                    this.fQC = uVar.getString();
                    this.fQD = uVar.getString();
                    this.fQE = uVar.getString();
                    this.fQF = uVar.getInt();
                    this.fQG = uVar.getInt();
                    this.fQH = uVar.getString();
                    this.fQI = uVar.getString();
                    this.fQJ = uVar.getString();
                    this.fQK = uVar.getString();
                    if (!uVar.ceW()) {
                        this.fQL = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.fQM = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.fQN = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.fQO = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.fQP = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.fQQ = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.fQR = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.fQS = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.fQT = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.fQU = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.fQV = uVar.getInt();
                    }
                    if (!uVar.ceW()) {
                        this.fQW = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.fQX = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.fQY = uVar.getString();
                    }
                    if (!uVar.ceW()) {
                        this.fQZ = uVar.getInt();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
            }
        }
    }

    public ContentValues vI() {
        try {
            if (this.fPZ) {
                u uVar = new u();
                uVar.ceX();
                uVar.UV(this.fQC);
                uVar.UV(this.fQD);
                uVar.UV(this.fQE);
                uVar.Dd(this.fQF);
                uVar.Dd(this.fQG);
                uVar.UV(this.fQH);
                uVar.UV(this.fQI);
                uVar.UV(this.fQJ);
                uVar.UV(this.fQK);
                uVar.UV(this.fQL);
                uVar.UV(this.fQM);
                uVar.Dd(this.fQN);
                uVar.UV(this.fQO);
                uVar.UV(this.fQP);
                uVar.UV(this.fQQ);
                uVar.UV(this.fQR);
                uVar.UV(this.fQS);
                uVar.Dd(this.fQT);
                uVar.UV(this.fQU);
                uVar.Dd(this.fQV);
                uVar.UV(this.fQW);
                uVar.UV(this.fQX);
                uVar.UV(this.fQY);
                uVar.Dd(this.fQZ);
                this.field_lvbuff = uVar.ceY();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", new Object[]{e.getMessage()});
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.fOu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fPI) {
            contentValues.put("appName", this.field_appName);
        }
        if (this.fPJ) {
            contentValues.put("appDiscription", this.field_appDiscription);
        }
        if (this.fPK) {
            contentValues.put("appIconUrl", this.field_appIconUrl);
        }
        if (this.fPL) {
            contentValues.put("appStoreUrl", this.field_appStoreUrl);
        }
        if (this.fPM) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.fPN) {
            contentValues.put("appWatermarkUrl", this.field_appWatermarkUrl);
        }
        if (this.fPO) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.fMW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fOI) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.fPP) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.fPQ) {
            contentValues.put("appName_en", this.field_appName_en);
        }
        if (this.fPR) {
            contentValues.put("appName_tw", this.field_appName_tw);
        }
        if (this.fPS) {
            contentValues.put("appName_hk", this.field_appName_hk);
        }
        if (this.fPT) {
            contentValues.put("appDiscription_en", this.field_appDiscription_en);
        }
        if (this.fPU) {
            contentValues.put("appDiscription_tw", this.field_appDiscription_tw);
        }
        if (this.fPV) {
            contentValues.put("appType", this.field_appType);
        }
        if (this.fPW) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.fPX) {
            contentValues.put("authFlag", Integer.valueOf(this.field_authFlag));
        }
        if (this.fPY) {
            contentValues.put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
        }
        if (this.fPZ) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.fQa) {
            contentValues.put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
        }
        if (this.fQb) {
            contentValues.put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
        }
        if (this.fQc) {
            contentValues.put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
        }
        if (this.fQd) {
            contentValues.put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
        }
        if (this.fQe) {
            contentValues.put("svrAppSupportContentType", Long.valueOf(this.field_svrAppSupportContentType));
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }

    public final void cM(String str) {
        this.fQC = str;
        this.fPZ = true;
    }

    public final void cN(String str) {
        this.fQD = str;
        this.fPZ = true;
    }

    public final String vK() {
        return this.fQE;
    }

    public final void cO(String str) {
        this.fQE = str;
        this.fPZ = true;
    }

    public final void cP(String str) {
        this.fQH = str;
        this.fPZ = true;
    }

    public final void cQ(String str) {
        this.fQI = str;
        this.fPZ = true;
    }

    public final String vL() {
        return this.fQJ;
    }

    public final void cR(String str) {
        this.fQJ = str;
        this.fPZ = true;
    }

    public final String vM() {
        return this.fQK;
    }

    public final void cS(String str) {
        this.fQK = str;
        this.fPZ = true;
    }

    public final void cT(String str) {
        this.fQL = str;
        this.fPZ = true;
    }

    public final void cU(String str) {
        this.fQM = str;
        this.fPZ = true;
    }

    public final void ev(int i) {
        this.fQN = i;
        this.fPZ = true;
    }

    public final void cV(String str) {
        this.fQO = str;
        this.fPZ = true;
    }

    public final void cW(String str) {
        this.fQP = str;
        this.fPZ = true;
    }

    public final void cX(String str) {
        this.fQQ = str;
        this.fPZ = true;
    }

    public final void cY(String str) {
        this.fQR = str;
        this.fPZ = true;
    }

    public final void ew(int i) {
        this.fQT = i;
        this.fPZ = true;
    }
}
