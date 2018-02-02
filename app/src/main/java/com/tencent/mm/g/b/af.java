package com.tencent.mm.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class af extends c {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)"};
    private static final int fMT = "rowid".hashCode();
    private static final int fOa = DownloadSettingTable$Columns.TYPE.hashCode();
    private static final int fPt = "username".hashCode();
    private static final int fQw = "lvbuff".hashCode();
    private static final int fTI = "nickname".hashCode();
    private static final int fVP = "alias".hashCode();
    private static final int fVQ = "conRemark".hashCode();
    private static final int fVR = "domainList".hashCode();
    private static final int fVS = "pyInitial".hashCode();
    private static final int fVT = "quanPin".hashCode();
    private static final int fVU = "showHead".hashCode();
    private static final int fVV = "weiboFlag".hashCode();
    private static final int fVW = "weiboNickname".hashCode();
    private static final int fVX = "conRemarkPYFull".hashCode();
    private static final int fVY = "conRemarkPYShort".hashCode();
    private static final int fVZ = "verifyFlag".hashCode();
    private static final int fWa = "encryptUsername".hashCode();
    private static final int fWb = "chatroomFlag".hashCode();
    private static final int fWc = "deleteFlag".hashCode();
    private static final int fWd = "contactLabelIds".hashCode();
    private int cOY;
    public String fAf;
    private boolean fNE = false;
    private boolean fPZ = false;
    private boolean fPs = false;
    private boolean fTE = false;
    private boolean fVA = false;
    private boolean fVB = false;
    private boolean fVC = false;
    private boolean fVD = false;
    private boolean fVE = false;
    private boolean fVF = false;
    private boolean fVG = false;
    private boolean fVH = false;
    private boolean fVI = false;
    private boolean fVJ = false;
    private boolean fVK = false;
    private boolean fVL = false;
    private boolean fVM = false;
    private boolean fVN = false;
    private boolean fVO = false;
    public String fWA;
    public String fWB;
    public String fWC;
    public String fWD;
    public String fWE;
    public String fWF;
    private int fWG;
    public int fWe;
    public int fWf;
    public String fWg;
    public long fWh;
    public String fWi;
    public int fWj;
    public int fWk;
    public String fWl;
    public String fWm;
    public int fWn;
    public int fWo;
    private String fWp;
    private String fWq;
    public String fWr;
    public int fWs;
    public String fWt;
    public String fWu;
    public String fWv;
    public int fWw;
    public int fWx;
    public String fWy;
    public String fWz;
    private String field_alias;
    public int field_chatroomFlag;
    public String field_conRemark;
    public String field_conRemarkPYFull;
    public String field_conRemarkPYShort;
    public String field_contactLabelIds;
    public int field_deleteFlag;
    public String field_domainList;
    public String field_encryptUsername;
    public byte[] field_lvbuff;
    public String field_nickname;
    private String field_pyInitial;
    private String field_quanPin;
    public int field_showHead;
    public int field_type;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public String field_weiboNickname;
    public String signature;
    public int uin;

    public void setUsername(String str) {
        this.field_username = str;
        this.fPs = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public void cZ(String str) {
        this.field_alias = str;
        this.fVA = true;
    }

    public String vN() {
        return this.field_alias;
    }

    public void da(String str) {
        this.field_conRemark = str;
        this.fVB = true;
    }

    public final String vO() {
        return this.field_conRemark;
    }

    public void db(String str) {
        this.field_domainList = str;
        this.fVC = true;
    }

    public void dc(String str) {
        this.field_nickname = str;
        this.fTE = true;
    }

    public final String vP() {
        return this.field_nickname;
    }

    public void dd(String str) {
        this.field_pyInitial = str;
        this.fVD = true;
    }

    public String vQ() {
        return this.field_pyInitial;
    }

    public void de(String str) {
        this.field_quanPin = str;
        this.fVE = true;
    }

    public String vR() {
        return this.field_quanPin;
    }

    public void ex(int i) {
        this.field_showHead = i;
        this.fVF = true;
    }

    public void setType(int i) {
        this.field_type = i;
        this.fNE = true;
    }

    public void ey(int i) {
        this.field_weiboFlag = i;
        this.fVG = true;
    }

    public void df(String str) {
        this.field_weiboNickname = str;
        this.fVH = true;
    }

    public void dg(String str) {
        this.field_conRemarkPYFull = str;
        this.fVI = true;
    }

    public void dh(String str) {
        this.field_conRemarkPYShort = str;
        this.fVJ = true;
    }

    public void z(byte[] bArr) {
        this.field_lvbuff = bArr;
        this.fPZ = true;
    }

    public void ez(int i) {
        this.field_verifyFlag = i;
        this.fVK = true;
    }

    public void di(String str) {
        this.field_encryptUsername = str;
        this.fVL = true;
    }

    public final String vS() {
        return this.field_encryptUsername;
    }

    public void eA(int i) {
        this.field_chatroomFlag = i;
        this.fVM = true;
    }

    public void eB(int i) {
        this.field_deleteFlag = i;
        this.fVN = true;
    }

    public void dj(String str) {
        this.field_contactLabelIds = str;
        this.fVO = true;
    }

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPs = true;
                } else if (fVP == hashCode) {
                    this.field_alias = cursor.getString(i);
                } else if (fVQ == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (fVR == hashCode) {
                    this.field_domainList = cursor.getString(i);
                } else if (fTI == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (fVS == hashCode) {
                    this.field_pyInitial = cursor.getString(i);
                } else if (fVT == hashCode) {
                    this.field_quanPin = cursor.getString(i);
                } else if (fVU == hashCode) {
                    this.field_showHead = cursor.getInt(i);
                } else if (fOa == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fVV == hashCode) {
                    this.field_weiboFlag = cursor.getInt(i);
                } else if (fVW == hashCode) {
                    this.field_weiboNickname = cursor.getString(i);
                } else if (fVX == hashCode) {
                    this.field_conRemarkPYFull = cursor.getString(i);
                } else if (fVY == hashCode) {
                    this.field_conRemarkPYShort = cursor.getString(i);
                } else if (fQw == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (fVZ == hashCode) {
                    this.field_verifyFlag = cursor.getInt(i);
                } else if (fWa == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                } else if (fWb == hashCode) {
                    this.field_chatroomFlag = cursor.getInt(i);
                } else if (fWc == hashCode) {
                    this.field_deleteFlag = cursor.getInt(i);
                } else if (fWd == hashCode) {
                    this.field_contactLabelIds = cursor.getString(i);
                } else if (fMT == hashCode) {
                    this.xjy = cursor.getLong(i);
                }
            }
            vT();
        }
    }

    public final ContentValues vI() {
        try {
            if (this.fPZ) {
                u uVar = new u();
                uVar.ceX();
                uVar.Dd(this.fWe);
                uVar.Dd(this.fWf);
                uVar.UV(this.fWg);
                uVar.fF(this.fWh);
                uVar.Dd(this.uin);
                uVar.UV(this.fWi);
                uVar.UV(this.fAf);
                uVar.Dd(this.fWj);
                uVar.Dd(this.fWk);
                uVar.UV(this.fWl);
                uVar.UV(this.fWm);
                uVar.Dd(this.fWn);
                uVar.Dd(this.fWo);
                uVar.UV(this.signature);
                uVar.UV(this.fWp);
                uVar.UV(this.fWq);
                uVar.UV(this.fWr);
                uVar.Dd(this.fWs);
                uVar.Dd(this.cOY);
                uVar.UV(this.fWt);
                uVar.Dd(this.field_verifyFlag);
                uVar.UV(this.fWu);
                uVar.UV(this.fWv);
                uVar.Dd(this.fWw);
                uVar.Dd(this.fWx);
                uVar.UV(this.fWy);
                uVar.UV(this.fWz);
                uVar.UV(this.fWA);
                uVar.UV(this.fWB);
                uVar.UV(this.fWC);
                uVar.UV(this.fWD);
                uVar.UV(this.fWE);
                uVar.UV(this.fWF);
                uVar.Dd(this.fWG);
                this.field_lvbuff = uVar.ceY();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseContact", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.fPs) {
            contentValues.put("username", this.field_username);
        }
        if (this.field_alias == null) {
            this.field_alias = "";
        }
        if (this.fVA) {
            contentValues.put("alias", this.field_alias);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.fVB) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_domainList == null) {
            this.field_domainList = "";
        }
        if (this.fVC) {
            contentValues.put("domainList", this.field_domainList);
        }
        if (this.field_nickname == null) {
            this.field_nickname = "";
        }
        if (this.fTE) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.field_pyInitial == null) {
            this.field_pyInitial = "";
        }
        if (this.fVD) {
            contentValues.put("pyInitial", this.field_pyInitial);
        }
        if (this.field_quanPin == null) {
            this.field_quanPin = "";
        }
        if (this.fVE) {
            contentValues.put("quanPin", this.field_quanPin);
        }
        if (this.fVF) {
            contentValues.put("showHead", Integer.valueOf(this.field_showHead));
        }
        if (this.fNE) {
            contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fVG) {
            contentValues.put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
        }
        if (this.field_weiboNickname == null) {
            this.field_weiboNickname = "";
        }
        if (this.fVH) {
            contentValues.put("weiboNickname", this.field_weiboNickname);
        }
        if (this.field_conRemarkPYFull == null) {
            this.field_conRemarkPYFull = "";
        }
        if (this.fVI) {
            contentValues.put("conRemarkPYFull", this.field_conRemarkPYFull);
        }
        if (this.field_conRemarkPYShort == null) {
            this.field_conRemarkPYShort = "";
        }
        if (this.fVJ) {
            contentValues.put("conRemarkPYShort", this.field_conRemarkPYShort);
        }
        if (this.fPZ) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.fVK) {
            contentValues.put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
        }
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.fVL) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.fVM) {
            contentValues.put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
        }
        if (this.fVN) {
            contentValues.put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
        }
        if (this.field_contactLabelIds == null) {
            this.field_contactLabelIds = "";
        }
        if (this.fVO) {
            contentValues.put("contactLabelIds", this.field_contactLabelIds);
        }
        if (this.xjy > 0) {
            contentValues.put("rowid", Long.valueOf(this.xjy));
        }
        return contentValues;
    }

    public void eC(int i) {
        this.fWe = i;
        this.fPZ = true;
    }

    public void eD(int i) {
        this.fWf = i;
        this.fPZ = true;
    }

    public void dk(String str) {
        this.fWg = str;
        this.fPZ = true;
    }

    public void ai(long j) {
        this.fWh = j;
        this.fPZ = true;
    }

    public void eE(int i) {
        this.uin = i;
        this.fPZ = true;
    }

    public void dl(String str) {
        this.fWi = str;
        this.fPZ = true;
    }

    public void dm(String str) {
        this.fAf = str;
        this.fPZ = true;
    }

    public void eF(int i) {
        this.fWj = i;
        this.fPZ = true;
    }

    public void eG(int i) {
        this.fWk = i;
        this.fPZ = true;
    }

    public void dn(String str) {
        this.fWl = str;
        this.fPZ = true;
    }

    public void do(String str) {
        this.fWm = str;
        this.fPZ = true;
    }

    public void eH(int i) {
        this.fWn = i;
        this.fPZ = true;
    }

    public void eI(int i) {
        this.fWo = i;
        this.fPZ = true;
    }

    public void dp(String str) {
        this.signature = str;
        this.fPZ = true;
    }

    public String getProvince() {
        return this.fWp;
    }

    public void dq(String str) {
        this.fWp = str;
        this.fPZ = true;
    }

    public String getCity() {
        return this.fWq;
    }

    public void dr(String str) {
        this.fWq = str;
        this.fPZ = true;
    }

    public void ds(String str) {
        this.fWr = str;
        this.fPZ = true;
    }

    public void eJ(int i) {
        this.fWs = i;
        this.fPZ = true;
    }

    public int getSource() {
        return this.cOY;
    }

    public void setSource(int i) {
        this.cOY = i;
        this.fPZ = true;
    }

    public void dt(String str) {
        this.fWt = str;
        this.fPZ = true;
    }

    public void du(String str) {
        this.fWu = str;
        this.fPZ = true;
    }

    public void dv(String str) {
        this.fWv = str;
        this.fPZ = true;
    }

    public void eK(int i) {
        this.fWw = i;
        this.fPZ = true;
    }

    public void eL(int i) {
        this.fWx = i;
        this.fPZ = true;
    }

    public void dw(String str) {
        this.fWy = str;
        this.fPZ = true;
    }

    public void dx(String str) {
        this.fWz = str;
        this.fPZ = true;
    }

    public void dy(String str) {
        this.fWA = str;
        this.fPZ = true;
    }

    public void dz(String str) {
        this.fWB = str;
        this.fPZ = true;
    }

    public void dA(String str) {
        this.fWC = str;
        this.fPZ = true;
    }

    public void dB(String str) {
        this.fWD = str;
        this.fPZ = true;
    }

    public void dC(String str) {
        this.fWE = str;
        this.fPZ = true;
    }

    public void dD(String str) {
        this.fWF = str;
        this.fPZ = true;
    }

    public final void eM(int i) {
        this.fWG = i;
        this.fPZ = true;
    }

    public final void vT() {
        try {
            if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                u uVar = new u();
                int br = uVar.br(this.field_lvbuff);
                if (br != 0) {
                    x.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:" + br);
                    return;
                }
                this.fWe = uVar.getInt();
                this.fWf = uVar.getInt();
                this.fWg = uVar.getString();
                this.fWh = uVar.getLong();
                this.uin = uVar.getInt();
                this.fWi = uVar.getString();
                this.fAf = uVar.getString();
                this.fWj = uVar.getInt();
                this.fWk = uVar.getInt();
                this.fWl = uVar.getString();
                this.fWm = uVar.getString();
                this.fWn = uVar.getInt();
                this.fWo = uVar.getInt();
                this.signature = uVar.getString();
                this.fWp = uVar.getString();
                this.fWq = uVar.getString();
                this.fWr = uVar.getString();
                this.fWs = uVar.getInt();
                this.cOY = uVar.getInt();
                this.fWt = uVar.getString();
                this.field_verifyFlag = uVar.getInt();
                this.fWu = uVar.getString();
                if (!uVar.ceW()) {
                    this.fWv = uVar.getString();
                }
                if (!uVar.ceW()) {
                    this.fWw = uVar.getInt();
                }
                if (!uVar.ceW()) {
                    this.fWx = uVar.getInt();
                }
                if (!uVar.ceW()) {
                    this.fWy = uVar.getString();
                }
                if (!uVar.ceW()) {
                    this.fWz = uVar.getString();
                }
                if (!uVar.ceW()) {
                    this.fWA = uVar.getString();
                }
                if (!uVar.ceW()) {
                    this.fWB = uVar.getString();
                }
                if (!uVar.ceW()) {
                    this.fWC = uVar.getString();
                }
                if (!uVar.ceW()) {
                    this.fWD = uVar.getString();
                }
                if (!uVar.ceW()) {
                    this.fWE = uVar.getString();
                }
                if (!uVar.ceW()) {
                    this.fWF = uVar.getString();
                }
                if (!uVar.ceW()) {
                    this.fWG = uVar.getInt();
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseContact", "get value failed");
        }
    }
}
