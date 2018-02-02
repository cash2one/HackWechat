package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.kernel.a.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.b.h.1;
import com.tencent.mm.kernel.b.h.6;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.h.2;
import com.tencent.mm.kernel.h.3;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.splash.e;
import com.tencent.mm.splash.k;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.m;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.z.aq;
import junit.framework.Assert;

public class WeChatSplashStartup implements a {
    private Application app;
    private MMApplicationLike lifeCycle;
    h profile;
    private String thisProcess;

    public final void a(Application application, String str, MMApplicationLike mMApplicationLike) {
        this.app = application;
        this.thisProcess = str;
        this.lifeCycle = mMApplicationLike;
        this.profile = o.ue();
        g.b(this.profile);
        h hVar = this.profile;
        hVar.gSL.a(new 6(hVar, this.app));
    }

    public final void c(k.a aVar) {
        d(aVar);
    }

    public final void uk() {
        d(null);
    }

    private void d(final k.a aVar) {
        d dVar;
        com.tencent.mm.blink.a.fh(2);
        boolean z = aVar == null;
        h hVar = this.profile;
        hVar.gSL.a(new 1(hVar));
        b fVar = new f();
        com.tencent.mm.kernel.a.a aVar2 = this.profile.gQb;
        Assert.assertNotNull(fVar);
        com.tencent.mm.kernel.h.Do().Dg().CN();
        aVar2.gRh = fVar;
        if (!z) {
            e.chp();
            new c<lr>(this) {
                final /* synthetic */ WeChatSplashStartup fga;

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    new Handler(Looper.getMainLooper()).post(new 1(this));
                    dead();
                    return false;
                }
            }.ceO();
        }
        g Dk = g.Dk();
        if (z) {
            dVar = null;
        } else {
            if (h.fff == null) {
                h.fff = new h("initThread");
            }
            h hVar2 = h.fff;
            hVar2.tS();
            g.Dk().a(new 5(this, hVar2));
            com.tencent.mm.kernel.a.c.Dt().b(hVar2.ffg.getLooper());
            dVar = hVar2.ffh;
        }
        com.tencent.mm.kernel.h hVar3 = Dk.gQE;
        com.tencent.mm.blink.a.ec("startup");
        synchronized (hVar3.gQW) {
            if (hVar3.gQX) {
                com.tencent.mm.kernel.a.a.a("warning, mmskeleton has started up already.", new Object[0]);
            } else {
                com.tencent.mm.kernel.b.g CN = hVar3.Dg().CN();
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.a("mmskeleton boot startup for process [%s]...", new Object[]{CN.gOs});
                com.tencent.mm.kernel.a.a aVar3 = CN.gQb;
                Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", aVar3.gRh);
                com.tencent.mm.vending.g.c nF = com.tencent.mm.vending.g.g.czW().nF(true);
                com.tencent.mm.kernel.a.a.gRj = SystemClock.elapsedRealtime();
                com.tencent.mm.kernel.a.a.a("hello WeChat.", new Object[0]);
                aVar3.gRh.tN();
                long currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.a("boot install plugins...", new Object[0]);
                aVar3.gRh.tO();
                aVar3.mConfigured = true;
                com.tencent.mm.kernel.a.a.a("boot all installed plugins : %s...", new Object[]{com.tencent.mm.kernel.h.Do().Df().CM()});
                com.tencent.mm.kernel.a.a.a("boot install plugins done in [%s].", new Object[]{com.tencent.mm.kernel.a.a.aG(currentTimeMillis2)});
                com.tencent.mm.blink.a.ec("installPlugins");
                currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.a("boot make dependency of plugins...", new Object[0]);
                aVar3.gRh.Dr();
                com.tencent.mm.kernel.a.a.a("boot make dependency of done in [%s].", new Object[]{com.tencent.mm.kernel.a.a.aG(currentTimeMillis2)});
                currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.kernel.a.a.a("boot configure plugins...", new Object[0]);
                aVar3.gRh.a(CN);
                com.tencent.mm.kernel.a.a.a("boot configure plugins done in [%s].", new Object[]{com.tencent.mm.kernel.a.a.aG(currentTimeMillis2)});
                if (dVar != null) {
                    nF.a(dVar);
                }
                nF.b(new com.tencent.mm.kernel.h.1(hVar3, aVar3, CN));
                nF.b(new 2(hVar3, aVar3, CN));
                nF.a(d.zCO, new 3(hVar3, currentTimeMillis));
            }
        }
        e.a(new com.tencent.mm.splash.c(this) {
            final /* synthetic */ WeChatSplashStartup fga;
            m fgc = new m();

            {
                this.fga = r2;
            }

            public final boolean j(Intent intent) {
                if (intent == null || t.a(intent, "absolutely_exit_pid", 0) != Process.myPid()) {
                    return false;
                }
                x.i("MicroMsg.WeChatSplashStartup", "handle exit intent.");
                MMAppMgr.lW(t.a(intent, "kill_service", true));
                return true;
            }

            public final boolean a(Activity activity, Runnable runnable) {
                g.Dh();
                boolean z = !com.tencent.mm.kernel.a.Cx() && aq.hfP.H("login_user_name", "").equals("");
                if (z && f.xeC) {
                    return MMAppMgr.a(activity, new 1(this, runnable));
                }
                return false;
            }

            public final boolean b(Activity activity, Runnable runnable) {
                return this.fgc.c(activity, runnable);
            }

            public final boolean a(Activity activity, int i, String[] strArr, int[] iArr) {
                return this.fgc.a(activity, i, strArr, iArr);
            }
        });
        g.Dk().a(new 3(this, z, aVar));
        g.Dk().a(new 4(this));
    }
}
