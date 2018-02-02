package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.k.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ax;
import com.tencent.mm.z.ax.a;

public final class h extends k implements com.tencent.mm.network.k {
    private String filename;
    e gJT;
    private final q hnp;
    public boolean sgG = false;
    private boolean sgH = false;
    private Handler sgI = null;
    private int sgJ = 0;
    int sgM = 0;
    String sgP = "";
    private int wn = 0;

    public h(String str, int i, String str2) {
        x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[]{Integer.valueOf(i), bh.az(str2, "")});
        this.hnp = new c();
        a aVar = (a) this.hnp.Kb();
        this.filename = str;
        this.wn = 0;
        aVar.hgq.wIj = i;
        aVar.hgq.wpa = str2;
        this.sgJ = 0;
        aVar.hgq.wIh = 0;
        x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(0)});
        this.sgG = true;
        bFE();
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final int Bh() {
        return 240;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    private int bFE() {
        a aVar = (a) this.hnp.Kb();
        bsy com_tencent_mm_protocal_c_bsy = new bsy();
        g gVar = new g();
        aVar.hgq.wTS = com_tencent_mm_protocal_c_bsy;
        l lVar = new l(m.aJ(this.filename, false));
        int bN = com.tencent.mm.a.e.bN(m.aJ(this.filename, false));
        if (bN - this.wn >= 6000) {
            gVar = lVar.bp(this.wn, 6000);
        } else {
            gVar = lVar.bp(this.wn, bN - this.wn);
        }
        x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.wn), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.flp), Integer.valueOf(bN), Boolean.valueOf(this.sgG)});
        if (gVar.flp == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            x.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.wn >= 469000) {
            x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.wn)});
            return -1;
        } else {
            com_tencent_mm_protocal_c_bsy.wUc = new bdn().bj(gVar.buf);
            com_tencent_mm_protocal_c_bsy.vIC = this.wn;
            com_tencent_mm_protocal_c_bsy.wUa = gVar.flp;
            com_tencent_mm_protocal_c_bsy.wUb = 0;
            aVar.hgq.wIh = this.sgJ;
            if (this.sgG && gVar.hWh >= com.tencent.mm.a.e.bN(m.aJ(this.filename, false))) {
                com_tencent_mm_protocal_c_bsy.wUb = 1;
                this.sgH = true;
                x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(bN)});
            }
            this.wn = gVar.hWh;
            aVar.hgq.wTS = com_tencent_mm_protocal_c_bsy;
            return 0;
        }
    }

    public final int getType() {
        return 617;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        ax.b bVar = (ax.b) qVar.Hp();
        if (i2 == 4 && i3 == -102) {
            x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.Kb().vBn.ver)});
            ar.Dm().F(new 1(this, r0));
        } else if (i2 == 0 || i3 == 0) {
            this.sgJ = bVar.hgr.wIh;
            this.sgM = bVar.hgr.vVT;
            this.sgP = bVar.hgr.wTT;
            String str2 = "MicroMsg.NetSceneRsaVertifyVoicePrint";
            String str3 = "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bVar.hgr.wIh);
            objArr[1] = Integer.valueOf(this.sgM);
            objArr[2] = Boolean.valueOf(bh.ov(this.sgP));
            objArr[3] = Integer.valueOf(bh.ov(this.sgP) ? 0 : this.sgP.length());
            x.i(str2, str3, objArr);
            if (this.sgH) {
                this.gJT.a(i2, i3, str, this);
                return;
            }
            x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(bFE())});
            a(this.hmA, this.gJT);
            x.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
