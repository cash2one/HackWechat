package com.tencent.mm.kernel;

import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class h<_Profile extends g> {
    private static h gQT;
    private c gQU = new c();
    private d<_Profile> gQV;
    public byte[] gQW = new byte[0];
    public volatile boolean gQX = false;
    public long gQY;
    public a gQZ = new a();

    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, Object> {
        final /* synthetic */ g ffa;
        final /* synthetic */ com.tencent.mm.kernel.a.a gRa;
        final /* synthetic */ h gRb;

        public AnonymousClass1(h hVar, com.tencent.mm.kernel.a.a aVar, g gVar) {
            this.gRb = hVar;
            this.gRa = aVar;
            this.ffa = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.a aVar = this.gRa;
            com.tencent.mm.kernel.a.a.a("boot execute tasks...", new Object[0]);
            aVar.gRh.Ds();
            return zBS;
        }
    }

    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, Object> {
        final /* synthetic */ g ffa;
        final /* synthetic */ com.tencent.mm.kernel.a.a gRa;
        final /* synthetic */ h gRb;

        public AnonymousClass2(h hVar, com.tencent.mm.kernel.a.a aVar, g gVar) {
            this.gRb = hVar;
            this.gRa = aVar;
            this.ffa = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.a aVar = this.gRa;
            g gVar = this.ffa;
            com.tencent.mm.kernel.a.a.a("boot execute extension... ", new Object[0]);
            aVar.gRh.b(gVar);
            return zBS;
        }
    }

    class AnonymousClass3 implements b<Object> {
        final /* synthetic */ h gRb;
        final /* synthetic */ long gyu;

        public AnonymousClass3(h hVar, long j) {
            this.gRb = hVar;
            this.gyu = j;
        }

        public final void aB(Object obj) {
            com.tencent.mm.blink.a.ec("executeBootExtension");
            synchronized (this.gRb.gQW) {
                this.gRb.gQX = true;
            }
            com.tencent.mm.kernel.a.a.a("summerboot mmskeleton boot startup finished in [%s]!", com.tencent.mm.kernel.a.a.aG(this.gyu));
            this.gRb.gQZ.ul();
            com.tencent.mm.blink.a.ec("onStartupDone");
            this.gRb.gQY = System.currentTimeMillis();
        }
    }

    private static class a extends com.tencent.mm.cd.a<com.tencent.mm.kernel.api.g> implements com.tencent.mm.kernel.api.g {
        public a() {
            super(d.zCO);
        }

        public final void ul() {
            a(new com.tencent.mm.cd.a.a<com.tencent.mm.kernel.api.g>(this) {
                final /* synthetic */ a gRc;

                {
                    this.gRc = r1;
                }

                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.kernel.api.g) obj).ul();
                }
            });
        }

        public final void aG(final boolean z) {
            a(new com.tencent.mm.cd.a.a<com.tencent.mm.kernel.api.g>(this) {
                final /* synthetic */ a gRc;

                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.kernel.api.g) obj).aG(z);
                }
            });
        }
    }

    private h(_Profile _Profile) {
        this.gQV = new d(_Profile);
    }

    public final c Df() {
        Assert.assertNotNull("mCorePlugins not initialized!", this.gQU);
        return this.gQU;
    }

    public final d<_Profile> Dg() {
        Assert.assertNotNull("mCoreProcess not initialized!", this.gQV);
        return this.gQV;
    }

    public static <_Profile extends g> h<_Profile> Do() {
        Assert.assertNotNull("Skeleton not initialized!", gQT);
        return gQT;
    }

    public final void a(com.tencent.mm.kernel.api.g gVar) {
        Object obj = null;
        synchronized (this.gQW) {
            if (this.gQX) {
                obj = 1;
            }
        }
        if (obj != null) {
            gVar.ul();
        } else {
            this.gQZ.aE(gVar);
        }
    }

    public final void b(com.tencent.mm.kernel.api.g gVar) {
        this.gQZ.remove(gVar);
    }

    public static synchronized <_Profile extends g> h<_Profile> d(_Profile _Profile) {
        h<_Profile> hVar;
        synchronized (h.class) {
            if (gQT != null) {
                j.i("MicroMsg.MMSkeleton", "Kernel not null, has initialized.", new Object[0]);
                hVar = gQT;
            } else {
                j.i("MicroMsg.MMSkeleton", "Initialize skeleton, create whole world.", new Object[0]);
                hVar = new h(_Profile);
                gQT = hVar;
            }
        }
        return hVar;
    }
}
