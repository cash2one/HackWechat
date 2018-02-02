package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.f;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bfn;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.cx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g$a;
import com.tencent.mm.y.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.t;
import com.tencent.mm.z.u;
import com.tencent.mm.z.u$b;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ah extends k implements com.tencent.mm.network.k {
    au fEJ = null;
    long fqm = 0;
    private b gJQ;
    e gJT;
    String hBn = "";
    private a hBx = new 1(this);
    int hUs = 0;
    String iKB;
    private tu qUe;
    private String rLk;
    long startTime = 0;
    private n veV;

    public ah(long j, String str, String str2) {
        this.fqm = j;
        this.iKB = str;
        this.rLk = str2;
        b.a aVar = new b.a();
        aVar.hmj = new bfn();
        aVar.hmk = new bfo();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar.hmi = 222;
        aVar.hml = 107;
        aVar.hmm = 1000000107;
        this.gJQ = aVar.JZ();
        x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[]{Long.valueOf(j), str, bh.VT(str2), bh.cgy()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        if (this.startTime == 0) {
            this.startTime = bh.Wp();
        }
        ar.Hg();
        this.fEJ = c.Fa().dH(this.fqm);
        if (this.fEJ == null || this.fEJ.field_msgId != this.fqm) {
            return -1;
        }
        g$a com_tencent_mm_y_g_a;
        g$a fT = g$a.fT(this.fEJ.field_content);
        if (fT == null) {
            aj Xp = aj.Xp(this.fEJ.field_content);
            if (bh.ov(Xp.xyA)) {
                fT = new g$a();
                fT.hbd = Xp.fqR;
                fT.type = 8;
                x.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
                com_tencent_mm_y_g_a = fT;
            } else {
                com_tencent_mm_y_g_a = g$a.fT(Xp.xyA);
            }
        } else {
            com_tencent_mm_y_g_a = fT;
        }
        Assert.assertTrue("content != null [[" + this.fEJ.field_content + "]]", com_tencent_mm_y_g_a != null);
        if (com_tencent_mm_y_g_a == null) {
            this.fEJ = null;
            return -1;
        }
        String str;
        Object obj;
        String str2 = "";
        if (bh.ov(this.fEJ.field_imgPath)) {
            str = str2;
        } else {
            str = o.Pw().lm(this.fEJ.field_imgPath);
        }
        if (com_tencent_mm_y_g_a.type == 8 || com_tencent_mm_y_g_a.type == 9 || com_tencent_mm_y_g_a.type == 6) {
            x.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", new Object[]{Integer.valueOf(com_tencent_mm_y_g_a.type)});
            obj = null;
        } else if (bh.ov(str)) {
            x.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[]{Integer.valueOf(com_tencent_mm_y_g_a.type)});
            obj = null;
        } else {
            this.hUs = com.tencent.mm.a.e.bN(str);
            if (com_tencent_mm_y_g_a.type == 33 || com_tencent_mm_y_g_a.type == 36 || this.hUs < 262144) {
                x.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[]{Integer.valueOf(com_tencent_mm_y_g_a.type), str, Integer.valueOf(this.hUs)});
                if (bh.ov(com_tencent_mm_y_g_a.fny)) {
                    g.MJ();
                    if (com.tencent.mm.modelcdntran.c.hu(4)) {
                        this.hBn = d.a("upappmsg", this.fEJ.field_createTime, this.fEJ.field_talker, this.fEJ.field_msgId);
                        if (bh.ov(this.hBn)) {
                            x.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[]{Long.valueOf(this.fEJ.field_msgId)});
                            obj = null;
                        } else {
                            i iVar = new i();
                            iVar.htt = this.hBx;
                            iVar.field_mediaId = this.hBn;
                            iVar.field_fullpath = "";
                            iVar.field_thumbpath = str;
                            iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                            iVar.field_talker = this.fEJ.field_talker;
                            iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
                            iVar.field_needStorage = false;
                            iVar.field_isStreamMedia = false;
                            iVar.htt = this.hBx;
                            iVar.field_force_aeskeycdn = true;
                            iVar.field_trysafecdn = false;
                            x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[]{Integer.valueOf(com_tencent_mm_y_g_a.type), str, this.hBn, Integer.valueOf(iVar.field_fileType), Boolean.valueOf(iVar.field_enable_hitcheck), Boolean.valueOf(iVar.field_onlycheckexist), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn)});
                            if (g.MJ().c(iVar)) {
                                obj = 1;
                            } else {
                                x.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                                this.hBn = "";
                                obj = null;
                            }
                        }
                    } else {
                        Object[] objArr = new Object[1];
                        g.MJ();
                        objArr[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hu(4));
                        x.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", objArr);
                        obj = null;
                    }
                } else {
                    x.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[]{Long.valueOf(this.fqm)});
                    obj = null;
                }
            } else {
                x.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[]{str, Integer.valueOf(this.hUs)});
                obj = null;
            }
        }
        if (obj != null) {
            x.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[]{this.hBn});
            return 0;
        }
        String str3;
        bfn com_tencent_mm_protocal_c_bfn = (bfn) this.gJQ.hmg.hmo;
        cx cxVar = new cx();
        cxVar.ngo = com_tencent_mm_y_g_a.appId;
        cxVar.vHU = this.fEJ.field_talker + this.fEJ.field_msgId + "T" + this.fEJ.field_createTime;
        cxVar.nje = g$a.a(com_tencent_mm_y_g_a, null, null, 0, 0);
        cxVar.pbl = (int) bh.Wo();
        cxVar.nko = this.fEJ.field_talker;
        cxVar.nkp = q.FS();
        cxVar.ktN = com_tencent_mm_y_g_a.type;
        cxVar.vHT = com_tencent_mm_y_g_a.sdkVer;
        cxVar.vHW = com_tencent_mm_y_g_a.hbe;
        if (f.eE(this.fEJ.field_talker)) {
            cxVar.vHc = com.tencent.mm.ag.a.e.kr(this.fEJ.gjF);
        } else {
            cxVar.vHc = bc.HD();
        }
        cxVar.vHY = com_tencent_mm_y_g_a.fGC;
        cxVar.vHZ = com_tencent_mm_y_g_a.fGD;
        cxVar.vIa = com_tencent_mm_y_g_a.fGE;
        u$b hy = u.GK().hy(this.iKB);
        if (hy != null) {
            this.qUe = new tu();
            this.qUe.fMo.url = com_tencent_mm_y_g_a.url;
            this.qUe.fMo.fMp = hy.getString("prePublishId", "");
            this.qUe.fMo.fMr = hy.getString("preUsername", "");
            this.qUe.fMo.fMs = hy.getString("preChatName", "");
            this.qUe.fMo.fMt = hy.getInt("preMsgIndex", 0);
            this.qUe.fMo.fMx = hy.getInt("sendAppMsgScene", 0);
            this.qUe.fMo.fMy = hy.getInt("getA8KeyScene", 0);
            this.qUe.fMo.fMz = hy.getString("referUrl", null);
            this.qUe.fMo.fMA = hy.getString("adExtStr", null);
            this.qUe.fMo.fMu = this.fEJ.field_talker;
            this.qUe.fMo.fMB = com_tencent_mm_y_g_a.title;
            ar.Hg();
            com.tencent.mm.storage.x WO = c.EY().WO(this.fEJ.field_talker);
            if (WO != null) {
                this.qUe.fMo.fMv = WO.AP();
            }
            this.qUe.fMo.fMw = m.gl(this.fEJ.field_talker);
            str3 = "";
            if (com_tencent_mm_y_g_a.fGG != null) {
                blt com_tencent_mm_protocal_c_blt = new blt();
                try {
                    com_tencent_mm_protocal_c_blt.aF(Base64.decode(com_tencent_mm_y_g_a.fGG, 0));
                    if (com_tencent_mm_protocal_c_blt.wPn != null) {
                        str3 = com_tencent_mm_protocal_c_blt.wPn.nbS;
                    }
                } catch (Exception e) {
                }
            }
            com_tencent_mm_protocal_c_bfn.wKz = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.qUe.fMo.fMp, this.qUe.fMo.fMr, this.qUe.fMo.fMs, Integer.valueOf(t.N(this.qUe.fMo.fMr, this.qUe.fMo.fMs)), Integer.valueOf(this.qUe.fMo.fMy), str3});
        }
        if (hy != null && com_tencent_mm_y_g_a.type == 33) {
            this.veV = new n();
            int i = hy.getInt("fromScene", 1);
            this.veV.fnn.scene = i;
            this.veV.fnn.fnv = hy.getInt("appservicetype", 0);
            String string = hy.getString("preChatName", "");
            if (2 == i) {
                this.veV.fnn.fnp = string + ":" + hy.getString("preUsername", "");
            } else {
                this.veV.fnn.fnp = string;
            }
            str3 = this.fEJ.field_talker;
            boolean z = hy.getBoolean("moreRetrAction", false);
            if (str3.endsWith("@chatroom")) {
                this.veV.fnn.action = z ? 5 : 2;
            } else {
                this.veV.fnn.action = z ? 4 : 1;
            }
            this.veV.fnn.fno = com_tencent_mm_y_g_a.hdE + 1;
            this.veV.fnn.fnq = com_tencent_mm_y_g_a.hdw;
            this.veV.fnn.fnl = com_tencent_mm_y_g_a.hdx;
            this.veV.fnn.appId = com_tencent_mm_y_g_a.hdy;
            this.veV.fnn.fns = bh.Wo();
            this.veV.fnn.fnt = 1;
        }
        x.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[]{com_tencent_mm_y_g_a.fGC, com_tencent_mm_y_g_a.fGD, com_tencent_mm_y_g_a.fGE});
        if (!bh.ov(str)) {
            byte[] d = com.tencent.mm.a.e.d(str, 0, -1);
            if (!bh.bw(d)) {
                cxVar.vHV = new bdn().bj(d);
            }
        }
        str3 = "MicroMsg.NetSceneSendAppMsg";
        String str4 = "doScene thumbFile:[%s] thumbdata:%d";
        Object[] objArr2 = new Object[2];
        objArr2[0] = str;
        objArr2[1] = Integer.valueOf(cxVar.vHV != null ? cxVar.vHV.wJB : -1);
        x.d(str3, str4, objArr2);
        com_tencent_mm_protocal_c_bfn.wKx = cxVar;
        if (com_tencent_mm_y_g_a.hbf != 0 || com_tencent_mm_y_g_a.hbb > 26214400) {
            com_tencent_mm_protocal_c_bfn.vIE = com.tencent.mm.modelcdntran.b.hrM;
        }
        com_tencent_mm_protocal_c_bfn.vZL = com_tencent_mm_y_g_a.filemd5;
        com_tencent_mm_protocal_c_bfn.hvw = this.rLk;
        x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[]{com_tencent_mm_protocal_c_bfn.vZL, bh.VT(com_tencent_mm_protocal_c_bfn.hvw), Integer.valueOf(com_tencent_mm_protocal_c_bfn.vIE), com_tencent_mm_protocal_c_bfn.wKz});
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.fqm), this.fEJ.field_content});
        if (i2 == 3 && i3 == -1 && !bh.ov(this.hBn)) {
            x.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[]{this.hBn});
        } else if (i2 == 0 && i3 == 0) {
            bfo com_tencent_mm_protocal_c_bfo = (bfo) ((b) qVar).hmh.hmo;
            bfn com_tencent_mm_protocal_c_bfn = (bfn) ((b) qVar).hmg.hmo;
            this.fEJ.eQ(2);
            this.fEJ.ap(com_tencent_mm_protocal_c_bfo.vHe);
            ar.Hg();
            c.Fa().a(this.fEJ.field_msgId, this.fEJ);
            com.tencent.mm.modelstat.b.hPA.a(this.fEJ, h.g(this.fEJ));
            if (!(this.qUe == null || bh.ov(this.qUe.fMo.url))) {
                this.qUe.fMo.fMq = "msg_" + Long.toString(com_tencent_mm_protocal_c_bfo.vHe);
                com.tencent.mm.sdk.b.a.xef.m(this.qUe);
            }
            g$a fT = g$a.fT(this.fEJ.field_content);
            if (fT != null && "wx4310bbd51be7d979".equals(fT.appId)) {
                Object obj = (bh.ov(this.fEJ.field_talker) || !this.fEJ.field_talker.endsWith("@chatroom")) ? null : 1;
                String str2 = "";
                try {
                    str2 = URLEncoder.encode(fT.description, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", e, "", new Object[0]);
                }
                x.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[]{"1," + (obj != null ? 2 : 1) + ",," + str2});
                com.tencent.mm.plugin.report.service.g.pQN.k(13717, r0);
            }
            if (this.veV != null) {
                this.veV.fnn.fnr = "msg_" + this.fEJ.field_msgSvrId;
                com.tencent.mm.sdk.b.a.xef.m(this.veV);
            }
            if (com_tencent_mm_protocal_c_bfn.wKx.vHV != null) {
                com.tencent.mm.plugin.report.service.g.pQN.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(com_tencent_mm_protocal_c_bfn.wKx.vHV.wJB)});
            }
            this.gJT.a(i2, i3, str, this);
        } else {
            this.fEJ.eQ(5);
            com.tencent.mm.plugin.report.d.pPH.a(111, 34, 1, true);
            ar.Hg();
            c.Fa().a(this.fEJ.field_msgId, this.fEJ);
            x.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + i2 + "," + i3 + ", msgId " + this.fEJ.field_msgId);
            if (i2 == 4) {
                com.tencent.mm.plugin.report.service.g.pQN.h(10420, new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bh.Wp()), Integer.valueOf(d.bi(ac.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(0)});
            }
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 222;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return k.b.hmP;
    }
}
