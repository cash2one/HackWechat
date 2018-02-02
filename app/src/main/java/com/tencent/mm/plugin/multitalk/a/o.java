package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitalk.b.c;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.b;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.bv.a;
import java.util.HashMap;

public final class o implements ap {
    private static HashMap<Integer, d> gwY;
    private a mJD = new a(this) {
        final /* synthetic */ o oHD;

        {
            this.oHD = r1;
        }

        public final boolean If() {
            x.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
            if (this.oHD.oHv != null) {
                this.oHD.oHv.aSZ();
                if (this.oHD.oHv.oGi != null) {
                    x.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", i.h(this.oHD.oHv.oGi));
                }
            }
            return true;
        }
    };
    private com.tencent.mm.plugin.multitalk.b.a oHA;
    private c oHB;
    private f oHC;
    private c oHu;
    private e oHv;
    private l oHw;
    private h oHx;
    private a oHy;
    private g oHz;

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new 1());
        gwY.put(Integer.valueOf("MULTITALKMEMBER_TABLE".hashCode()), new 2());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    private static o bcQ() {
        ar.Ha();
        o oVar = (o) bp.hY("plugin.multitalk");
        if (oVar != null) {
            return oVar;
        }
        Object oVar2 = new o();
        ar.Ha().a("plugin.multitalk", oVar2);
        return oVar2;
    }

    public static com.tencent.mm.plugin.multitalk.b.a bcR() {
        ar.Hg();
        if (com.tencent.mm.z.c.Cg() == 0) {
            throw new b();
        }
        if (bcQ().oHA == null) {
            o bcQ = bcQ();
            ar.Hg();
            bcQ.oHA = new com.tencent.mm.plugin.multitalk.b.a(com.tencent.mm.z.c.EV());
        }
        return bcQ().oHA;
    }

    public static c bcS() {
        ar.Hg();
        if (com.tencent.mm.z.c.Cg() == 0) {
            throw new b();
        }
        if (bcQ().oHB == null) {
            o bcQ = bcQ();
            ar.Hg();
            bcQ.oHB = new c(com.tencent.mm.z.c.EV());
        }
        return bcQ().oHB;
    }

    public static h bcT() {
        g.Dh().Ct();
        if (bcQ().oHx == null) {
            bcQ().oHx = new h();
        }
        return bcQ().oHx;
    }

    public static c bcU() {
        g.Dh().Ct();
        if (bcQ().oHu == null) {
            bcQ().oHu = new c();
        }
        return bcQ().oHu;
    }

    public static e bcV() {
        g.Dh().Ct();
        if (bcQ().oHv == null) {
            bcQ().oHv = new e();
        }
        return bcQ().oHv;
    }

    public static l bcW() {
        g.Dh().Ct();
        if (bcQ().oHw == null) {
            bcQ().oHw = new l();
        }
        return bcQ().oHw;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        this.oHu = new c();
        this.oHy = new a(this);
        ar.getSysCmdMsgExtension().a("multivoip", this.oHy, true);
        ar.Dl().a(this.mJD);
        q.a.vcx = bcX();
        bcX().bcJ();
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        if (this.oHu != null) {
            e eVar = this.oHu;
            ar.CG().b(1918, eVar);
            ar.CG().b(1919, eVar);
            ar.CG().b(1927, eVar);
            ar.CG().b(1928, eVar);
            ar.CG().b(1929, eVar);
            ar.CG().b(1931, eVar);
            ar.CG().b(1932, eVar);
            ar.CG().b(1933, eVar);
            ar.CG().b(1935, eVar);
            ar.CG().b(1937, eVar);
            ar.CG().b(1938, eVar);
            ar.CG().b(1939, eVar);
            this.oHu = null;
        }
        if (this.oHv != null) {
            e eVar2 = this.oHv;
            ac.getContext().unregisterReceiver(eVar2.oGx);
            com.tencent.mm.sdk.b.a.xef.c(eVar2.oGy);
            eVar2.c(false, false, false);
            this.oHv = null;
        }
        if (this.oHw != null) {
            this.oHw.bcP();
            this.oHw = null;
        }
        if (this.oHx != null) {
            this.oHx.reset();
            this.oHx = null;
        }
        ar.getSysCmdMsgExtension().b("multivoip", this.oHy, true);
        ar.Dl().b(this.mJD);
    }

    public static g bcX() {
        if (bcQ().oHz == null) {
            bcQ().oHz = new g();
        }
        return bcQ().oHz;
    }

    public static f bcY() {
        if (bcQ().oHC == null) {
            bcQ().oHC = new f();
        }
        return bcQ().oHC;
    }
}
