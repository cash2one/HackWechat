package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bsp;
import com.tencent.mm.protocal.c.bsq;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private String filename;
    private final b gJQ;
    private e gJT;
    public boolean sgG = false;
    private boolean sgH = false;
    private Handler sgI = null;
    private int sgJ = 0;
    int sgM = 0;
    private String sgP = "";
    private int wn = 0;

    public j(String str, int i) {
        x.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[]{Integer.valueOf(i)});
        a aVar = new a();
        aVar.hmj = new bsp();
        aVar.hmk = new bsq();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
        aVar.hmi = 613;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bsp com_tencent_mm_protocal_c_bsp = (bsp) this.gJQ.hmg.hmo;
        this.filename = str;
        this.wn = 0;
        com_tencent_mm_protocal_c_bsp.wIj = i;
        this.sgJ = 0;
        com_tencent_mm_protocal_c_bsp.wIh = 0;
        x.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(0)});
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
        bsp com_tencent_mm_protocal_c_bsp = (bsp) this.gJQ.hmg.hmo;
        bsy com_tencent_mm_protocal_c_bsy = new bsy();
        g gVar = new g();
        com_tencent_mm_protocal_c_bsp.wTS = com_tencent_mm_protocal_c_bsy;
        l lVar = new l(m.aJ(this.filename, false));
        int bN = com.tencent.mm.a.e.bN(m.aJ(this.filename, false));
        if (bN - this.wn >= 6000) {
            gVar = lVar.bp(this.wn, 6000);
        } else {
            gVar = lVar.bp(this.wn, bN - this.wn);
        }
        x.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.wn), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.flp), Integer.valueOf(bN), Boolean.valueOf(this.sgG)});
        if (gVar.flp == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            x.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.wn >= 469000) {
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.wn)});
            return -1;
        } else {
            com_tencent_mm_protocal_c_bsy.wUc = new bdn().bj(gVar.buf);
            com_tencent_mm_protocal_c_bsy.vIC = this.wn;
            com_tencent_mm_protocal_c_bsy.wUa = gVar.flp;
            com_tencent_mm_protocal_c_bsy.wUb = 0;
            com_tencent_mm_protocal_c_bsp.wIh = this.sgJ;
            if (this.sgG && gVar.hWh >= com.tencent.mm.a.e.bN(m.aJ(this.filename, false))) {
                com_tencent_mm_protocal_c_bsy.wUb = 1;
                this.sgH = true;
                x.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(bN)});
            }
            this.wn = gVar.hWh;
            com_tencent_mm_protocal_c_bsp.wTS = com_tencent_mm_protocal_c_bsy;
            return 0;
        }
    }

    public final int getType() {
        return 613;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        bsq com_tencent_mm_protocal_c_bsq = (bsq) ((b) qVar).hmh.hmo;
        if (i2 == 0 || i3 == 0) {
            this.sgJ = com_tencent_mm_protocal_c_bsq.wIh;
            this.sgM = com_tencent_mm_protocal_c_bsq.vVT;
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bsq.wIh), Integer.valueOf(this.sgM)});
            if (this.sgH) {
                this.gJT.a(i2, i3, str, this);
                return;
            }
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(bFE())});
            a(this.hmA, this.gJT);
            x.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
