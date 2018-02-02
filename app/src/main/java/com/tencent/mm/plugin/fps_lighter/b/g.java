package com.tencent.mm.plugin.fps_lighter.b;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.plugin.fps_lighter.a.b;
import com.tencent.mm.plugin.fps_lighter.b.b.1;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.util.HashMap;
import java.util.Timer;

public final class g implements ap {
    private static af mBe;
    private static HandlerThread mBf = new HandlerThread("fps_thread");
    private d mBd = null;
    public b mBg;
    public e mBh;
    c<fo> mBi = new 1(this);
    c<ki> mBj = new 2(this);

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.SubCoreFPSLighter", "[onAccountRelease]");
        stop();
        this.mBi.dead();
        this.mBj.dead();
    }

    public static g aKO() {
        ar.Ha();
        g gVar = (g) bp.hY("plugin.fps_lighter");
        if (gVar != null) {
            return gVar;
        }
        x.e("MicroMsg.SubCoreFPSLighter", "not found in MMCore, new one");
        Object gVar2 = new g();
        ar.Ha().a("plugin.fps_lighter", gVar2);
        return gVar2;
    }

    public final void bq(boolean z) {
        this.mBi.ceO();
        this.mBj.ceO();
        try {
            start();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreFPSLighter", e, "", new Object[0]);
        }
    }

    public final void start() {
        if (VERSION.SDK_INT < 16) {
            x.w("MicroMsg.SubCoreFPSLighter", "[start] API is low 16");
            return;
        }
        ar.Hg();
        if (!com.tencent.mm.z.c.CU().getBoolean(a.xuq, true)) {
            x.w("MicroMsg.SubCoreFPSLighter", "[start] isValid:%s", new Object[]{Boolean.valueOf(com.tencent.mm.z.c.CU().getBoolean(a.xuq, true))});
        } else if (!e.xew) {
            x.w("MicroMsg.SubCoreFPSLighter", "[start] never open gmtrace when build");
        } else if (com.tencent.mm.protocal.d.vAC) {
            ar.Hg();
            if (com.tencent.mm.z.c.Cg() != 0) {
                x.i("MicroMsg.SubCoreFPSLighter", "[start]");
                final c cVar = new c();
                com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100166");
                if (fn.isValid() && fn.chI().containsKey("percent")) {
                    x.i("MicroMsg.SubCoreFPSLighter", "[start] :%s", new Object[]{Integer.valueOf(bh.getInt((String) fn.chI().get("percent"), 100))});
                    cVar.mAP = r0;
                } else {
                    x.w("MicroMsg.SubCoreFPSLighter", "[start] never has abtest:100166");
                    cVar.mAP = 100;
                }
                if (cVar.mAP > 0) {
                    x.i("MicroMsg.SubCoreFPSLighter", "it real open rand:%s", new Object[]{Integer.valueOf(cVar.mAP)});
                    cVar.mAJ = true;
                    cVar.mAI = true;
                    GMTrace.init(true);
                    if (this.mBh == null) {
                        this.mBh = new e(cVar);
                    }
                    GMTrace.registerHandler(this.mBh);
                    if (this.mBg == null) {
                        this.mBg = new b();
                    }
                    b bVar = this.mBg;
                    if (!bVar.isInit) {
                        bVar.isInit = true;
                        bVar.jwk = new Timer();
                        bVar.jwk.scheduleAtFixedRate(new 1(bVar), 3600000, 3600000);
                    }
                    if (mBf == null || !mBf.isAlive()) {
                        HandlerThread handlerThread = new HandlerThread("analyse_thread");
                        mBf = handlerThread;
                        handlerThread.setPriority(1);
                        mBf.start();
                        mBe = new af(mBf.getLooper());
                    }
                    new af(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ g mBk;

                        public final void run() {
                            if (this.mBk.mBd == null) {
                                this.mBk.mBd = new d(cVar);
                            }
                            d a = this.mBk.mBd;
                            Context context = ac.getContext();
                            x.i("MicroMsg.FPSFinder", "[start]");
                            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                            a.mAl.mAF = 1000.0f / defaultDisplay.getRefreshRate();
                            a.mAl.mAE = defaultDisplay.getRefreshRate();
                            x.i("MicroMsg.FPSFinder", "refreshRate %s", new Object[]{Float.valueOf(a.mAl.mAE)});
                            a.mAQ = new f(a.mAl);
                            if (a.mAl.mAJ) {
                                a.mAQ.a(new com.tencent.mm.plugin.fps_lighter.a.a(a.mAl));
                            }
                            if (a.mAl.mAI) {
                                a.mAQ.a(new b(a.mAl));
                            }
                            a.mAQ.b((Application) context.getApplicationContext());
                        }
                    });
                    return;
                }
                x.i("MicroMsg.SubCoreFPSLighter", "[start] is disable!");
            }
        } else {
            x.w("MicroMsg.SubCoreFPSLighter", "is not alpha version");
        }
    }

    public final void stop() {
        if (VERSION.SDK_INT >= 16) {
            x.i("MicroMsg.SubCoreFPSLighter", "[stop]");
            if (this.mBd != null) {
                d dVar = this.mBd;
                Context context = ac.getContext();
                x.i("MicroMsg.FPSFinder", "[stop]");
                if (dVar.mAQ != null) {
                    dVar.mAQ.c((Application) context.getApplicationContext());
                }
                if (dVar.mAl.mAJ) {
                    aKO().mBh.stopTrace();
                }
            }
            if (this.mBg != null) {
                b bVar = this.mBg;
                x.i("MicroMsg.FPSAnalyser", "[stop]");
                bVar.isInit = false;
                bVar.jwk.cancel();
            }
            if (mBf != null) {
                mBf.quit();
                mBf = null;
            }
            if (this.mBh != null) {
                this.mBh.stopTrace();
                GMTrace.unregisterHandler(this.mBh);
            }
        }
    }

    public static af VO() {
        return mBe;
    }
}
