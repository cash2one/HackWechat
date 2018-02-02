package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.b.c;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.a.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bjo;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.x;
import java.io.OutputStream;

public final class o extends k implements com.tencent.mm.network.k {
    private String filename;
    private b gJQ;
    public e gJT;
    private OutputStream hlF = null;
    String mediaId = "";
    private String qTQ;
    private int qTR = -1;
    int qTS = -1;
    private boolean qTT = true;
    private String qTU = null;
    private aqr qTV;

    public o(aqr com_tencent_mm_protocal_c_aqr, String str, String str2, int i, boolean z, int i2, String str3) {
        this.mediaId = str;
        this.qTV = com_tencent_mm_protocal_c_aqr;
        this.qTT = z;
        this.qTR = i;
        this.qTS = i2;
        this.qTU = str3;
        this.qTQ = am.r(ae.getAccSnsPath(), str);
        a aVar = new a();
        aVar.hmj = new bjo();
        aVar.hmk = new bjp();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
        aVar.hmi = f.CTRL_INDEX;
        aVar.hml = 96;
        aVar.hmm = 1000000096;
        this.gJQ = aVar.JZ();
        bjo com_tencent_mm_protocal_c_bjo = (bjo) this.gJQ.hmg.hmo;
        q LB = ae.bvk().LB(str);
        if (LB == null) {
            LB = new q();
        }
        LB.rps = str;
        LB.offset = 0;
        ae.bvk().a(str, LB);
        if (z) {
            this.filename = i.n(com_tencent_mm_protocal_c_aqr);
        } else {
            this.filename = i.m(com_tencent_mm_protocal_c_aqr);
        }
        FileOp.mh(this.qTQ);
        FileOp.deleteFile(am.r(ae.getAccSnsPath(), str) + this.filename);
        com_tencent_mm_protocal_c_bjo.wMS = str2;
        com_tencent_mm_protocal_c_bjo.wMT = 0;
        com_tencent_mm_protocal_c_bjo.vIC = 0;
        com_tencent_mm_protocal_c_bjo.vIB = 0;
        com_tencent_mm_protocal_c_bjo.ktN = this.qTR;
        x.d("MicroMsg.NetSceneSnsDownload", "requestKey " + str3);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsDownload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bjp com_tencent_mm_protocal_c_bjp = (bjp) ((b) qVar).hmh.hmo;
        if (((c) qVar.Hp()).vBp != 0) {
            this.gJT.a(i2, i3, str, this);
            ae.bvq().JX(this.qTU);
            return;
        }
        q LB = ae.bvk().LB(this.mediaId);
        if (com_tencent_mm_protocal_c_bjp.vIB <= 0) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 1");
            onError();
        } else if (com_tencent_mm_protocal_c_bjp.vKf == null) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 2");
            onError();
        } else if (com_tencent_mm_protocal_c_bjp.vIC < 0 || com_tencent_mm_protocal_c_bjp.vIC + com_tencent_mm_protocal_c_bjp.vKf.wJD.oz.length > com_tencent_mm_protocal_c_bjp.vIB) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 3");
            onError();
        } else if (com_tencent_mm_protocal_c_bjp.vIC != LB.offset) {
            x.e("MicroMsg.NetSceneSnsDownload", "error 4");
            onError();
        } else {
            int F = F(com_tencent_mm_protocal_c_bjp.vKf.wJD.toByteArray());
            if (F < 0) {
                x.e("MicroMsg.NetSceneSnsDownload", "error 5");
                onError();
                return;
            }
            LB.offset += F;
            LB.rpo = com_tencent_mm_protocal_c_bjp.vIB;
            x.d("MicroMsg.NetSceneSnsDownload", "byteLen " + F + "  totalLen " + com_tencent_mm_protocal_c_bjp.vIB);
            ae.bvk().a(this.mediaId, LB);
            Object obj = (LB.offset != LB.rpo || LB.rpo == 0) ? null : 1;
            if (obj != null) {
                x.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
                String e = this.qTS == 1 ? i.e(this.qTV) : i.l(this.qTV);
                String r = am.r(ae.getAccSnsPath(), this.mediaId);
                FileOp.deleteFile(r + e);
                FileOp.g(r, this.filename, e);
                if (this.qTT) {
                    r.b(r, e, i.f(this.qTV), (float) ae.bvD());
                } else {
                    String e2 = i.e(this.qTV);
                    if (!FileOp.bO(r + e2)) {
                        r.a(r, e, e2, (float) ae.bvE());
                    }
                    e2 = i.f(this.qTV);
                    if (!FileOp.bO(r + e2)) {
                        r.b(r, e, e2, (float) ae.bvD());
                    }
                }
                ae.bvq().JX(this.qTU);
                this.gJT.a(i2, i3, str, this);
                return;
            }
            a(this.hmA, this.gJT);
        }
    }

    private void onError() {
        ae.bvq().JX(this.qTU);
    }

    public final int getType() {
        return f.CTRL_INDEX;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 100;
    }

    private int F(byte[] bArr) {
        if (!i.JP(ae.FC())) {
            return 0;
        }
        try {
            if (this.hlF == null) {
                FileOp.mh(this.qTQ);
                this.hlF = FileOp.iE(this.qTQ + this.filename);
            }
            x.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + bArr.length);
            this.hlF.write(bArr);
            return bArr.length;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "appendBuf failed: " + this.filename, new Object[0]);
            return -1;
        } finally {
            JJ();
        }
    }

    private void JJ() {
        try {
            if (this.hlF != null) {
                this.hlF.flush();
                this.hlF.close();
                this.hlF = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "", new Object[0]);
        }
    }
}
