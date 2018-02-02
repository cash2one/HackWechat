package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.n;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aum;
import com.tencent.mm.protocal.c.xz;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class ac extends k implements com.tencent.mm.network.k {
    private static final String[] veQ = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};
    final String appId;
    private b gJQ;
    private e gJT;
    private final int hNr = 3;

    public ac(String str) {
        this.appId = str;
        a aVar = new a();
        aVar.hmj = new xz();
        aVar.hmk = new ya();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfo";
        aVar.hmi = 231;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        if (this.appId == null || this.appId.length() == 0) {
            x.e("MicroMsg.NetSceneGetAppInfo", "doScene fail, appId is null");
            return -1;
        }
        xz xzVar = (xz) this.gJQ.hmg.hmo;
        xzVar.nfn = this.appId;
        xzVar.wby = this.hNr;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 4 && i3 == -1011) {
            x.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3 + ", appinfo does not exist");
            com.tencent.mm.plugin.y.a.bin();
            c bYK = i.bYK();
            bYK.field_appId = this.appId;
            com.tencent.mm.plugin.y.a.bin().a(bYK);
            this.gJT.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            f fVar;
            ya yaVar = (ya) ((b) qVar).hmh.hmo;
            String str2 = yaVar.wiv.vFY;
            aum com_tencent_mm_protocal_c_aum = yaVar.wiv;
            if (com_tencent_mm_protocal_c_aum == null) {
                x.e("MicroMsg.NetSceneGetAppInfo", "convertToAppInfo : openAppInfo is null");
                fVar = null;
            } else {
                fVar = new f();
                fVar.field_appId = com_tencent_mm_protocal_c_aum.nfn;
                fVar.field_appName = com_tencent_mm_protocal_c_aum.niZ;
                fVar.field_appDiscription = com_tencent_mm_protocal_c_aum.wCq;
                fVar.field_appIconUrl = com_tencent_mm_protocal_c_aum.vFW;
                fVar.field_appStoreUrl = com_tencent_mm_protocal_c_aum.nfJ;
                fVar.field_appVersion = com_tencent_mm_protocal_c_aum.vNa;
                fVar.field_appWatermarkUrl = com_tencent_mm_protocal_c_aum.wCr;
                fVar.field_packageName = com_tencent_mm_protocal_c_aum.vFY;
                fVar.field_signature = p.RJ(com_tencent_mm_protocal_c_aum.vMZ);
                fVar.field_appName_en = com_tencent_mm_protocal_c_aum.wCs;
                fVar.field_appName_tw = com_tencent_mm_protocal_c_aum.wCu;
                fVar.field_appDiscription_en = com_tencent_mm_protocal_c_aum.wCt;
                fVar.field_appDiscription_tw = com_tencent_mm_protocal_c_aum.wCv;
                fVar.field_appInfoFlag = com_tencent_mm_protocal_c_aum.nfu;
                x.d("MicroMsg.NetSceneGetAppInfo", "appid = %s, appInfoFlag = %s", new Object[]{fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag)});
            }
            if (fVar == null) {
                x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info is null");
                this.gJT.a(3, -1, str, this);
                return;
            }
            fVar.field_appType = yaVar.vIU;
            aum com_tencent_mm_protocal_c_aum2 = yaVar.wiv;
            String str3 = com_tencent_mm_protocal_c_aum2.vFY;
            String str4 = com_tencent_mm_protocal_c_aum2.vMZ;
            Object obj = (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) ? 1 : null;
            if (obj != null || fVar.Yz()) {
                x.e("MicroMsg.NetSceneGetAppInfo", "no android app, packageName = " + str2);
                com.tencent.mm.pluginsdk.ui.tools.b.SL(this.appId);
            }
            if (fVar.field_appId == null) {
                x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info.appId is null");
                this.gJT.a(3, -1, str, this);
            } else if (fVar.field_appId.equals(this.appId)) {
                i bin = com.tencent.mm.plugin.y.a.bin();
                n RF = bin.RF(this.appId);
                if (RF == null || RF.field_appId == null || RF.field_appId.length() == 0) {
                    fVar.field_status = obj != null ? 3 : 4;
                    fVar.field_modifyTime = System.currentTimeMillis();
                    if (fVar.field_appId != null) {
                        for (Object equals : veQ) {
                            if (fVar.field_appId.equals(equals)) {
                                fVar.field_status = -1;
                                break;
                            }
                        }
                    }
                    if (bin.l(fVar)) {
                        com.tencent.mm.plugin.y.a.bil().cP(this.appId, 1);
                        com.tencent.mm.plugin.y.a.bil().cP(this.appId, 2);
                        com.tencent.mm.plugin.y.a.bil().cP(this.appId, 3);
                        com.tencent.mm.plugin.y.a.bil().cP(this.appId, 4);
                        com.tencent.mm.plugin.y.a.bil().cP(this.appId, 5);
                    } else {
                        x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : insert fail");
                        this.gJT.a(3, -1, str, this);
                        return;
                    }
                }
                fVar.field_status = obj != null ? 3 : RF.field_status;
                if (fVar.field_appId != null) {
                    for (Object equals2 : veQ) {
                        if (fVar.field_appId.equals(equals2)) {
                            fVar.field_status = -1;
                            break;
                        }
                    }
                }
                if (RF == null) {
                    x.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appinfo is null");
                } else {
                    if (RF.bYD()) {
                        if (!bh.ov(RF.field_appIconUrl)) {
                            fVar.field_appIconUrl = RF.field_appIconUrl;
                        }
                        if (!bh.ov(RF.field_appName)) {
                            fVar.field_appName = RF.field_appName;
                        }
                        if (!bh.ov(RF.field_appName_en)) {
                            fVar.field_appName_en = RF.field_appName_en;
                        }
                        if (!bh.ov(RF.field_appName_tw)) {
                            fVar.field_appName_tw = RF.field_appName_tw;
                        }
                        if (!bh.ov(RF.field_appName_hk)) {
                            fVar.field_appName_hk = RF.field_appName_hk;
                        }
                    }
                    if (bh.ov(fVar.field_appId) || bh.ov(RF.field_appId)) {
                        x.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appid is null");
                    } else if (fVar.field_appId.equalsIgnoreCase(RF.field_appId)) {
                        fVar.field_openId = RF.field_openId;
                        fVar.field_authFlag = RF.field_authFlag;
                        fVar.cM(RF.fQC);
                        fVar.cN(RF.fQD);
                        fVar.cO(RF.fQE);
                    } else {
                        x.e("MicroMsg.NetSceneGetAppInfo", "merge failed, appis is different");
                    }
                }
                if (bin.a(fVar, new String[0])) {
                    if (RF == null || RF.field_appIconUrl == null || RF.field_appIconUrl.length() == 0) {
                        obj = 1;
                    } else {
                        if (!bh.ov(fVar.fQW)) {
                            if (bh.ov(RF.fQW)) {
                                obj = 1;
                            } else if (!RF.fQW.equals(RF.fQW)) {
                                obj = 1;
                            }
                        }
                        if (!bh.ov(fVar.fQX)) {
                            if (bh.ov(RF.fQX)) {
                                obj = 1;
                            } else if (!RF.fQX.equals(RF.fQX)) {
                                obj = 1;
                            }
                        }
                        obj = (fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? null : !RF.field_appIconUrl.equals(fVar.field_appIconUrl) ? 1 : null;
                    }
                    if (obj != null) {
                        com.tencent.mm.plugin.y.a.bil().cP(this.appId, 1);
                        com.tencent.mm.plugin.y.a.bil().cP(this.appId, 2);
                        com.tencent.mm.plugin.y.a.bil().cP(this.appId, 3);
                        com.tencent.mm.plugin.y.a.bil().cP(this.appId, 4);
                        com.tencent.mm.plugin.y.a.bil().cP(this.appId, 5);
                    }
                } else {
                    x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : update fail");
                    this.gJT.a(3, -1, str, this);
                    return;
                }
                if (bh.ov(fVar.field_openId)) {
                    x.d("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd, openId is null, trigger getAppSetting, appId = " + fVar.field_appId);
                    com.tencent.mm.plugin.y.a.bip().OI(fVar.field_appId);
                }
                this.gJT.a(i2, i3, str, this);
            } else {
                x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : appId is different");
                this.gJT.a(3, -1, str, this);
            }
        } else {
            x.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 231;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }
}
