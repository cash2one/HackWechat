package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ag;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public final class c implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, f {
    private static c gRs = new c();
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> gRv = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            if (aVar.gSu.gRX == com.tencent.mm.kernel.b.b.class) {
                com.tencent.mm.kernel.b.f fVar = (com.tencent.mm.kernel.b.f) aVar.gRT;
                if (fVar.isConfigured()) {
                    x.i("MicroMsg.CallbacksProxy", "skip configure for plugin %s.", fVar);
                } else {
                    x.i("MicroMsg.CallbacksProxy", "configuring plugin [%s]...", fVar);
                    fVar.invokeConfigure(g.Dg().CN());
                }
            }
            return zBS;
        }
    };
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> gRw = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            if (aVar.gSu.gRX == com.tencent.mm.kernel.a.c.b.class) {
                c.a((com.tencent.mm.kernel.a.c.b) aVar.gRT, g.Dg().CN());
            }
            return zBS;
        }
    };
    public static com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> gRx = new com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a>() {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) obj;
            x.i("MicroMsg.CallbacksProxy", "before running %s", aVar.gRT);
            if (aVar.gSu.gRX == h.class) {
                ((h) aVar.gRT).Dq();
            } else if (aVar.gSu.gRX == com.tencent.mm.kernel.api.a.class) {
                g.Dj().a(g.Dj().gQj.ckU(), ((com.tencent.mm.kernel.api.a) aVar.gRT).collectDatabaseFactory());
            } else if (aVar.gSu.gRX == com.tencent.mm.kernel.api.e.class) {
                ((com.tencent.mm.kernel.api.e) aVar.gRT).onDataBaseOpened(g.Dj().gQj, g.Dj().gQk);
            } else if (aVar.gSu.gRX == ag.class) {
                g.Dj().a((ag) aVar.gRT);
            } else if (aVar.gSu.gRX == com.tencent.mm.kernel.api.c.class) {
                ((com.tencent.mm.kernel.api.c) aVar.gRT).onAccountInitialized(g.Dh().gPo);
            }
            x.i("MicroMsg.CallbacksProxy", "[account-init] for phase(%s) subject(%s)", aVar.gSu.gRX, aVar.gRT);
            return zBS;
        }
    };
    private static Map<Integer, Map> gRy = new ConcurrentHashMap();
    private ConcurrentHashMap<Object, e> gRA = new ConcurrentHashMap();
    public ConcurrentHashMap gRB = new ConcurrentHashMap();
    private boolean gRk = true;
    public final com.tencent.mm.kernel.a.b.g gRl = new com.tencent.mm.kernel.a.b.g();
    public final com.tencent.mm.kernel.a.b.g gRm = new com.tencent.mm.kernel.a.b.g();
    public final com.tencent.mm.kernel.a.b.g gRn = new com.tencent.mm.kernel.a.b.g();
    public final b gRo = new b();
    public final c gRp = new c();
    public final a gRq = new a();
    public final d gRr = new d();
    public volatile boolean gRt = false;
    private AtomicBoolean gRu = new AtomicBoolean(false);
    private Set<Looper> gRz = new HashSet();

    private static final class e {
        private long gRN;
        private int mStatus;

        public e() {
            this.gRN = 0;
            this.mStatus = 0;
            this.gRN = Thread.currentThread().getId();
        }

        public final synchronized boolean Dv() {
            boolean z = false;
            synchronized (this) {
                if (!(this.mStatus == 1 && this.gRN == Thread.currentThread().getId())) {
                    if (this.mStatus != 2) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public final synchronized void gD(int i) {
            if (i > this.mStatus) {
                this.mStatus = i;
            }
        }
    }

    static class a extends com.tencent.mm.cd.a<com.tencent.mm.kernel.api.b> implements com.tencent.mm.kernel.api.b {
        private boolean gRD = false;

        a() {
        }

        public final /* synthetic */ com.tencent.mm.vending.b.b aE(Object obj) {
            return a((com.tencent.mm.kernel.api.b) obj);
        }

        public final synchronized com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> a(com.tencent.mm.kernel.api.b bVar) {
            com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> aE;
            aE = super.aE(bVar);
            if (this.gRD) {
                List collectStoragePaths = bVar.collectStoragePaths();
                if (collectStoragePaths != null && collectStoragePaths.size() > 0) {
                    b(collectStoragePaths, g.Dj().gQi);
                }
                x.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", bVar);
            }
            return aE;
        }

        public final List<String> collectStoragePaths() {
            LinkedList czM = czM();
            List<String> linkedList = new LinkedList();
            Iterator it = czM.iterator();
            while (it.hasNext()) {
                com.tencent.mm.vending.b.b bVar = (com.tencent.mm.vending.b.b) it.next();
                if (bVar != null) {
                    Collection collectStoragePaths = ((com.tencent.mm.kernel.api.b) bVar.zBN).collectStoragePaths();
                    if (collectStoragePaths != null) {
                        linkedList.addAll(collectStoragePaths);
                    }
                }
            }
            return linkedList;
        }

        public final synchronized void fO(String str) {
            List collectStoragePaths = collectStoragePaths();
            this.gRD = true;
            x.i("MicroMsg.CallbacksProxy", "all account storage folder %s", collectStoragePaths.toString());
            b(collectStoragePaths, str);
        }

        private static void b(List<String> list, String str) {
            String[] strArr = new String[(list.size() + 1)];
            strArr[0] = str;
            for (int i = 0; i < list.size(); i++) {
                strArr[i + 1] = str + ((String) list.get(i));
            }
            com.tencent.mm.a.e.c(strArr);
        }
    }

    private static class b extends com.tencent.mm.cd.a<com.tencent.mm.kernel.api.c> implements com.tencent.mm.kernel.api.c {
        private b() {
        }

        public final void onAccountInitialized(final com.tencent.mm.kernel.e.c cVar) {
            a(new com.tencent.mm.cd.a.a<com.tencent.mm.kernel.api.c>(this) {
                final /* synthetic */ b gRF;

                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.kernel.api.c) obj).onAccountInitialized(cVar);
                }
            });
        }

        public final void onAccountRelease() {
            a(new com.tencent.mm.cd.a.a<com.tencent.mm.kernel.api.c>(this) {
                final /* synthetic */ b gRF;

                {
                    this.gRF = r1;
                }

                public final /* synthetic */ void az(Object obj) {
                    com.tencent.mm.kernel.api.c cVar = (com.tencent.mm.kernel.api.c) obj;
                    if (c.a(c.Dt().gRn, com.tencent.mm.kernel.api.c.class, cVar)) {
                        cVar.onAccountRelease();
                    }
                }
            });
        }
    }

    static class c extends com.tencent.mm.cd.a<com.tencent.mm.kernel.api.e> implements com.tencent.mm.kernel.api.e {
        c() {
        }

        public final void onDataBaseOpened(final com.tencent.mm.by.h hVar, final com.tencent.mm.by.h hVar2) {
            a(new com.tencent.mm.cd.a.a<com.tencent.mm.kernel.api.e>(this) {
                final /* synthetic */ c gRI;

                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.kernel.api.e) obj).onDataBaseOpened(hVar, hVar2);
                }
            });
        }

        public final void onDataBaseClosed(final com.tencent.mm.by.h hVar, final com.tencent.mm.by.h hVar2) {
            a(new com.tencent.mm.cd.a.a<com.tencent.mm.kernel.api.e>(this) {
                final /* synthetic */ c gRI;

                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.kernel.api.e) obj).onDataBaseClosed(hVar, hVar2);
                }
            });
        }
    }

    static class d extends com.tencent.mm.cd.a<f> implements f {
        private boolean gRJ = false;
        private String gRK;

        d() {
        }

        public final /* synthetic */ com.tencent.mm.vending.b.b aE(Object obj) {
            return a((f) obj);
        }

        public final void Dp() {
            a(new com.tencent.mm.cd.a.a<f>(this) {
                final /* synthetic */ d gRL;

                {
                    this.gRL = r1;
                }

                public final /* synthetic */ void az(Object obj) {
                    ((f) obj).Dp();
                }
            });
        }

        public final synchronized com.tencent.mm.vending.b.b<f> a(f fVar) {
            com.tencent.mm.vending.b.b<f> aE;
            aE = super.aE(fVar);
            if (this.gRJ) {
                fVar.fN(this.gRK);
                x.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", fVar);
            }
            return aE;
        }

        public final synchronized void fN(final String str) {
            a(new com.tencent.mm.cd.a.a<f>(this) {
                final /* synthetic */ d gRL;

                public final /* synthetic */ void az(Object obj) {
                    ((f) obj).fN(str);
                }
            });
            this.gRJ = true;
            this.gRK = str;
        }
    }

    static /* synthetic */ void a(com.tencent.mm.kernel.a.c.b bVar, com.tencent.mm.kernel.b.g gVar) {
        if (gRy.containsKey(Integer.valueOf(bVar.hashCode()))) {
            a.a("skip task %s execution hash %s", bVar.name(), Integer.valueOf(bVar.hashCode()));
            return;
        }
        bVar.execute(gVar);
        gRy.put(Integer.valueOf(bVar.hashCode()), gRy);
        a.a("boot task executing [%s] hash %s...", bVar.name(), Integer.valueOf(bVar.hashCode()));
    }

    private c() {
    }

    public static c Dt() {
        return gRs;
    }

    public static boolean a(com.tencent.mm.kernel.a.b.g gVar, Class cls, Object obj) {
        com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) gVar.p(cls).aG(obj);
        if (aVar == null) {
            return false;
        }
        return aVar.gRU;
    }

    public final void aC(Object obj) {
        if (!((com.tencent.mm.kernel.b.h) g.Dg().CN()).DS()) {
            x.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
        } else if (com.tencent.mm.kernel.f.aA(obj)) {
            x.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
        } else {
            this.gRn.aL(obj);
        }
    }

    public final void Dp() {
        this.gRr.Dp();
    }

    public final void fN(String str) {
        this.gRq.fO(str);
        this.gRr.fN(str);
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        if (this.gRk) {
            com.tencent.mm.blink.a.ec("beforeAccountInit");
            this.gRn.b(com.tencent.mm.kernel.api.c.class, true);
            com.tencent.mm.kernel.a.b.e DE = com.tencent.mm.kernel.a.b.e.DE();
            DE.a(new com.tencent.mm.kernel.a.b.e.b(), gRx, this.gRn);
            this.gRn.DQ();
            DE.start("account-init from onAccountInitialized");
            DE.DG();
            return;
        }
        this.gRo.onAccountInitialized(cVar);
    }

    public final void onAccountRelease() {
        this.gRo.onAccountRelease();
        this.gRn.b(h.class, true);
    }

    public final void onDataBaseOpened(com.tencent.mm.by.h hVar, com.tencent.mm.by.h hVar2) {
        if (!this.gRk) {
            this.gRp.onDataBaseOpened(hVar, hVar2);
        }
    }

    public final void onDataBaseClosed(com.tencent.mm.by.h hVar, com.tencent.mm.by.h hVar2) {
        this.gRp.onDataBaseClosed(hVar, hVar2);
    }

    public final void add(Object obj) {
        if (obj instanceof com.tencent.mm.kernel.api.c) {
            this.gRo.aE((com.tencent.mm.kernel.api.c) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.e) {
            this.gRp.aE((com.tencent.mm.kernel.api.e) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.b) {
            this.gRq.a((com.tencent.mm.kernel.api.b) obj);
        }
        if (obj instanceof f) {
            this.gRr.a((f) obj);
        }
    }

    public final void b(Looper looper) {
        x.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", looper);
        this.gRz.add(looper);
    }

    public final void aD(Object obj) {
        if (this.gRu.get() && !this.gRt) {
            int i;
            if (!((com.tencent.mm.kernel.b.h) g.Dg().CN()).DS()) {
                i = 0;
            } else if (this.gRz.contains(Looper.myLooper())) {
                x.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", Looper.myLooper());
                i = 0;
            } else if (g.Dk().gQE.gQX) {
                i = 1;
            } else {
                x.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
                i = 0;
            }
            if (i == 0) {
                x.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", obj);
                return;
            }
            if (!this.gRA.containsKey(obj)) {
                this.gRA.putIfAbsent(obj, new e());
            }
            e eVar = (e) this.gRA.get(obj);
            if (eVar.Dv()) {
                long currentTimeMillis = System.currentTimeMillis();
                x.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", obj);
                x.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
                a aVar = (a) this.gRn.gSE.get(obj);
                int i2 = (aVar == null || !aVar.DR()) ? 0 : 1;
                if (i2 == 0) {
                    x.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
                    this.gRn.aL(obj);
                }
                try {
                    com.tencent.mm.kernel.a.b.f.a aK;
                    eVar.gD(1);
                    if (obj instanceof com.tencent.mm.kernel.b.f) {
                        if (!((com.tencent.mm.kernel.b.f) obj).isConfigured()) {
                            aK = this.gRm.p(com.tencent.mm.kernel.b.b.class).aK((com.tencent.mm.kernel.b.b) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gRv);
                        }
                        aK = this.gRl.p(com.tencent.mm.kernel.a.c.b.class).aK((com.tencent.mm.kernel.a.c.b) obj);
                        Assert.assertNotNull(aK);
                        aK.a(gRw);
                    }
                    if (g.Dh().Cy()) {
                        if (obj instanceof h) {
                            aK = this.gRn.p(h.class).aK((h) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gRx);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.a) {
                            aK = this.gRn.p(com.tencent.mm.kernel.api.a.class).aK((com.tencent.mm.kernel.api.a) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gRx);
                        }
                        if (obj instanceof ag) {
                            aK = this.gRn.p(ag.class).aK((ag) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gRx);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.e) {
                            aK = this.gRn.p(com.tencent.mm.kernel.api.e.class).aK((com.tencent.mm.kernel.api.e) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gRx);
                        }
                        if (obj instanceof com.tencent.mm.kernel.api.c) {
                            aK = this.gRn.p(com.tencent.mm.kernel.api.c.class).aK((com.tencent.mm.kernel.api.c) obj);
                            Assert.assertNotNull(aK);
                            aK.a(gRx);
                        }
                        eVar.gD(2);
                        x.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                    x.i("MicroMsg.CallbacksProxy", "account not init, return.");
                    eVar.gD(2);
                    x.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                    eVar.gD(2);
                    x.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
    }

    public final void Du() {
        com.tencent.mm.blink.a.ec("initializePendingPlugins");
        if (this.gRu.compareAndSet(false, true)) {
            x.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
            c cVar = gRs;
            for (com.tencent.mm.kernel.b.f aC : g.Df().CM()) {
                cVar.aC(aC);
            }
            com.tencent.mm.blink.a.ec("makePluginsParallelsDependency");
            for (Object next : this.gRB.keySet()) {
                g.Dk().a((com.tencent.mm.kernel.b.h) g.Dg().CN(), next);
                gRs.aC(next);
            }
            com.tencent.mm.blink.a.ec("configureAndExecutePendingPlugins");
            this.gRm.b(com.tencent.mm.kernel.b.b.class, false);
            com.tencent.mm.kernel.a.b.e.DE().a(new com.tencent.mm.kernel.a.b.e.b(), gRv, this.gRm, "configure-functional from pending plugins");
            this.gRl.b(com.tencent.mm.kernel.a.c.b.class, false);
            com.tencent.mm.kernel.a.b.e.DE().a(new com.tencent.mm.kernel.a.b.e.b(), gRw, this.gRl, "task-functional from pending plugins");
            com.tencent.mm.blink.a.ec("configureAndExecutePendingPlugins done");
            if (((com.tencent.mm.kernel.b.h) g.Dg().CN()).DS() && g.Dh().Cy()) {
                this.gRn.b(h.class, false);
                com.tencent.mm.kernel.a.b.e DE = com.tencent.mm.kernel.a.b.e.DE();
                DE.a(new com.tencent.mm.kernel.a.b.e.b(), gRx, this.gRn);
                this.gRn.DQ();
                DE.start("account-init from pending plugins");
                DE.DG();
            }
            this.gRt = true;
            if (((com.tencent.mm.kernel.b.h) g.Dg().CN()).DS()) {
                g.Dh().Cp();
            }
            com.tencent.mm.blink.a.ec("initializePendingPlugins done");
            if ((com.tencent.mm.protocal.d.vAC || com.tencent.mm.protocal.d.vAB) && ((com.tencent.mm.kernel.b.h) g.Dg().CN()).DS() && g.Dh().Cy()) {
                a(this.gRl);
                a(this.gRm);
                a(this.gRn);
            }
            com.tencent.mm.blink.a.ec("checkAllUnConsumed done");
        }
    }

    private static void a(com.tencent.mm.kernel.a.b.g gVar) {
        Map hashMap = new HashMap();
        for (com.tencent.mm.kernel.a.b.f fVar : gVar.gSy.values()) {
            List DK = fVar.DK();
            if (DK.size() > 0) {
                hashMap.put(fVar, DK);
            }
        }
        String str = "MicroMsg.CallbacksProxy";
        String str2 = "do parallels result check, %s for %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(hashMap.size() > 0);
        objArr[1] = gVar;
        x.i(str, str2, objArr);
        if (hashMap.size() > 0) {
            com.tencent.mm.blink.a.j(0, 1);
            Map hashMap2 = new HashMap();
            String str3 = "BlinkStartup";
            StringBuilder stringBuilder = new StringBuilder();
            for (com.tencent.mm.kernel.a.b.f fVar2 : hashMap.keySet()) {
                List list = (List) hashMap.get(fVar2);
                stringBuilder.append(fVar2.gSn);
                stringBuilder.append(" : ");
                stringBuilder.append(list.toString());
                stringBuilder.append("\n");
            }
            x.e("MicroMsg.CallbacksProxy", "unconsumed message %s", stringBuilder.toString());
            x.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
            com.tencent.mm.plugin.report.d.pPH.c(str3, r0, hashMap2);
        }
    }
}
