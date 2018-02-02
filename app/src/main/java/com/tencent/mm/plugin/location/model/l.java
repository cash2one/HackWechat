package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ae.k;
import com.tencent.mm.by.h;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.protocal.c.beb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.e;
import java.util.HashMap;
import java.util.HashSet;

public final class l implements ap {
    private com.tencent.mm.sdk.b.c nRA = new 2(this);
    private com.tencent.mm.sdk.b.c nRB = new 3(this);
    private com.tencent.mm.sdk.b.c nRC = new 4(this);
    private com.tencent.mm.sdk.b.c nRD = new 5(this);
    private a nRE = new 6(this);
    private c nRl = new c();
    private a nRm = new a((byte) 0);
    private b nRn = new b((byte) 0);
    private a$a nRo;
    private int nRp = 0;
    private e nRq = new b();
    private e nRr = new n();
    private o nRs = null;
    private p nRt = null;
    private i nRu = null;
    private m nRv = null;
    private d nRw = new d();
    private k nRx = null;
    private j nRy = null;
    private com.tencent.mm.ae.e nRz = new com.tencent.mm.ae.e(this) {
        final /* synthetic */ l nRF;

        {
            this.nRF = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0) {
                ab abVar = (ab) kVar;
                beb Sn = abVar.Sn();
                if (Sn.ktN == 0) {
                    long j = abVar.fqm;
                    String my = ab.my(Sn.vNZ);
                    ar.Hg();
                    au dH = com.tencent.mm.z.c.Fa().dH(j);
                    if (dH.aNe()) {
                        dH.dU(my);
                        ar.Hg();
                        com.tencent.mm.z.c.Fa().a(j, dH);
                    }
                }
            }
        }
    };

    private static final class c extends com.tencent.mm.sdk.b.c<ix> {
        private volatile boolean Ki;

        private c() {
            this.Ki = false;
            this.xen = ix.class.getName().hashCode();
        }

        /* synthetic */ c(byte b) {
            this();
            this.xen = ix.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ix ixVar = (ix) bVar;
            if (!(ixVar instanceof ix)) {
                return false;
            }
            x.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + ixVar.fzx.fzr);
            switch (ixVar.fzx.fzr) {
                case 0:
                    l.aVr().nQD = new HashSet();
                    this.Ki = true;
                    return true;
                case 1:
                    if (this.Ki) {
                        String[] N = l.aVr().N(ixVar.fzx.fnB);
                        ixVar.fzy.fwv = N[0];
                        ixVar.fzy.fzA = N[1];
                        return true;
                    }
                    ixVar.fzy.fwv = "err_not_started";
                    return true;
                case 2:
                    if (!this.Ki) {
                        return true;
                    }
                    l.aVr().aVm();
                    return true;
                default:
                    return true;
            }
        }
    }

    private static l aVq() {
        ar.Ha();
        l lVar = (l) bp.hY("plugin.location");
        if (lVar != null) {
            return lVar;
        }
        Object lVar2 = new l();
        ar.Ha().a("plugin.location", lVar2);
        return lVar2;
    }

    public static a$a aVr() {
        g.Dh().Ct();
        if (aVq().nRo == null) {
            aVq().nRo = new a$a();
        }
        return aVq().nRo;
    }

    public static k aVs() {
        g.Dh().Ct();
        if (aVq().nRx == null) {
            aVq().nRx = new k();
        }
        return aVq().nRx;
    }

    public static j aVt() {
        g.Dh().Ct();
        if (aVq().nRy == null) {
            aVq().nRy = new j();
        }
        return aVq().nRy;
    }

    public static o aVu() {
        if (aVq().nRs == null) {
            aVq().nRs = new o();
        }
        return aVq().nRs;
    }

    public static p aVv() {
        if (aVq().nRt == null) {
            aVq().nRt = new p();
        }
        return aVq().nRt;
    }

    public static i aVw() {
        if (aVq().nRu == null) {
            aVq().nRu = new i();
        }
        return aVq().nRu;
    }

    public static m aVx() {
        if (aVq().nRv == null) {
            aVq().nRv = new m();
        }
        return aVq().nRv;
    }

    public static void O(au auVar) {
        if (auVar != null && auVar.field_msgId != 0) {
            au.b Xs = au.b.Xs(auVar.field_content);
            ar.CG().a(new ab((float) Xs.nQy, (float) Xs.nQx, auVar.field_msgId), 0);
        }
    }

    public static String aVy() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(com.tencent.mm.z.c.FB()).append("trackroom/").toString();
    }

    public final HashMap<Integer, h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        com.tencent.mm.ae.d.c.a(Integer.valueOf(48), this.nRq);
        com.tencent.mm.ae.d.c.a(Integer.valueOf(61), this.nRr);
        ar.getSysCmdMsgExtension().a("trackmsg", this.nRE, true);
        ar.CG().a(424, this.nRz);
        com.tencent.mm.sdk.b.a.xef.b(this.nRl);
        com.tencent.mm.sdk.b.a.xef.b(this.nRm);
        com.tencent.mm.sdk.b.a.xef.b(this.nRA);
        com.tencent.mm.sdk.b.a.xef.b(this.nRB);
        com.tencent.mm.sdk.b.a.xef.b(this.nRC);
        com.tencent.mm.sdk.b.a.xef.b(this.nRD);
        com.tencent.mm.sdk.b.a.xef.b(this.nRn);
        q$a.vcv = aVu();
        q$a.vcw = aVv();
        com.tencent.mm.br.a.a.a.xaZ = aVx();
        g.Dh().Ct();
        if (aVq().nRw == null) {
            aVq().nRw = new d();
        }
        com.tencent.mm.plugin.p.c.a.nYF = aVq().nRw;
    }

    public final void onAccountRelease() {
        if (this.nRs != null) {
            this.nRs.nRT = null;
            this.nRs.stop();
            this.nRs.rM(1);
        }
        com.tencent.mm.ae.d.c.b(Integer.valueOf(48), this.nRq);
        com.tencent.mm.ae.d.c.b(Integer.valueOf(61), this.nRr);
        ar.getSysCmdMsgExtension().b("trackmsg", this.nRE, true);
        ar.CG().b(424, this.nRz);
        com.tencent.mm.sdk.b.a.xef.c(this.nRl);
        com.tencent.mm.sdk.b.a.xef.c(this.nRm);
        com.tencent.mm.sdk.b.a.xef.c(this.nRA);
        com.tencent.mm.sdk.b.a.xef.c(this.nRB);
        com.tencent.mm.sdk.b.a.xef.c(this.nRC);
        com.tencent.mm.sdk.b.a.xef.c(this.nRD);
        com.tencent.mm.sdk.b.a.xef.c(this.nRn);
        if (this.nRu != null) {
            i iVar = this.nRu;
            iVar.aVp();
            iVar.jSI.clear();
        }
        if (this.nRx != null) {
            this.nRx.stop();
        }
        if (this.nRy != null) {
            aVs().a(this.nRy);
        }
    }

    public final void br(boolean z) {
    }
}
