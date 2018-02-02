package com.tencent.mm.modelsimple;

import com.tencent.mm.a.o;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bse;
import com.tencent.mm.protocal.c.bsf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public final class al extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;
    public long hnZ;

    public al(String str, String str2, String str3, String str4) {
        this(1, str, str2, str3, str4, false, 0);
    }

    public al(int i, String str, String str2, String str3, String str4, boolean z, int i2) {
        this(i, str, str2, str3, str4, z, i2, true);
    }

    public al(int i, String str, String str2, String str3, String str4, boolean z, int i2, boolean z2) {
        this.hnZ = 0;
        a aVar = new a();
        aVar.hmj = new bse();
        aVar.hmk = new bsf();
        aVar.uri = "/cgi-bin/micromsg-bin/newverifypasswd";
        aVar.hmi = 384;
        aVar.hml = au.CTRL_BYTE;
        aVar.hmm = 1000000182;
        this.gJQ = aVar.JZ();
        bse com_tencent_mm_protocal_c_bse = (bse) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bse.vDW = i;
        com_tencent_mm_protocal_c_bse.wLk = i2;
        com_tencent_mm_protocal_c_bse.wTy = bh.VC(str);
        com_tencent_mm_protocal_c_bse.vMB = bh.VB(str);
        com_tencent_mm_protocal_c_bse.woX = new bdo().UA(str2);
        com_tencent_mm_protocal_c_bse.wTz = new bdo().UA(str3);
        com_tencent_mm_protocal_c_bse.vMF = new bdo().UA(str4);
        if (i == 5 || i == 2) {
            byte[] c;
            this.hnZ = new o(q.FR()).longValue();
            if (z) {
                c = g.Dh().Cq().c(this.hnZ, str3);
            } else {
                c = g.Dh().Cq().a(this.hnZ, bh.VC(str), z2);
            }
            com_tencent_mm_protocal_c_bse.vKR = new bdn().bj(c);
        }
        com_tencent_mm_protocal_c_bse.vMG = new bdn().bj(bh.VD(bh.ou((String) g.Dj().CU().get(47, null))));
        String str5 = "MicroMsg.NetSceneVerifyPswd";
        String str6 = "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_bse.vDW);
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Integer.valueOf(com_tencent_mm_protocal_c_bse.vKR == null ? -1 : com_tencent_mm_protocal_c_bse.vKR.wJB);
        objArr[4] = com_tencent_mm_protocal_c_bse.vKR == null ? "null" : bh.VT(bh.bv(com_tencent_mm_protocal_c_bse.vKR.wJD.oz));
        x.i(str5, str6, objArr);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 384;
    }

    public final String NW() {
        try {
            return ((bsf) this.gJQ.hmh.hmo).vZK;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", e, "", new Object[0]);
            return null;
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        bse com_tencent_mm_protocal_c_bse = (bse) this.gJQ.hmg.hmo;
        bsf com_tencent_mm_protocal_c_bsf = (bsf) this.gJQ.hmh.hmo;
        if (com_tencent_mm_protocal_c_bsf.vJc != null && com_tencent_mm_protocal_c_bsf.vJc.wJB > 0) {
            boolean a = g.Dh().Cq().a(this.hnZ, n.a(com_tencent_mm_protocal_c_bsf.vJc));
            x.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[]{Boolean.valueOf(a), Integer.valueOf(com_tencent_mm_protocal_c_bsf.vJc.wJB)});
        }
        if (i2 == 0 && i3 == 0) {
            g.Dj().CU().set(77830, com_tencent_mm_protocal_c_bsf.vZK);
            g.Dj().CU().set(32, com_tencent_mm_protocal_c_bse.wTy);
            g.Dj().CU().set(33, com_tencent_mm_protocal_c_bse.vMB);
            g.Dj().CU().set(46, bh.by(n.a(com_tencent_mm_protocal_c_bsf.vJi)));
            String by = bh.by(n.a(com_tencent_mm_protocal_c_bse.vMG));
            g.Dj().CU().set(47, by);
            g.Dj().gQd.set(18, by);
            g.Dj().CU().set(-1535680990, com_tencent_mm_protocal_c_bsf.vJh);
            int i4 = com_tencent_mm_protocal_c_bsf.vJi == null ? 0 : com_tencent_mm_protocal_c_bsf.vJi.wJB;
            int length = com_tencent_mm_protocal_c_bsf.vJh == null ? 0 : com_tencent_mm_protocal_c_bsf.vJh.length();
            int length2 = com_tencent_mm_protocal_c_bsf.vZK == null ? 0 : com_tencent_mm_protocal_c_bsf.vZK.length();
            x.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(length), Integer.valueOf(length2)});
        } else if (i2 == 4) {
            g.Dj().CU().set(32, "");
            g.Dj().CU().set(33, "");
        }
        this.gJT.a(i2, i3, str, this);
    }
}
