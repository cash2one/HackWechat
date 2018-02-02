package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.i;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.protocal.c.atd;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class g extends k implements com.tencent.mm.network.k {
    e gJT;
    f hBj = null;
    boolean hEW = false;
    a hEZ;
    private StringBuilder hFa = new StringBuilder();
    final atc hFk = new atc();
    int hFl = 0;
    boolean hFm = false;
    int hFn = 0;
    int hFo = 0;
    private final ak hkO = new ak(com.tencent.mm.kernel.g.Dm().oAt.getLooper(), new 1(this), true);
    final Queue<a> hyz = new LinkedList();
    private int retryCount = 3;

    public static class b extends i {
        private final v.a hFu = new v.a();
        private final com.tencent.mm.protocal.v.b hFv = new com.tencent.mm.protocal.v.b();

        protected final d Ho() {
            return this.hFu;
        }

        public final com.tencent.mm.protocal.k.e Hp() {
            return this.hFv;
        }

        public final int getType() {
            return com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newinit";
        }
    }

    public g(f fVar) {
        x.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", new Object[]{Integer.valueOf(hashCode()), bh.cgy()});
        this.hFa.append("stack:" + bh.cgy() + " time:" + bh.Wo());
        this.hBj = fVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.hEZ = new a();
        this.gJT = eVar2;
        atc com_tencent_mm_protocal_c_atc = this.hFk;
        com.tencent.mm.kernel.g.Dk();
        com_tencent_mm_protocal_c_atc.ksU = (String) com.tencent.mm.kernel.g.Dj().CU().get(2, null);
        Assert.assertTrue("by DK: req.UserName is null", !bh.ov(this.hFk.ksU));
        this.hFk.lOo = w.cfi();
        return a(eVar, null, null);
    }

    private int a(com.tencent.mm.network.e eVar, bdn com_tencent_mm_protocal_c_bdn, bdn com_tencent_mm_protocal_c_bdn2) {
        this.hFa.append(" lastd:" + this.hmB + " dotime:" + bh.Wo() + " net:" + an.getNetType(ac.getContext()));
        q bVar = new b();
        if (com_tencent_mm_protocal_c_bdn == null) {
            com.tencent.mm.kernel.g.Dk();
            com_tencent_mm_protocal_c_bdn = n.N(bh.VD(bh.ou((String) com.tencent.mm.kernel.g.Dj().CU().get(8197, null))));
        }
        if (com_tencent_mm_protocal_c_bdn2 == null) {
            com.tencent.mm.kernel.g.Dk();
            com_tencent_mm_protocal_c_bdn2 = n.N(bh.VD(bh.ou((String) com.tencent.mm.kernel.g.Dj().CU().get(8198, null))));
        }
        com.tencent.mm.kernel.g.Dk();
        if (bh.e((Integer) com.tencent.mm.kernel.g.Dj().CU().get(16, null)) == 0 || (com_tencent_mm_protocal_c_bdn != null && com_tencent_mm_protocal_c_bdn.wJB > 0)) {
            com.tencent.mm.kernel.g.Dk();
            if (bh.ou((String) com.tencent.mm.kernel.g.Dj().CU().get(8195, null)).length() <= 0) {
                bVar.Kb().vBj = 3;
            } else {
                bVar.Kb().vBj = 4;
            }
        } else {
            bVar.Kb().vBj = 7;
        }
        this.hFk.wAP = com_tencent_mm_protocal_c_bdn;
        this.hFk.wAQ = com_tencent_mm_protocal_c_bdn2;
        ((v.a) bVar.Kb()).vBO = this.hFk;
        x.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.hEZ.zi()), Integer.valueOf(this.hFl), this.hFk.ksU, this.hFk.lOo, Integer.valueOf(bVar.Kb().vBj), bh.by(n.a(com_tencent_mm_protocal_c_bdn)), bh.by(n.a(com_tencent_mm_protocal_c_bdn2))});
        this.hFl++;
        return a(eVar, bVar, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.hFa.append(" endtime:" + bh.Wo());
        x.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i)});
        if (i2 == 4 && i3 == -100) {
            x.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str});
            this.hEW = true;
            this.gJT.a(i2, i3, str, this);
        } else if ((i2 == 0 && i3 == 0) || (i2 == 4 && i3 == -17)) {
            atd com_tencent_mm_protocal_c_atd = ((com.tencent.mm.protocal.v.b) qVar.Hp()).vBP;
            this.hFn += com_tencent_mm_protocal_c_atd.wAS;
            x.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.hEZ.zi()), Integer.valueOf(this.hFn), Integer.valueOf(this.hFl), Integer.valueOf(com_tencent_mm_protocal_c_atd.vPq)});
            a(this.hFl - 1, i2, i3, str, com_tencent_mm_protocal_c_atd);
            if ((com_tencent_mm_protocal_c_atd.vPq & 7) == 0 || super.Ke()) {
                x.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.hEZ.zi()), Integer.valueOf(this.hFl)});
                this.hFm = true;
                a(Integer.MAX_VALUE, 0, 0, "", null);
            } else if (a(this.hmA, com_tencent_mm_protocal_c_atd.wAP, com_tencent_mm_protocal_c_atd.wAQ) == -1) {
                x.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
                a(Integer.MAX_VALUE, 3, -1, "", null);
            }
        } else {
            x.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", new Object[]{Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str});
            if (this.retryCount > 0) {
                this.retryCount--;
                if (a(this.hmA, null, null) != -1) {
                    return;
                }
            }
            this.hEW = true;
            this.gJT.a(3, -1, "", this);
        }
    }

    public final boolean Kd() {
        return true;
    }

    protected final void cancel() {
        x.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[]{bh.cgy()});
        super.cancel();
        this.hEW = true;
    }

    private void a(int i, int i2, int i3, String str, atd com_tencent_mm_protocal_c_atd) {
        a aVar = new a(this);
        aVar.hFt = i;
        aVar.errCode = i3;
        aVar.errType = i2;
        aVar.fnL = str;
        aVar.hFs = com_tencent_mm_protocal_c_atd;
        this.hyz.add(aVar);
        if (this.hkO.cfK()) {
            this.hkO.J(50, 50);
        }
    }

    public final String getInfo() {
        return this.hFa.toString();
    }

    protected final int Bh() {
        return 500;
    }

    protected final int a(q qVar) {
        return com.tencent.mm.ae.k.b.hmP;
    }

    public final boolean Ke() {
        return super.Ke();
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX;
    }
}
