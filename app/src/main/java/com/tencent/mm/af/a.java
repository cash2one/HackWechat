package com.tencent.mm.af;

import com.tencent.mm.a.o;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.gz;
import com.tencent.mm.protocal.c.ha;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class a extends k implements com.tencent.mm.network.k {
    private String fxT;
    private String fxV;
    public final b gJQ;
    private e gJT;
    public long hnZ;

    public a(long j, String str, String str2, String str3, String str4, int i, boolean z) {
        byte[] c;
        this.hnZ = 0;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new gz();
        aVar.hmk = new ha();
        aVar.uri = "/cgi-bin/micromsg-bin/bindqq";
        aVar.hmi = com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.hnZ = j;
        gz gzVar = (gz) this.gJQ.hmg.hmo;
        gzVar.vMA = new o(j).intValue();
        gzVar.vMp = "";
        gzVar.vMB = "";
        gzVar.vMC = "";
        gzVar.vMD = "";
        gzVar.vMF = new bdo().UA("");
        gzVar.vME = 1;
        if (z) {
            c = ar.Cq().c(j, str3);
        } else {
            c = ar.Cq().a(j, bh.VC(str), true);
        }
        gzVar.vKR = new bdn().bj(c);
        ar.Hg();
        gzVar.vMG = new bdn().bj(bh.VD(bh.ou((String) c.CU().get(47, null))));
        x.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(bh.bx(c)), str3, str2, str4, r1});
    }

    public a(long j, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this(j, str, str2, str3, str4, 1, z);
        this.fxT = str5;
        this.fxV = str6;
        gz gzVar = (gz) this.gJQ.hmg.hmo;
        gzVar.vMg = str5;
        gzVar.vMh = str6;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        gz gzVar = (gz) this.gJQ.hmg.hmo;
        ha haVar = (ha) this.gJQ.hmh.hmo;
        byte[] a = n.a(haVar.vJc);
        boolean z = false;
        if (!bh.bw(a)) {
            z = ar.Cq().a(new o(gzVar.vMA).longValue(), a);
        }
        x.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(bh.bx(a)), haVar.vMC});
        if (i2 == 0 && i3 == 0) {
            ar.Hg();
            c.CU().set(9, Integer.valueOf(gzVar.vMA));
            if (gzVar.vME == 1) {
                ar.Hg();
                c.CU().set(17, Integer.valueOf(haVar.vFA));
            }
            ar.Hg();
            c.Fg().ar(haVar.vMJ, haVar.vMI == 1);
            int i4 = gzVar.vMA;
            if (i4 != 0) {
                ar.Hg();
                c.Fg().bH(new o(i4) + "@qqim", 3);
            }
            com.tencent.mm.ad.b.c((long) i4, 3);
            ar.Hg();
            c.CU().set(32, gzVar.vMp);
            ar.Hg();
            c.CU().set(33, gzVar.vMB);
            x.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", new Object[]{Boolean.valueOf(z), bh.VT(bh.by(ar.Cq().aQ(new o(gzVar.vMA).longValue())))});
            ar.Hg();
            c.CU().set(72, r3);
            ar.Hg();
            c.CU().set(46, bh.by(n.a(haVar.vJi)));
            String by = bh.by(n.a(gzVar.vMG));
            ar.Hg();
            c.CU().set(47, by);
            ar.He().set(18, by);
            ar.Hg();
            c.CU().set(-1535680990, haVar.vMK);
            if (!(bh.ov(this.fxT) || bh.ov(this.fxV))) {
                ar.Hg();
                c.CU().set(64, Integer.valueOf(haVar.vFx));
                com.tencent.mm.sdk.b.b rzVar = new rz();
                rzVar.fJI.fJJ = haVar;
                com.tencent.mm.sdk.b.a.xef.m(rzVar);
                com.tencent.mm.sdk.b.b saVar = new sa();
                saVar.fJK.fJL = true;
                saVar.fJK.fJM = true;
                com.tencent.mm.sdk.b.a.xef.m(saVar);
            }
        } else if (i2 == 4) {
            ar.Hg();
            c.CU().set(32, "");
            ar.Hg();
            c.CU().set(33, "");
        }
        if (gzVar.vME == 3 && i3 == -3) {
            i3 = 10000;
            x.d("MicroMsg.NetSceneBindQQ", new StringBuilder("onGYNetEnd : retCode = 10000").toString());
        }
        this.gJT.a(i2, i3, str, this);
    }
}
