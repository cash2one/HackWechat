package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.f;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfn;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.cx;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.t;
import com.tencent.mm.z.u;
import java.util.Locale;

public final class ai extends k implements com.tencent.mm.network.k {
    private au fEJ = null;
    private long fqm = 0;
    private b gJQ;
    private e gJT;
    private keep_SceneResult gLW = null;
    private String iKB;
    private tu qUe;
    private n veV;
    private b veY = null;
    private boolean veZ = false;
    private a vfa = null;

    interface a {
        void bn(int i, int i2);
    }

    public ai(long j, boolean z, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, a aVar, String str, b bVar) {
        this.fqm = j;
        this.iKB = str;
        this.gLW = com_tencent_mm_modelcdntran_keep_SceneResult;
        this.vfa = aVar;
        this.veZ = z;
        this.veY = bVar;
        com.tencent.mm.ae.b.a aVar2 = new com.tencent.mm.ae.b.a();
        aVar2.hmj = new bfn();
        aVar2.hmk = new bfo();
        aVar2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar2.hmi = 222;
        aVar2.hml = 107;
        aVar2.hmm = 1000000107;
        this.gJQ = aVar2.JZ();
        x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[]{Long.valueOf(j), com_tencent_mm_modelcdntran_keep_SceneResult, str, bVar, bh.cgy()});
    }

    public final int getType() {
        return 222;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        ar.Hg();
        this.fEJ = c.Fa().dH(this.fqm);
        if (this.fEJ == null || this.fEJ.field_msgId != this.fqm) {
            x.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[]{Long.valueOf(this.fqm)});
            this.vfa.bn(3, -1);
            return -1;
        }
        String str;
        int i;
        String string;
        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(this.fEJ.field_content);
        if (fT == null) {
            x.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[]{Long.valueOf(this.fqm)});
            this.vfa.bn(3, -1);
        }
        bfn com_tencent_mm_protocal_c_bfn = (bfn) this.gJQ.hmg.hmo;
        cx cxVar = new cx();
        cxVar.ngo = fT.appId;
        cxVar.vHU = this.fEJ.field_talker + this.fEJ.field_msgId + "T" + this.fEJ.field_createTime;
        cxVar.pbl = (int) bh.Wo();
        cxVar.nko = this.fEJ.field_talker;
        cxVar.nkp = com.tencent.mm.z.q.FS();
        cxVar.ktN = fT.type;
        cxVar.vHT = fT.sdkVer;
        cxVar.vHW = fT.hbe;
        if (f.eE(this.fEJ.field_talker)) {
            cxVar.vHc = com.tencent.mm.ag.a.e.kr(this.fEJ.gjF);
        } else {
            cxVar.vHc = bc.HD();
        }
        cxVar.vHY = fT.fGC;
        cxVar.vHZ = fT.fGD;
        cxVar.vIa = fT.fGE;
        u.b hy = u.GK().hy(this.iKB);
        if (hy != null) {
            this.qUe = new tu();
            this.qUe.fMo.url = fT.url;
            this.qUe.fMo.fMp = hy.getString("prePublishId", "");
            this.qUe.fMo.fMr = hy.getString("preUsername", "");
            this.qUe.fMo.fMs = hy.getString("preChatName", "");
            this.qUe.fMo.fMt = hy.getInt("preMsgIndex", 0);
            this.qUe.fMo.fMx = hy.getInt("sendAppMsgScene", 0);
            this.qUe.fMo.fMy = hy.getInt("getA8KeyScene", 0);
            this.qUe.fMo.fMz = hy.getString("referUrl", null);
            this.qUe.fMo.fMA = hy.getString("adExtStr", null);
            this.qUe.fMo.fMu = this.fEJ.field_talker;
            this.qUe.fMo.fMB = fT.title;
            ar.Hg();
            com.tencent.mm.storage.x WO = c.EY().WO(this.fEJ.field_talker);
            if (WO != null) {
                this.qUe.fMo.fMv = WO.AP();
            }
            this.qUe.fMo.fMw = m.gl(this.fEJ.field_talker);
            str = "";
            if (fT.fGG != null) {
                blt com_tencent_mm_protocal_c_blt = new blt();
                try {
                    com_tencent_mm_protocal_c_blt.aF(Base64.decode(fT.fGG, 0));
                    if (com_tencent_mm_protocal_c_blt.wPn != null) {
                        str = com_tencent_mm_protocal_c_blt.wPn.nbS;
                    }
                } catch (Exception e) {
                }
            }
            com_tencent_mm_protocal_c_bfn.wKz = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.qUe.fMo.fMp, this.qUe.fMo.fMr, this.qUe.fMo.fMs, Integer.valueOf(t.N(this.qUe.fMo.fMr, this.qUe.fMo.fMs)), Integer.valueOf(this.qUe.fMo.fMy), str});
        }
        if (hy != null && fT.type == 33) {
            this.veV = new n();
            i = hy.getInt("fromScene", 1);
            this.veV.fnn.scene = i;
            this.veV.fnn.fnv = hy.getInt("appservicetype", 0);
            string = hy.getString("preChatName", "");
            if (2 == i) {
                this.veV.fnn.fnp = string + ":" + hy.getString("preUsername", "");
            } else {
                this.veV.fnn.fnp = string;
            }
            str = this.fEJ.field_talker;
            boolean z = hy.getBoolean("moreRetrAction", false);
            if (str.endsWith("@chatroom")) {
                this.veV.fnn.action = z ? 5 : 2;
            } else {
                this.veV.fnn.action = z ? 4 : 1;
            }
            this.veV.fnn.fno = fT.hdE + 1;
            this.veV.fnn.fnq = fT.hdw;
            this.veV.fnn.fnl = fT.hdx;
            this.veV.fnn.appId = fT.hdy;
            this.veV.fnn.fns = bh.Wo();
            this.veV.fnn.fnt = 1;
        }
        x.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[]{fT.fGC, fT.fGD, fT.fGE});
        int i2 = 0;
        i = 0;
        if (!bh.ov(this.fEJ.field_imgPath)) {
            Options UL = d.UL(o.Pw().lm(this.fEJ.field_imgPath));
            if (UL != null) {
                i2 = UL.outWidth;
                i = UL.outHeight;
            }
        }
        if (this.gLW.isUploadBySafeCDNWithMD5()) {
            x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[]{Integer.valueOf(this.gLW.field_filecrc), Boolean.valueOf(this.gLW.field_upload_by_safecdn), Integer.valueOf(this.gLW.field_UploadHitCacheType), this.gLW.field_aesKey});
            this.gLW.field_aesKey = "";
            com_tencent_mm_protocal_c_bfn.wKA = 1;
        }
        com_tencent_mm_protocal_c_bfn.vQC = this.gLW.field_filecrc;
        string = null;
        if (this.veZ) {
            string = "@cdn_" + this.gLW.field_fileId + "_" + this.gLW.field_aesKey + "_1";
        }
        cxVar.nje = com.tencent.mm.y.g.a.a(fT, string, this.gLW, i2, i);
        com_tencent_mm_protocal_c_bfn.wKx = cxVar;
        if (this.veY != null && (fT.hbf != 0 || fT.hbb > 26214400)) {
            com_tencent_mm_protocal_c_bfn.hvw = this.veY.field_signature;
            com_tencent_mm_protocal_c_bfn.vIE = com.tencent.mm.modelcdntran.b.hrM;
        }
        com_tencent_mm_protocal_c_bfn.vZL = fT.filemd5;
        if (bh.ov(this.gLW.field_filemd5)) {
            x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[]{fT.filemd5});
        } else {
            com_tencent_mm_protocal_c_bfn.vZL = this.gLW.field_filemd5;
        }
        x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[]{com_tencent_mm_protocal_c_bfn.vZL, Integer.valueOf(com_tencent_mm_protocal_c_bfn.wKA), bh.VT(com_tencent_mm_protocal_c_bfn.hvw), Integer.valueOf(com_tencent_mm_protocal_c_bfn.vIE), this.gLW, com_tencent_mm_protocal_c_bfn.wKz});
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bfn com_tencent_mm_protocal_c_bfn = (bfn) ((b) qVar).hmg.hmo;
        x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.fqm), this.fEJ.field_content, com_tencent_mm_protocal_c_bfn.wKx.nje});
        if (i2 == 0 && i3 == 0) {
            bfo com_tencent_mm_protocal_c_bfo = (bfo) ((b) qVar).hmh.hmo;
            x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bfo.vHe), com_tencent_mm_protocal_c_bfo.vQA, this.fEJ.field_content});
            if (this.gLW != null && this.gLW.isUploadBySafeCDNWithMD5()) {
                if (bh.ov(com_tencent_mm_protocal_c_bfo.vQA)) {
                    x.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
                } else {
                    com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(this.fEJ.field_content);
                    fT.hbp = com_tencent_mm_protocal_c_bfo.vQA;
                    this.fEJ.setContent(com.tencent.mm.y.g.a.a(fT, null, null));
                    x.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[]{com_tencent_mm_protocal_c_bfo.vQA, this.fEJ.field_content});
                }
            }
            this.fEJ.eQ(2);
            this.fEJ.ap(com_tencent_mm_protocal_c_bfo.vHe);
            ar.Hg();
            c.Fa().a(this.fEJ.field_msgId, this.fEJ);
            com.tencent.mm.modelstat.b.hPA.a(this.fEJ, h.g(this.fEJ));
            this.gJT.a(i2, i3, str, this);
            this.vfa.bn(i2, i3);
            if (!(this.qUe == null || bh.ov(this.qUe.fMo.url))) {
                this.qUe.fMo.fMq = "msg_" + Long.toString(com_tencent_mm_protocal_c_bfo.vHe);
                com.tencent.mm.sdk.b.a.xef.m(this.qUe);
            }
            if (this.veV != null) {
                this.veV.fnn.fnr = "msg_" + this.fEJ.field_msgSvrId;
                com.tencent.mm.sdk.b.a.xef.m(this.veV);
            }
        } else if (i2 == 4 && i3 == 102) {
            x.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
            this.gJT.a(i2, i3, str, this);
            this.vfa.bn(i2, i3);
        } else {
            this.fEJ.eQ(5);
            ar.Hg();
            c.Fa().a(this.fEJ.field_msgId, this.fEJ);
            x.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + i2 + "," + i3);
            this.gJT.a(i2, i3, str, this);
            this.vfa.bn(i2, i3);
        }
    }
}
