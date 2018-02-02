package com.tencent.mm.kernel;

import android.app.Application;
import android.os.SystemClock;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.n;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.api.b;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bv;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g {
    private static g gQD;
    public final a gPI = new a();
    public h<h> gQE;
    private ag gQF;
    private bv gQG = null;
    public e gQH;
    public a gQI;
    public b gQJ;
    public final a gQK = new a();
    private final boolean gQL;
    private ConcurrentHashMap gQM = new ConcurrentHashMap();
    public volatile boolean gQN = false;

    private static class a extends com.tencent.mm.cd.a<com.tencent.mm.ae.n.a> implements com.tencent.mm.ae.n.a {
        private a() {
        }

        public final void a(final n nVar, final boolean z) {
            a(new com.tencent.mm.cd.a.a<com.tencent.mm.ae.n.a>(this) {
                final /* synthetic */ a gQS;

                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.ae.n.a) obj).a(nVar, z);
                }
            });
        }

        public final void a(final n nVar) {
            a(new com.tencent.mm.cd.a.a<com.tencent.mm.ae.n.a>(this) {
                final /* synthetic */ a gQS;

                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.ae.n.a) obj).a(nVar);
                }
            });
        }
    }

    private g(final h hVar) {
        this.gQE = h.d(hVar);
        this.gQL = ((h) this.gQE.Dg().CN()).DS();
        if (this.gQL) {
            this.gQG = new bv();
            this.gQF = new ag("worker");
            this.gQF.F(new Runnable(this) {
                final /* synthetic */ g gQO;

                {
                    this.gQO = r1;
                }

                public final void run() {
                    an.eT(ac.getContext());
                }
            });
        }
        this.gQE.Df().gPZ = new com.tencent.mm.kernel.c.a(this) {
            final /* synthetic */ g gQO;

            public final void b(f fVar) {
                this.gQO.a(hVar, (Object) fVar);
            }

            public final void a(com.tencent.mm.kernel.c.a aVar) {
                this.gQO.a(hVar, (Object) aVar);
                c.Dt().aC(aVar);
            }

            public final void b(com.tencent.mm.kernel.c.a aVar) {
                g gVar = this.gQO;
                h hVar = hVar;
                c Dt = c.Dt();
                if (aVar instanceof com.tencent.mm.kernel.api.c) {
                    Dt.gRo.remove((com.tencent.mm.kernel.api.c) aVar);
                }
                if (aVar instanceof e) {
                    Dt.gRp.remove((e) aVar);
                }
                if (aVar instanceof b) {
                    Dt.gRq.remove((b) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.f) {
                    Dt.gRr.remove((com.tencent.mm.kernel.api.f) aVar);
                }
                if (aVar instanceof ApplicationLifeCycle) {
                    hVar.gSL.remove((ApplicationLifeCycle) aVar);
                }
                if (aVar instanceof d) {
                    gVar.gPI.remove((d) aVar);
                }
                if (aVar instanceof com.tencent.mm.kernel.api.g) {
                    gVar.gQE.b((com.tencent.mm.kernel.api.g) aVar);
                }
            }

            public final void c(f fVar) {
                c Dt = c.Dt();
                if (fVar != null) {
                    Dt.aD(fVar);
                }
            }

            public final void c(com.tencent.mm.kernel.c.a aVar) {
                c Dt = c.Dt();
                if (aVar != null) {
                    Dt.aD(aVar);
                }
            }
        };
    }

    public final void a(h hVar, Object obj) {
        if (this.gQM.containsKey(obj)) {
            x.i("MicroMsg.MMKernel", "Already add, skip it[%s].", obj);
        } else if (this.gQM.putIfAbsent(obj, this.gQM) != null) {
            x.i("MicroMsg.MMKernel", "Already add, skip[%s].", obj);
        } else {
            c.Dt().add(obj);
            if (obj instanceof ApplicationLifeCycle) {
                hVar.gSL.aE((ApplicationLifeCycle) obj);
            }
            if (obj instanceof d) {
                this.gPI.aE((d) obj);
            }
            if (obj instanceof com.tencent.mm.kernel.api.g) {
                this.gQE.a((com.tencent.mm.kernel.api.g) obj);
            }
        }
    }

    public final void a(com.tencent.mm.kernel.api.g gVar) {
        this.gQE.a(gVar);
    }

    public final void b(com.tencent.mm.kernel.api.g gVar) {
        this.gQE.b(gVar);
    }

    public static c Df() {
        Assert.assertNotNull("mCorePlugins not initialized!", Dk().gQE.Df());
        return Dk().gQE.Df();
    }

    public static d<h> Dg() {
        Assert.assertNotNull("mCoreProcess not initialized!", Dk().gQE.Dg());
        return Dk().gQE.Dg();
    }

    public static a Dh() {
        Assert.assertNotNull("mCoreAccount not initialized!", Dk().gQI);
        return Dk().gQI;
    }

    public static b Di() {
        Assert.assertNotNull("mCoreNetwork not initialized!", Dk().gQJ);
        return Dk().gQJ;
    }

    public static e Dj() {
        Assert.assertNotNull("mCoreStorage not initialized!", Dk().gQH);
        return Dk().gQH;
    }

    public static g Dk() {
        Assert.assertNotNull("Kernel not initialized by MMApplication!", gQD);
        return gQD;
    }

    public static <T extends com.tencent.mm.kernel.b.a> T k(Class<T> cls) {
        Dk();
        return Df().k(cls);
    }

    public static <T extends com.tencent.mm.kernel.c.a> T h(Class<T> cls) {
        Dk();
        return Df().h(cls);
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, N n) {
        Dk();
        Df().a((Class) cls, new com.tencent.mm.kernel.c.d(n));
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, com.tencent.mm.kernel.c.c<N> cVar) {
        Dk();
        Df().a((Class) cls, (com.tencent.mm.kernel.c.c) cVar);
    }

    public static void j(Class<? extends com.tencent.mm.kernel.c.a> cls) {
        Dk();
        Df().j(cls);
    }

    public static n CG() {
        Dk();
        return Di().gPJ;
    }

    public static bv Dl() {
        Assert.assertTrue(Dk().gQL);
        return Dk().gQG;
    }

    public static ag Dm() {
        Assert.assertTrue(Dk().gQL);
        return Dk().gQF;
    }

    public static synchronized void b(h hVar) {
        synchronized (g.class) {
            if (gQD != null) {
                h hVar2 = (h) gQD.gQE.Dg().CN();
                Application application = hVar.gSI;
                hVar2.gSK = hVar.gSK;
                hVar2.gSI = application;
                x.i("MicroMsg.MMKernel", "Kernel not null, has initialized.");
            } else {
                j.a(new com.tencent.mm.kernel.j.a() {
                    public final void e(String str, String str2, Object... objArr) {
                        x.e(str, str2, objArr);
                    }

                    public final void w(String str, String str2, Object... objArr) {
                        x.w(str, str2, objArr);
                    }

                    public final void i(String str, String str2, Object... objArr) {
                        x.i(str, str2, objArr);
                    }

                    public final void d(String str, String str2, Object... objArr) {
                        x.d(str, str2, objArr);
                    }

                    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                        x.printErrStackTrace(str, th, str2, objArr);
                    }
                });
                x.i("MicroMsg.MMKernel", "Initialize kernel, create whole WeChat world.");
                gQD = new g(hVar);
            }
        }
    }

    public static void gC(int i) {
        a Dh = Dh();
        if (a.gz(i) && a.gPk.Cg() == i && Dh.Cy()) {
            x.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", Integer.valueOf(i));
            return;
        }
        synchronized (Dh.gPj) {
            a.gPk.eE(i);
            Dh.Cn();
            Dh.gPw = SystemClock.elapsedRealtime();
            Dh.bv(true);
        }
    }

    public final void fM(String str) {
        x.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", o.getString(a.Cg()), str, bh.cgy());
        a.fG(bh.cgy().toString() + str);
        this.gQI.Cq().aR((long) a.Cg());
        releaseAll();
        a.Cl();
        a.bw(false);
    }

    public final void releaseAll() {
        String str = "MicroMsg.MMKernel";
        String str2 = "release uin:%s ";
        Object[] objArr = new Object[1];
        objArr[0] = this.gQI != null ? o.getString(a.Cg()) : "-1";
        x.w(str, str2, objArr);
        if (this.gQJ.gPJ != null) {
            this.gQJ.gPJ.reset();
        }
        if (this.gQF != null) {
            this.gQF.a(new ag.b(this) {
                final /* synthetic */ g gQO;

                {
                    this.gQO = r1;
                }

                public final void Dn() {
                    if (this.gQO.gQI != null) {
                        this.gQO.gQI.release();
                    }
                }
            });
        }
    }
}
