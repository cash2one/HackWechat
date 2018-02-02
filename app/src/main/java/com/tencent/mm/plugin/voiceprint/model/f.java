package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbx;
import com.tencent.mm.protocal.c.bby;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private String filename;
    private final b gJQ;
    private e gJT;
    public boolean sgG = false;
    private boolean sgH = false;
    private Handler sgI = null;
    int sgJ = 0;
    private int sgK = 0;
    int sgL = 0;
    int sgM = 0;
    private int wn = 0;

    public f(String str, int i, int i2, int i3) {
        x.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.sgL = i;
        a aVar = new a();
        aVar.hmj = new bbx();
        aVar.hmk = new bby();
        aVar.uri = "/cgi-bin/micromsg-bin/registervoiceprint";
        aVar.hmi = 612;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bbx com_tencent_mm_protocal_c_bbx = (bbx) this.gJQ.hmg.hmo;
        this.filename = str;
        this.wn = 0;
        com_tencent_mm_protocal_c_bbx.wIj = i2;
        com_tencent_mm_protocal_c_bbx.ktL = i;
        this.sgJ = i3;
        com_tencent_mm_protocal_c_bbx.wIh = i3;
        x.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.sgG = true;
        bFE();
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 240;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    private int bFE() {
        bbx com_tencent_mm_protocal_c_bbx = (bbx) this.gJQ.hmg.hmo;
        bsy com_tencent_mm_protocal_c_bsy = new bsy();
        g gVar = new g();
        com_tencent_mm_protocal_c_bbx.wIi = com_tencent_mm_protocal_c_bsy;
        l lVar = new l(m.aJ(this.filename, false));
        int bN = com.tencent.mm.a.e.bN(m.aJ(this.filename, false));
        if (bN - this.wn >= 6000) {
            gVar = lVar.bp(this.wn, 6000);
        } else {
            gVar = lVar.bp(this.wn, bN - this.wn);
        }
        x.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.wn), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.flp), Integer.valueOf(bN), Boolean.valueOf(this.sgG)});
        if (gVar.flp == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            x.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.wn >= 469000) {
            x.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.wn)});
            return -1;
        } else {
            com_tencent_mm_protocal_c_bsy.wUc = new bdn().bj(gVar.buf);
            com_tencent_mm_protocal_c_bsy.vIC = this.wn;
            com_tencent_mm_protocal_c_bsy.wUa = gVar.flp;
            com_tencent_mm_protocal_c_bsy.wUb = 0;
            com_tencent_mm_protocal_c_bbx.wIh = this.sgJ;
            if (this.sgG && gVar.hWh >= com.tencent.mm.a.e.bN(m.aJ(this.filename, false))) {
                com_tencent_mm_protocal_c_bsy.wUb = 1;
                this.sgH = true;
                x.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(bN)});
            }
            this.wn = gVar.hWh;
            com_tencent_mm_protocal_c_bbx.wIi = com_tencent_mm_protocal_c_bsy;
            return 0;
        }
    }

    public final int getType() {
        return 612;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        bby com_tencent_mm_protocal_c_bby = (bby) ((b) qVar).hmh.hmo;
        if (i2 == 0 || i3 == 0) {
            x.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bby.wIh), Integer.valueOf(com_tencent_mm_protocal_c_bby.wIk), Integer.valueOf(com_tencent_mm_protocal_c_bby.wIl), Integer.valueOf(com_tencent_mm_protocal_c_bby.wIk)});
            this.sgJ = com_tencent_mm_protocal_c_bby.wIh;
            this.sgK = com_tencent_mm_protocal_c_bby.wIl;
            this.sgM = com_tencent_mm_protocal_c_bby.wIk;
            if (this.sgH) {
                this.gJT.a(i2, i3, str, this);
                return;
            }
            x.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(bFE())});
            a(this.hmA, this.gJT);
            x.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
