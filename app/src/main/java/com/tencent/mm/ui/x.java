package com.tencent.mm.ui;

import com.tencent.mm.aw.d;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.k.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.s.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;

public final class x implements b {
    MMFragmentActivity xFE;
    c<oo> xFl = new c<oo>(this) {
        final /* synthetic */ x xKV;

        {
            this.xKV = r2;
            this.xen = oo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.xKV.xKQ = true;
            ag.K(this.xKV.xKR);
            ag.y(this.xKV.xKR);
            return false;
        }
    };
    c xFm = new 5(this);
    LauncherUI.c xKO;
    c xKP;
    boolean xKQ;
    Runnable xKR = new 1(this);
    a xKS = new a(this) {
        final /* synthetic */ x xKV;

        {
            this.xKV = r1;
        }

        public final void ge(int i) {
            if (i == 262145 || i == 262156 || i == 262152 || i == 266260 || i == 266267) {
                x.b(this.xKV);
            }
            if (i == 262147 || i == 262149) {
                x.b(this.xKV);
            }
        }

        public final void gf(int i) {
            if (i == 266241) {
                x.b(this.xKV);
            }
            if (i == 266244) {
                com.tencent.mm.s.c.Bq().aS(262147, 266241);
                com.tencent.mm.s.c.Bq().aS(262149, 266241);
                x.b(this.xKV);
            }
        }

        public final void b(w.a aVar) {
        }
    };
    b xKT = new 2(this);
    c xKU = new 3(this);

    static /* synthetic */ void b(x xVar) {
        if (ar.Hj()) {
            int parseInt;
            boolean aQ = com.tencent.mm.s.c.Bq().aQ(262156, 266241);
            boolean aR = com.tencent.mm.s.c.Bq().aR(262156, 266241);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "hasMallNew: %s, hasMallDot: %s", new Object[]{Boolean.valueOf(aQ), Boolean.valueOf(aR)});
            if (aQ || aR) {
                ar.Hg();
                long longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.xvO, Long.valueOf(-1))).longValue();
                long ow = t.ow(g.zY().getValue("PayWalletRedDotExpire"));
                long j = 86400000 * ow;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[]{Long.valueOf(longValue), Long.valueOf(ow), Long.valueOf(j), Long.valueOf(System.currentTimeMillis()), Double.valueOf((((double) System.currentTimeMillis()) - ((double) longValue)) / 8.64E7d)});
                if (longValue > 0 && ow > 0 && r14 >= ((double) ow)) {
                    com.tencent.mm.s.c.Bq().o(262156, false);
                    aQ = false;
                    aR = false;
                }
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "after check, hasMallNew: %s, hasMallDot: %s", new Object[]{Boolean.valueOf(aQ), Boolean.valueOf(aR)});
            boolean aQ2 = com.tencent.mm.s.c.Bq().aQ(262145, 266241);
            boolean aR2 = com.tencent.mm.s.c.Bq().aR(266260, 266241);
            boolean aQ3 = com.tencent.mm.s.c.Bq().aQ(262147, 266241);
            boolean aQ4 = com.tencent.mm.s.c.Bq().aQ(262149, 266241);
            boolean aR3 = com.tencent.mm.s.c.Bq().aR(262152, 266256);
            boolean aQ5 = com.tencent.mm.s.c.Bq().aQ(262152, 266256);
            boolean a = com.tencent.mm.s.c.Bq().a(w.a.xxB, 266241);
            com.tencent.mm.plugin.welab.a.a.c cVar = (com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.c.class);
            Object obj = cVar != null ? (cVar.bVz() || cVar.bVA()) ? 1 : null : null;
            com.tencent.mm.s.a Bq = com.tencent.mm.s.c.Bq();
            if (Bq.initialized) {
                com.tencent.mm.s.b.a x = Bq.gLu.x(262152, 266256, 4);
                parseInt = x == null ? 0 : com.tencent.mm.s.a.parseInt(x.value);
            } else {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.NewBadge", "hasUnreadNum NewBadge has not initialized");
                parseInt = 0;
            }
            q.c cVar2 = q$a.vct;
            Object obj2 = (cVar2 == null || !(cVar2.auj() || cVar2.auk())) ? null : 1;
            Object obj3 = (obj2 == null || !(aR3 || aQ5 || parseInt > 0)) ? null : 1;
            if (aR || aQ || aQ2 || obj3 != null || aQ3 || aQ4 || aR2 || r2 != null || a) {
                xVar.xKP.lN(true);
            } else {
                xVar.xKP.lN(false);
            }
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            objArr[1] = Integer.valueOf(aR ? 1 : 0);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(1);
            gVar.h(14872, objArr);
            ay Dr = com.tencent.mm.plugin.x.a.bfn().Dr(com.tencent.mm.aw.b.hId);
            if (Dr != null && !Dr.field_isExit) {
                com.tencent.mm.plugin.x.a.bfm().hIq = new d.a(xVar) {
                    final /* synthetic */ x xKV;

                    {
                        this.xKV = r1;
                    }

                    public final void c(ay ayVar) {
                        if (ayVar != null && ayVar.field_tipId == com.tencent.mm.aw.b.hId && com.tencent.mm.plugin.x.a.bfo().ig(com.tencent.mm.aw.b.hId)) {
                            this.xKV.xKP.lN(true);
                        }
                    }
                };
                return;
            } else if (com.tencent.mm.plugin.x.a.bfo().ig(com.tencent.mm.aw.b.hId)) {
                xVar.xKP.lN(true);
                return;
            } else {
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "want update more menu new tips, but mmcore not ready");
    }

    protected final void cno() {
        com.tencent.mm.blink.b.wo().f(new Runnable(this) {
            final /* synthetic */ x xKV;

            {
                this.xKV = r1;
            }

            public final void run() {
                this.xKV.xKQ = true;
                ag.K(this.xKV.xKR);
                ag.y(this.xKV.xKR);
            }
        });
    }

    protected final void cnm() {
        com.tencent.mm.blink.b.wo().f(new Runnable(this) {
            final /* synthetic */ x xKV;

            {
                this.xKV = r1;
            }

            public final void run() {
                this.xKV.xKQ = true;
                ag.K(this.xKV.xKR);
                ag.h(this.xKV.xKR, 300);
            }
        });
    }

    protected final void cnk() {
        com.tencent.mm.blink.b.wo().f(new 10(this));
    }

    protected final void cnl() {
        if (this.xKQ) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
            cno();
        }
    }

    public final void DY(int i) {
        if (this.xKP != null) {
            this.xKP.DH(i);
            this.xKO.cmC();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        ar.Hg();
        if (mVar == com.tencent.mm.z.c.Fd()) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", new Object[]{Integer.valueOf(i), obj});
            if (com.tencent.mm.storage.x.gy((String) obj)) {
                cnm();
            }
        }
    }

    public final void DZ(int i) {
        if (this.xKP != null) {
            this.xKP.oV(i);
        }
    }
}
