package com.tencent.mm.kernel.a;

import com.tencent.mm.compatible.d.n;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.kernel.a.b.e;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ag;
import java.util.HashSet;
import java.util.Iterator;

public abstract class d implements b {
    public e<Object> gRO = e.DF();
    private final HashSet<String> gRP = new HashSet();

    public void tN() {
        x.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", Integer.valueOf((int) Math.min(Math.floor((((h) g.Dg().CN()).DS() ? 1.5d : 1.0d) * ((double) n.yy())), 6.0d)));
        this.gRO.init(r0);
        c Dt = c.Dt();
        Dt.gRm.a(b.class);
        Dt.gRl.a(com.tencent.mm.kernel.a.c.b.class);
        Dt.gRn.a(com.tencent.mm.kernel.api.h.class, a.class, com.tencent.mm.kernel.api.e.class, ag.class, c.class);
        com.tencent.mm.kernel.a.b.g gVar = Dt.gRn;
        Object obj = new Class[]{c.class};
        gVar.gSA = new Class[1];
        System.arraycopy(obj, 0, gVar.gSA, 0, 1);
        ((h) g.Dg().CN()).gQb.gRg = new com.tencent.mm.kernel.a.a.b(Dt) {
            final /* synthetic */ c gRC;

            {
                this.gRC = r1;
            }

            public final void a(Class cls, Object obj, Object obj2) {
                if (cls == com.tencent.mm.kernel.a.c.b.class) {
                    c.Dt().gRl.a(cls, obj, obj2);
                } else if (cls == com.tencent.mm.kernel.b.b.class) {
                    c.Dt().gRm.a(cls, obj, obj2);
                }
            }
        };
        com.tencent.mm.blink.a.ec("helloWeChat");
    }

    public static void o(Class<? extends f> cls) {
        g.Df().f(cls);
    }

    public static void fP(String str) {
        g.Df().fJ(str);
    }

    public final void fQ(String str) {
        this.gRP.add(str);
    }

    public final void Dr() {
        g.Df().CL();
        this.gRO.prepare();
        for (e.c cVar : this.gRO.DH()) {
            c.Dt().b(cVar.ffg.getLooper());
        }
        com.tencent.mm.blink.a.ec("makeDependency");
    }

    public void a(com.tencent.mm.kernel.b.g gVar) {
        this.gRO.a(new e.b(), c.gRv, c.Dt().gRm, "configure-functional plugins");
        com.tencent.mm.blink.a.ec("configurePlugins");
    }

    public final void Ds() {
        this.gRO.a(new e.b(), c.gRw, c.Dt().gRl, "task-functional plugins");
        com.tencent.mm.blink.a.ec("executeTasks");
    }

    public void b(com.tencent.mm.kernel.b.g gVar) {
        a.a("startup final step, account initialize... for parallels", new Object[0]);
        if (gVar.DS()) {
            c Dt = c.Dt();
            for (f aC : g.Df().CM()) {
                Dt.aC(aC);
            }
            if (g.Dh().Cy()) {
                g.Dh().Co();
            }
        }
        com.tencent.mm.blink.a.ec("installPendingPlugins");
        long nanoTime = System.nanoTime();
        if (this.gRP.size() > 0) {
            Iterator it = this.gRP.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                g.Dk();
                g.Df().p(str, true);
            }
            this.gRP.clear();
            com.tencent.mm.blink.a.h("installPendingPlugins installed", nanoTime);
            g.Dk();
            g.Df().CL();
            com.tencent.mm.blink.a.ec("installPendingPlugins dependency made.");
            com.tencent.mm.sdk.b.a.xef.m(new lr());
        }
        boolean tQ = tQ();
        boolean z = gVar.DS() && g.Dh().Cy();
        if (z && !tQ) {
            g.Dh().Cz();
        }
        com.tencent.mm.blink.b.wo().aR(tQ);
        if (z && tQ) {
            g.Dh().Cz();
        }
        com.tencent.mm.blink.a.ec("afterAccountInit");
    }

    public boolean tQ() {
        return true;
    }
}
