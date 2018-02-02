package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.ab;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.protocal.c.brb;
import com.tencent.mm.protocal.c.brc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import junit.framework.Assert;

public final class h extends k implements com.tencent.mm.network.k {
    String fileName = null;
    private b gJQ;
    private e gJT;
    private a hUA = null;
    private int hUy = 0;
    private keep_SceneResult hUz = null;

    public h(String str, int i, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, a aVar) {
        boolean z = false;
        Assert.assertTrue(str != null);
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            z = true;
        }
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        this.fileName = str;
        this.hUz = com_tencent_mm_modelcdntran_keep_SceneResult;
        this.hUA = aVar;
        this.hUy = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        r nF = t.nF(this.fileName);
        if (nF == null) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
            this.hUA.bn(3, -1);
            return -1;
        }
        String HD;
        int i;
        String str;
        String str2;
        Object[] objArr;
        a aVar = new a();
        aVar.hmj = new brb();
        aVar.hmk = new brc();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.hmi = f.CTRL_INDEX;
        aVar.hml = 39;
        aVar.hmm = 1000000039;
        this.gJQ = aVar.JZ();
        brb com_tencent_mm_protocal_c_brb = (brb) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_brb.wSu = 0;
        com_tencent_mm_protocal_c_brb.wSt = this.hUz.field_fileLength;
        com_tencent_mm_protocal_c_brb.wSv = new bdn().bj(new byte[0]);
        com_tencent_mm_protocal_c_brb.wxq = 0;
        com_tencent_mm_protocal_c_brb.wxp = this.hUz.field_thumbimgLength;
        com_tencent_mm_protocal_c_brb.wxr = new bdn().bj(new byte[0]);
        com_tencent_mm_protocal_c_brb.nkp = q.FS();
        com_tencent_mm_protocal_c_brb.nko = this.hUz.field_toUser;
        com_tencent_mm_protocal_c_brb.vHU = this.fileName;
        if (nF.hVL == 1) {
            com_tencent_mm_protocal_c_brb.wSx = 2;
        }
        if (nF.hVO == 3) {
            com_tencent_mm_protocal_c_brb.wSx = 3;
        }
        com_tencent_mm_protocal_c_brb.wSw = nF.hVH;
        com_tencent_mm_protocal_c_brb.vZu = ab.bC(ac.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_brb.wxs = 2;
        com_tencent_mm_protocal_c_brb.wSl = this.hUz.field_thumbimgLength;
        com_tencent_mm_protocal_c_brb.wSy = this.hUz.field_fileId;
        com_tencent_mm_protocal_c_brb.wrR = this.hUz.field_fileId;
        com_tencent_mm_protocal_c_brb.vQB = 1;
        if (this.hUz.isUploadBySafeCDNWithMD5()) {
            x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", TL(), Boolean.valueOf(this.hUz.field_upload_by_safecdn), Integer.valueOf(this.hUz.field_UploadHitCacheType), Integer.valueOf(this.hUz.field_filecrc), this.hUz.field_aesKey);
            com_tencent_mm_protocal_c_brb.wKA = 1;
            com_tencent_mm_protocal_c_brb.vQA = "";
            com_tencent_mm_protocal_c_brb.wrT = "";
        } else {
            com_tencent_mm_protocal_c_brb.vQA = this.hUz.field_aesKey;
            com_tencent_mm_protocal_c_brb.wrT = this.hUz.field_aesKey;
        }
        com_tencent_mm_protocal_c_brb.wSA = this.hUz.field_filemd5;
        com_tencent_mm_protocal_c_brb.wSK = this.hUz.field_mp4identifymd5;
        com_tencent_mm_protocal_c_brb.vQC = this.hUz.field_filecrc;
        if (this.hUy <= 0 || this.hUy > 1048576) {
            HD = bc.HD();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<msgsource>");
            stringBuilder.append("<videopreloadlen>").append(this.hUy).append("</videopreloadlen>");
            stringBuilder.append("</msgsource>");
            g.pQN.a(354, 35, 1, false);
            HD = stringBuilder.toString();
        }
        com_tencent_mm_protocal_c_brb.vHc = HD;
        com_tencent_mm_protocal_c_brb.wSJ = nF.fGG;
        bmf com_tencent_mm_protocal_c_bmf = nF.hVQ;
        if (com_tencent_mm_protocal_c_bmf != null && !bh.ov(com_tencent_mm_protocal_c_bmf.hdo)) {
            com_tencent_mm_protocal_c_brb.wSB = bh.az(com_tencent_mm_protocal_c_bmf.hdo, "");
            com_tencent_mm_protocal_c_brb.wSC = com_tencent_mm_protocal_c_bmf.weC;
            com_tencent_mm_protocal_c_brb.wSD = bh.az(com_tencent_mm_protocal_c_bmf.hdq, "");
            com_tencent_mm_protocal_c_brb.wSF = bh.az(com_tencent_mm_protocal_c_bmf.hds, "");
            com_tencent_mm_protocal_c_brb.wSE = bh.az(com_tencent_mm_protocal_c_bmf.hdr, "");
            com_tencent_mm_protocal_c_brb.wSG = bh.az(com_tencent_mm_protocal_c_bmf.hdt, "");
        } else if (!(com_tencent_mm_protocal_c_bmf == null || bh.ov(com_tencent_mm_protocal_c_bmf.hds) || bh.ov(com_tencent_mm_protocal_c_bmf.hdr))) {
            com_tencent_mm_protocal_c_brb.wSF = com_tencent_mm_protocal_c_bmf.hds;
            com_tencent_mm_protocal_c_brb.wSE = com_tencent_mm_protocal_c_bmf.hdr;
        }
        if (com_tencent_mm_protocal_c_bmf != null) {
            com_tencent_mm_protocal_c_brb.wSI = bh.az(com_tencent_mm_protocal_c_bmf.hdu, "");
            com_tencent_mm_protocal_c_brb.wSH = bh.az(com_tencent_mm_protocal_c_bmf.hdv, "");
        }
        o.TU();
        Options UL = d.UL(s.nu(this.fileName));
        if (UL != null) {
            com_tencent_mm_protocal_c_brb.wSn = UL.outWidth;
            com_tencent_mm_protocal_c_brb.wSm = UL.outHeight;
        } else {
            x.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", HD);
        }
        o.TU();
        HD = s.nt(this.fileName);
        n TS = n.TS();
        if (!bh.ov(HD)) {
            n.a aVar2 = (n.a) TS.hUV.get(HD);
            if (aVar2 != null) {
                i = aVar2.hVm;
                switch (i) {
                    case 1:
                        com_tencent_mm_protocal_c_brb.vQD = 1;
                        com_tencent_mm_protocal_c_brb.vHW = 2;
                        break;
                    case 2:
                        com_tencent_mm_protocal_c_brb.vQD = 1;
                        com_tencent_mm_protocal_c_brb.vHW = 1;
                        break;
                    case 3:
                    case 6:
                        com_tencent_mm_protocal_c_brb.vQD = 2;
                        com_tencent_mm_protocal_c_brb.vHW = 3;
                        break;
                    case 7:
                        com_tencent_mm_protocal_c_brb.vQD = 3;
                        com_tencent_mm_protocal_c_brb.vHW = 4;
                        break;
                    case 8:
                        com_tencent_mm_protocal_c_brb.vQD = 1;
                        com_tencent_mm_protocal_c_brb.vHW = 5;
                        break;
                    default:
                        com_tencent_mm_protocal_c_brb.vQD = 0;
                        com_tencent_mm_protocal_c_brb.vHW = 0;
                        break;
                }
                str = "MicroMsg.NetSceneUploadVideoForCdn";
                str2 = "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]";
                objArr = new Object[22];
                objArr[0] = TL();
                objArr[1] = this.fileName;
                objArr[2] = this.hUz.field_toUser;
                if (this.hUz.field_aesKey != null) {
                    i = -1;
                } else {
                    i = this.hUz.field_aesKey.length();
                }
                objArr[3] = Integer.valueOf(i);
                objArr[4] = this.hUz.field_fileId;
                objArr[5] = Integer.valueOf(this.hUz.field_thumbimgLength);
                objArr[6] = Integer.valueOf(com_tencent_mm_protocal_c_brb.wSn);
                objArr[7] = Integer.valueOf(com_tencent_mm_protocal_c_brb.wSm);
                objArr[8] = bh.VT(com_tencent_mm_protocal_c_brb.wrT);
                objArr[9] = Integer.valueOf(com_tencent_mm_protocal_c_brb.wSx);
                objArr[10] = com_tencent_mm_protocal_c_brb.wSA;
                objArr[11] = Integer.valueOf(com_tencent_mm_protocal_c_brb.wKA);
                objArr[12] = Integer.valueOf(com_tencent_mm_protocal_c_brb.vQC);
                objArr[13] = com_tencent_mm_protocal_c_brb.wSK;
                objArr[14] = bh.VT(com_tencent_mm_protocal_c_brb.vQA);
                objArr[15] = com_tencent_mm_protocal_c_brb.wSB;
                objArr[16] = Integer.valueOf(com_tencent_mm_protocal_c_brb.wSC);
                objArr[17] = com_tencent_mm_protocal_c_brb.wSD;
                objArr[18] = com_tencent_mm_protocal_c_brb.wSG;
                objArr[19] = com_tencent_mm_protocal_c_brb.vHc;
                objArr[20] = Integer.valueOf(com_tencent_mm_protocal_c_brb.vQD);
                objArr[21] = Integer.valueOf(com_tencent_mm_protocal_c_brb.vHW);
                x.i(str, str2, objArr);
                return a(eVar, this.gJQ, this);
            }
        }
        i = 0;
        switch (i) {
            case 1:
                com_tencent_mm_protocal_c_brb.vQD = 1;
                com_tencent_mm_protocal_c_brb.vHW = 2;
                break;
            case 2:
                com_tencent_mm_protocal_c_brb.vQD = 1;
                com_tencent_mm_protocal_c_brb.vHW = 1;
                break;
            case 3:
            case 6:
                com_tencent_mm_protocal_c_brb.vQD = 2;
                com_tencent_mm_protocal_c_brb.vHW = 3;
                break;
            case 7:
                com_tencent_mm_protocal_c_brb.vQD = 3;
                com_tencent_mm_protocal_c_brb.vHW = 4;
                break;
            case 8:
                com_tencent_mm_protocal_c_brb.vQD = 1;
                com_tencent_mm_protocal_c_brb.vHW = 5;
                break;
            default:
                com_tencent_mm_protocal_c_brb.vQD = 0;
                com_tencent_mm_protocal_c_brb.vHW = 0;
                break;
        }
        str = "MicroMsg.NetSceneUploadVideoForCdn";
        str2 = "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]";
        objArr = new Object[22];
        objArr[0] = TL();
        objArr[1] = this.fileName;
        objArr[2] = this.hUz.field_toUser;
        if (this.hUz.field_aesKey != null) {
            i = this.hUz.field_aesKey.length();
        } else {
            i = -1;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = this.hUz.field_fileId;
        objArr[5] = Integer.valueOf(this.hUz.field_thumbimgLength);
        objArr[6] = Integer.valueOf(com_tencent_mm_protocal_c_brb.wSn);
        objArr[7] = Integer.valueOf(com_tencent_mm_protocal_c_brb.wSm);
        objArr[8] = bh.VT(com_tencent_mm_protocal_c_brb.wrT);
        objArr[9] = Integer.valueOf(com_tencent_mm_protocal_c_brb.wSx);
        objArr[10] = com_tencent_mm_protocal_c_brb.wSA;
        objArr[11] = Integer.valueOf(com_tencent_mm_protocal_c_brb.wKA);
        objArr[12] = Integer.valueOf(com_tencent_mm_protocal_c_brb.vQC);
        objArr[13] = com_tencent_mm_protocal_c_brb.wSK;
        objArr[14] = bh.VT(com_tencent_mm_protocal_c_brb.vQA);
        objArr[15] = com_tencent_mm_protocal_c_brb.wSB;
        objArr[16] = Integer.valueOf(com_tencent_mm_protocal_c_brb.wSC);
        objArr[17] = com_tencent_mm_protocal_c_brb.wSD;
        objArr[18] = com_tencent_mm_protocal_c_brb.wSG;
        objArr[19] = com_tencent_mm_protocal_c_brb.vHc;
        objArr[20] = Integer.valueOf(com_tencent_mm_protocal_c_brb.vQD);
        objArr[21] = Integer.valueOf(com_tencent_mm_protocal_c_brb.vHW);
        x.i(str, str2, objArr);
        return a(eVar, this.gJQ, this);
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hmP;
    }

    protected final int Bh() {
        return 1;
    }

    protected final void a(a aVar) {
        t.ny(this.fileName);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", TL(), Integer.valueOf(i2), Integer.valueOf(i3));
        brc com_tencent_mm_protocal_c_brc = (brc) ((b) qVar).hmh.hmo;
        r nF = t.nF(this.fileName);
        if (nF == null) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
            this.gJT.a(i2, i3, str, this);
            this.hUA.bn(3, -1);
        } else if (i2 == 4 && i3 == 102) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nF.Ud());
            this.gJT.a(i2, i3, str, this);
            this.hUA.bn(i2, i3);
        } else if (i2 == 4 && i3 == -22) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nF.Ud());
            t.nz(this.fileName);
            this.gJT.a(i2, i3, str, this);
            this.hUA.bn(i2, i3);
        } else if (i2 == 4 && i3 != 0) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nF.Ud());
            t.ny(this.fileName);
            this.gJT.a(i2, i3, str, this);
            this.hUA.bn(i2, i3);
        } else if (i2 == 0 && i3 == 0) {
            nF.hVF = bh.Wo();
            nF.fFo = com_tencent_mm_protocal_c_brc.vHe;
            x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", TL(), Long.valueOf(nF.fFo), Integer.valueOf(r.idu));
            if (!(CdnLogic.kMediaTypeFavoriteBigFile != r.idt || r.idu == 0 || nF.fFo == 0)) {
                nF.fFo = (long) r.idu;
                r.idu = 0;
            }
            nF.status = 199;
            nF.fDt = 1284;
            if (this.hUz.isUploadBySafeCDNWithMD5()) {
                x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", TL(), com_tencent_mm_protocal_c_brc.vQA, nF.Ug());
                if (bh.ov(com_tencent_mm_protocal_c_brc.vQA)) {
                    x.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", TL());
                } else {
                    x.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + com_tencent_mm_protocal_c_brc.vQA + "\" cdnthumbaeskey=\"" + com_tencent_mm_protocal_c_brc.vQA + "\" cdnvideourl=\"" + this.hUz.field_fileId + "\" ") + "cdnthumburl=\"" + this.hUz.field_fileId + "\" ") + "length=\"" + this.hUz.field_fileLength + "\" ") + "cdnthumblength=\"" + this.hUz.field_thumbimgLength + "\"/></msg>");
                    nF.hVN = r1;
                    s TU = o.TU();
                    o.TU();
                    boolean p = TU.p(s.nt(this.fileName), this.hUz.field_fileId, com_tencent_mm_protocal_c_brc.vQA);
                    g gVar = g.pQN;
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf((p ? 1 : 2) + 900);
                    objArr[1] = Integer.valueOf(nF.hlp);
                    gVar.h(12696, objArr);
                    x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", TL(), com_tencent_mm_protocal_c_brc.vQA, nF.Ug(), Boolean.valueOf(p));
                }
            }
            t.e(nF);
            t.c(nF);
            com.tencent.mm.modelstat.b.hPA.f(((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi().dH((long) nF.hVI));
            com.tencent.mm.l.a WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(nF.Ud());
            boolean cia = (WO == null || ((int) WO.gJd) <= 0) ? false : WO.cia();
            if (cia || s.gR(nF.Ud())) {
                x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", TL(), nF.Ud());
                if (nF.fFo < 0) {
                    x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + nF.fFo + " file:" + this.fileName + " toUser:" + nF.Ud());
                    t.ny(this.fileName);
                    this.hUA.bn(3, -1);
                }
            } else {
                x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", TL());
                if (nF.fFo <= 0) {
                    x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + nF.fFo + " file:" + this.fileName + " toUser:" + nF.Ud());
                    t.ny(this.fileName);
                    this.hUA.bn(3, -1);
                }
            }
            this.gJT.a(i2, i3, str, this);
            this.hUA.bn(0, 0);
        } else {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nF.Ud());
            t.ny(this.fileName);
            this.gJT.a(i2, i3, str, this);
            this.hUA.bn(i2, i3);
        }
    }

    public final int getType() {
        return f.CTRL_INDEX;
    }

    private String TL() {
        return this.fileName + "_" + hashCode();
    }
}
