package com.tencent.mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService$a;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.page.f.1;
import com.tencent.mm.plugin.appbrand.page.g;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import org.json.JSONObject;

public final class e {
    volatile boolean gSX;
    final Deque<Runnable> iqA = new LinkedBlockingDeque();
    public j iqB;
    public n iqC;
    public FrameLayout iqD;
    public l iqE;
    h iqF;
    public com.tencent.mm.plugin.appbrand.widget.c.e iqG;
    public AppBrandStatObject iqH;
    AppBrandRemoteTaskController iqI;
    private g iqJ;
    private f iqK;
    private b iqL;
    public g iqM;
    public k iqN;
    public volatile com.tencent.mm.plugin.appbrand.b.b iqO;
    public p iqP;
    private int iqQ = 0;
    private boolean iqR;
    boolean iqS;
    boolean iqT;
    public boolean iqU;
    private int iqV;
    boolean iqW;
    boolean iqX;
    boolean iqY;
    boolean iqZ;
    public MMActivity iqt;
    public o iqu;
    e iqv;
    public volatile AppBrandInitConfig iqw;
    public volatile AppBrandSysConfig iqx;
    public volatile a iqy;
    public volatile com.tencent.mm.plugin.appbrand.jsapi.file.a iqz;
    boolean ira;
    com.tencent.mm.plugin.appbrand.report.a.k irb;
    private AppBrandRemoteTaskController.b irc = new 8(this);
    private AppBrandMainProcessService$a ird = new 9(this);
    Runnable ire = new 10(this);
    public volatile String mAppId;
    public boolean mFinished;
    Handler mHandler;

    static /* synthetic */ void a(e eVar) {
        while (!eVar.iqA.isEmpty()) {
            eVar.iqt.runOnUiThread((Runnable) eVar.iqA.removeFirst());
        }
    }

    static /* synthetic */ void a(e eVar, JSONObject jSONObject) {
        if (eVar.iqu.YJ() == 1 && eVar.iqu.c(eVar)) {
            eVar.iqu.finish();
            return;
        }
        e Yu = eVar.Yu();
        if (eVar.iqv != null && eVar.iqv == Yu) {
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = eVar.mAppId;
            appBrandLaunchReferrer.iOd = 3;
            appBrandLaunchReferrer.iOe = jSONObject == null ? null : jSONObject.toString();
            Yu.iqw.iNZ.a(appBrandLaunchReferrer);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1038;
            appBrandStatObject.fnp = eVar.mAppId + ':' + eVar.iqw.irG;
            Yu.iqw.abT();
            Yu.a(appBrandStatObject);
        }
        Runnable 7 = new 7(eVar);
        e Yu2 = eVar.Yu();
        Object obj = (eVar.iqC == null || eVar.iqC.aiT() == null || !eVar.iqC.aiT().mSwiping) ? 1 : null;
        if (obj == null) {
            7.run();
        } else if (eVar != null) {
            com.tencent.mm.plugin.appbrand.ui.f.a(eVar, eVar.Yy() ? MMFragmentActivity.a.xKj : q$a.isn, 7);
            if (Yu2 != null) {
                com.tencent.mm.plugin.appbrand.ui.f.a(Yu2, eVar.Yy() ? MMFragmentActivity.a.xKi : q$a.bpQ, null);
            }
        }
        if (Yu2 != null) {
            Yu2.onResume();
        }
    }

    public e(MMActivity mMActivity, o oVar) {
        this.iqt = mMActivity;
        this.iqu = oVar;
        this.mHandler = new Handler();
        this.iqD = new com.tencent.mm.plugin.appbrand.widget.e(mMActivity);
        this.iqD.setLayoutParams(new LayoutParams(-1, -1));
        this.iqI = new AppBrandRemoteTaskController();
        AppBrandRemoteTaskController appBrandRemoteTaskController = this.iqI;
        c YK = oVar.YK();
        AppBrandRemoteTaskController.b bVar = this.irc;
        appBrandRemoteTaskController.jJE = mMActivity.getClass().getName();
        appBrandRemoteTaskController.irr = YK;
        appBrandRemoteTaskController.irc = bVar;
        this.iqJ = new g();
        this.iqK = new f();
        this.iqL = new b();
        this.iqM = new g();
        this.iqN = new k();
    }

    final void a(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig == null || appBrandStatObject == null) {
            x.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
            return;
        }
        this.iqw = appBrandInitConfig;
        this.iqH = appBrandStatObject;
        this.mAppId = appBrandInitConfig.appId;
        x.i("MicroMsg.AppBrandRuntime", "init %s, isGame %b, scene %d", this.mAppId, Boolean.valueOf(appBrandInitConfig.Yz()), Integer.valueOf(Yw()));
        this.iqO = new com.tencent.mm.plugin.appbrand.b.b(this);
        com.tencent.mm.plugin.appbrand.b.b bVar = this.iqO;
        com.tencent.mm.ipcinvoker.g.fi("com.tencent.mm");
        ac.getContext().registerComponentCallbacks(bVar.iGX);
        bVar.iGV.start();
        this.iqO.a(new 1(this));
        x.i("MicroMsg.AppBrandRuntime", "init %s, config %s, stat %s", this.mAppId, this.iqw, this.iqH);
        this.gSX = false;
        this.iqR = false;
        this.mFinished = false;
        this.iqS = false;
        this.iqT = false;
        this.iqU = false;
        this.iqW = false;
        this.iqX = false;
        this.iqZ = false;
        this.ira = false;
        this.iqY = false;
        this.iqV = 0;
        com.tencent.mm.pluginsdk.model.x.u(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY, this.iqw.appId);
        com.tencent.mm.pluginsdk.model.x.u(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY, this.iqw.frn);
        com.tencent.mm.pluginsdk.model.x.u(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, Boolean.valueOf(false));
        a.a(this.mAppId, this);
        a.a(this.mAppId, this.iqH);
        i.pi(this.mAppId);
        this.iqM.o(0, System.currentTimeMillis() - appBrandInitConfig.startTime);
        jr(1);
        com.tencent.mm.plugin.appbrand.performance.a.a(this.mAppId, "ActivityCreate", this.iqw.startTime, System.currentTimeMillis());
    }

    final void Yt() {
        this.irb = new com.tencent.mm.plugin.appbrand.report.a.k(this);
        this.irb.jIB = bh.Wp();
        if (this.iqE != null) {
            Yv();
        }
        String str = this.iqw.iconUrl;
        String str2 = this.iqw.frn;
        l b = l.a.b(this.iqt, this);
        b.bA(str, str2);
        if (Yw() == 1023) {
            b.akA();
        }
        this.iqD.addView(b.getView(), -1, -1);
        this.iqE = b;
        if (Yz()) {
            this.iqX = true;
        } else {
            com.tencent.mm.plugin.appbrand.task.c.a(new 13(this, System.currentTimeMillis()), false);
        }
        YB();
        AppBrandMainProcessService.a(new AppBrandMainProcessPrepareTask(new 16(this)));
        x.i("MicroMsg.AppBrandRuntime", "appOnCreate: %s, %s", this.iqw.frn, this.iqw.appId);
        AppBrandMainProcessService.a(this.ird);
        MainProcessTask mainProcessTask = this.iqI;
        String str3 = this.mAppId;
        mainProcessTask.jJF = AppBrandRemoteTaskController.a.jJT;
        mainProcessTask.mAppId = str3;
        AppBrandMainProcessService.a(mainProcessTask);
        this.iqI.aI(this.mAppId, this.iqw.iGA);
        this.iqO.iGV.jz(3);
        MMToClientEvent.sa(this.mAppId);
        c.pd(this.mAppId);
        c.oX(this.mAppId);
        c.a(this.mAppId, c$a.ON_CREATE);
        j.sf(this.mAppId);
        AppBrandStickyBannerLogic.a.Y(this.mAppId, this.iqw.iNX);
        b bVar = this.iqL;
        bVar.appId = this.mAppId;
        x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "init");
        av.a(bVar.jRM);
        com.tencent.mm.plugin.appbrand.media.a.onCreate();
        YC();
        this.mHandler.postDelayed(this.ire, 10000);
    }

    final void a(AppBrandStatObject appBrandStatObject) {
        AppBrandIDKeyBatchReport.ajG().jGT = 1;
        AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.ajG());
        if (appBrandStatObject == null) {
            x.e("MicroMsg.AppBrandRuntime", "statObject is null!");
            return;
        }
        a.a(this.iqw.appId, appBrandStatObject);
        h.e(this).irG = this.iqw.irG;
        if (this.iqC != null) {
            this.iqC.jDm.abT();
        }
        this.iqH = appBrandStatObject;
        x.i("MicroMsg.AppBrandRuntime", "updateStat %s, scene %d", this.mAppId, Integer.valueOf(Yw()));
    }

    public final e Yu() {
        return this.iqu.b(this);
    }

    public final void a(com.tencent.mm.plugin.appbrand.widget.c.h hVar) {
        if (ag.isMainThread()) {
            this.iqt.aWs();
            if (hVar != null && !this.mFinished && this.iqG != null) {
                ViewParent viewParent = this.iqG;
                com.tencent.mm.plugin.appbrand.widget.c.g gVar = viewParent.jWu;
                int i = (gVar.jWC == null || !gVar.jWC.isRunning()) ? 0 : 1;
                if (i != 0) {
                    gVar = viewParent.jWu;
                    if (gVar.jWC != null) {
                        gVar.jWC.cancel();
                    }
                }
                View contentView = hVar.getContentView();
                if (contentView.getParent() != viewParent) {
                    com.tencent.mm.plugin.appbrand.widget.c.e.bQ(contentView);
                    viewParent.addView(contentView, new FrameLayout.LayoutParams(-2, -2, 17));
                    if (viewParent.jWy != hVar) {
                        contentView.clearAnimation();
                        contentView.startAnimation(AnimationUtils.loadAnimation(viewParent.getContext(), q$a.isl));
                    }
                    viewParent.jWy = hVar;
                }
                contentView.setOnClickListener(viewParent.mOnClickListener);
                viewParent.jWv.add(hVar);
                hVar.a(viewParent);
                viewParent.setVisibility(0);
                viewParent.jWu.b(Color.argb(127, 0, 0, 0), null);
                return;
            }
            return;
        }
        ag.y(new 12(this, hVar));
    }

    final void Yv() {
        if (this.iqE == null) {
            x.e("MicroMsg.AppBrandRuntime", "hideSplash, splash view null");
            return;
        }
        com.tencent.mm.plugin.appbrand.page.l aiT = this.iqC.aiT();
        if (aiT == null) {
            x.e("MicroMsg.AppBrandRuntime", "hideSplash, null currentPage, appId %s", this.mAppId);
        } else {
            this.iqE.a(aiT.aiP());
        }
        this.iqE.akz();
        this.iqE = null;
    }

    public final int Yw() {
        if (this.iqH == null) {
            return 0;
        }
        return this.iqH.scene;
    }

    public final String Yx() {
        if (this.iqw == null) {
            return "";
        }
        if (!bh.ov(this.iqw.iNW)) {
            return this.iqw.iNW;
        }
        if (this.iqy == null) {
            return "";
        }
        return this.iqy.abM();
    }

    public final boolean Yy() {
        return this.iqw == null || this.iqw.iNR;
    }

    public final boolean Yz() {
        return this.iqw == null || this.iqw.Yz();
    }

    public final boolean YA() {
        return this.iqw != null && this.iqw.iNV && (this.iqH.scene == HardCoderJNI.FUNC_REG_PRELOAD_BOOT_RESOURCE || this.iqH.scene == HardCoderJNI.FUNC_TERMINATE_APP || this.iqH.scene == HardCoderJNI.FUNC_UNIFY_CPU_IO_THREAD_CORE);
    }

    final void YB() {
        if (com.tencent.mm.plugin.appbrand.task.c.akn() || Yz()) {
            final long currentTimeMillis = System.currentTimeMillis();
            AppBrandPrepareTask appBrandPrepareTask = new AppBrandPrepareTask(this.iqt, this);
            appBrandPrepareTask.jwW = new AppBrandPrepareTask.b(this) {
                final /* synthetic */ e irf;

                public final void b(AppBrandSysConfig appBrandSysConfig) {
                    x.i("MicroMsg.AppBrandRuntime", "AppBrandPrepareTask.onPrepareDone");
                    if (!this.irf.iqt.isFinishing()) {
                        if (appBrandSysConfig == null) {
                            this.irf.finish();
                            return;
                        }
                        ag.y(new 1(this));
                        this.irf.iqM.o(1, System.currentTimeMillis() - currentTimeMillis);
                        com.tencent.mm.plugin.appbrand.performance.a.a(this.irf.mAppId, "ResourcePrepare", currentTimeMillis, System.currentTimeMillis());
                        this.irf.iqx = appBrandSysConfig;
                        this.irf.iqy = a.m(this.irf);
                        this.irf.iqz = com.tencent.mm.plugin.appbrand.jsapi.file.a.p(this.irf);
                        x.d("MicroMsg.AppBrandRuntime", "AppBrandPrepareTask done. app-config parsed.");
                        this.irf.iqt.runOnUiThread(new 2(this));
                    }
                }

                public final void onDownloadStarted() {
                    this.irf.ira = true;
                    if (this.irf.irb != null) {
                        this.irf.irb.jIC = true;
                    }
                }

                public final void js(int i) {
                    x.i("MicroMsg.AppBrandRuntime", "onDownloadProgress %d", Integer.valueOf(i));
                    ag.y(new 3(this, i));
                }

                public final void a(com.tencent.mm.plugin.appbrand.jsapi.version.a aVar) {
                    e eVar = this.irf;
                    Runnable 4 = new 4(this, aVar);
                    if (eVar.gSX) {
                        eVar.iqt.runOnUiThread(4);
                    } else {
                        eVar.iqA.offerLast(4);
                    }
                }
            };
            appBrandPrepareTask.ahN();
            return;
        }
        com.tencent.mm.plugin.appbrand.task.c.a(new 14(this), false);
    }

    final void a(d.a aVar) {
        if (this.mFinished) {
            x.i("MicroMsg.AppBrandRuntime", "mFinished is true return,mAppId:%s", this.mAppId);
            return;
        }
        x.i("MicroMsg.AppBrandRuntime", "AppBrandRuntime.mayRequestOrientation %s,mAppId:%s", this.iqy.abL(), this.mAppId);
        com.tencent.mm.plugin.appbrand.config.d.e.abO().a(this.iqt, d.a(this.iqw, this.iqy), aVar);
    }

    final void YC() {
        x.i("MicroMsg.AppBrandRuntime", "initRuntime, mFinished: %b, ResourceReady: %b, WebViewReady: %b,isOrientationReady: %b, MainProcessReady: %b", Boolean.valueOf(this.mFinished), Boolean.valueOf(this.iqW), Boolean.valueOf(this.iqX), Boolean.valueOf(this.iqY), Boolean.valueOf(this.iqZ));
        if (this.mFinished || !this.iqW || !this.iqX || !this.iqY || !this.iqZ) {
            return;
        }
        if (this.gSX) {
            x.e("MicroMsg.AppBrandRuntime", "initRuntime, mInitialized TRUE !!!  go check callee");
            return;
        }
        final Runnable anonymousClass18 = new Runnable(this) {
            final /* synthetic */ e irf;

            {
                this.irf = r1;
            }

            public final void run() {
                boolean z;
                e eVar = this.irf;
                eVar.iqM.o(6, System.currentTimeMillis() - eVar.iqw.startTime);
                AppBrandStatObject appBrandStatObject = eVar.iqH;
                String str = eVar.iqw.iNW;
                eVar.a(appBrandStatObject);
                if (eVar.iqx == null || bh.cA(eVar.iqx.iOI.iGO)) {
                    z = false;
                } else {
                    z = true;
                }
                eVar.iqP = z ? new r(eVar) : new p.b();
                if (eVar.Yz()) {
                    eVar.iqB = new com.tencent.mm.plugin.appbrand.game.d();
                } else if (eVar.YA()) {
                    eVar.iqB = new m();
                } else {
                    eVar.iqB = com.tencent.mm.plugin.appbrand.task.c.ug(eVar.mAppId);
                    if (eVar.iqB == null) {
                        eVar.iqB = new j();
                    }
                }
                eVar.iqB.f(eVar);
                eVar.iqC = new n(eVar.iqt, eVar);
                eVar.iqC.jDo = new 2(eVar);
                eVar.iqD.addView(eVar.iqC, 0);
                FrameLayout frameLayout = eVar.iqD;
                View eVar2 = new com.tencent.mm.plugin.appbrand.widget.c.e(eVar.iqt);
                eVar.iqG = eVar2;
                frameLayout.addView(eVar2);
                n nVar = eVar.iqC;
                nVar.runOnUiThread(new n$1(nVar, eVar.iqw.iNW));
                eVar.iqM.o(8, System.currentTimeMillis() - eVar.iqw.startTime);
                eVar.iqB.init();
                eVar.a(eVar.iqx);
                eVar.jr(2);
                this.irf.gSX = true;
                e eVar3 = this.irf;
                eVar3.mHandler.removeCallbacks(eVar3.ire);
            }
        };
        int i = this.iqQ + 1;
        this.iqQ = i;
        if (i > 1) {
            anonymousClass18.run();
        } else {
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ e irf;

                public final boolean queueIdle() {
                    Looper.myQueue().removeIdleHandler(this);
                    anonymousClass18.run();
                    return false;
                }
            });
        }
    }

    public final void YD() {
        this.iqV++;
    }

    public final void YE() {
        if (this.iqV != 0) {
            this.iqV--;
        }
    }

    public final void onPause() {
        if (this.gSX) {
            x.i("MicroMsg.AppBrandRuntime", "onPause: %s", this.mAppId);
            this.iqR = true;
            this.iqO.iGV.jz(1);
            f fVar = this.iqK;
            Map hashMap = new HashMap(1);
            Object obj = "hide";
            switch (1.iHw[c.pe(this.mAppId).ordinal()]) {
                case 1:
                    obj = "close";
                    break;
                case 2:
                    obj = "back";
                    break;
                case 3:
                case 4:
                case 5:
                    obj = "hide";
                    break;
                case 6:
                    obj = "hang";
                    break;
                case 7:
                    obj = "launchMiniProgram";
                    break;
            }
            hashMap.put("mode", obj);
            fVar.v(hashMap).a(this.iqB).afs();
            n nVar = this.iqC;
            if (nVar.jDj.size() != 0) {
                ((com.tencent.mm.plugin.appbrand.page.l) nVar.jDj.getFirst()).aet();
                nVar.jDm.d(((com.tencent.mm.plugin.appbrand.page.l) nVar.jDj.getFirst()).aex());
            }
            c.oZ(this.mAppId);
            c.a(this.mAppId, c$a.ON_PAUSE);
            x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
            av.a(null);
        }
    }

    public final void onResume() {
        if (this.gSX) {
            x.i("MicroMsg.AppBrandRuntime", "onResume: %s", this.mAppId);
            if (this.mFinished || this.iqS) {
                reload();
                return;
            }
            String Yx;
            this.iqR = false;
            c.pd(this.mAppId);
            c.pa(this.mAppId);
            c.a(this.mAppId, c$a.ON_RESUME);
            MainProcessTask mainProcessTask = this.iqI;
            String str = this.mAppId;
            int i = this.iqw.iGA;
            mainProcessTask.jJF = AppBrandRemoteTaskController.a.jJM;
            mainProcessTask.mAppId = str;
            mainProcessTask.jxk = i;
            AppBrandMainProcessService.a(mainProcessTask);
            if (this.iqT) {
                this.iqC.jDm.jHn = true;
            }
            n nVar = this.iqC;
            if (nVar.jDj.size() != 0) {
                ((com.tencent.mm.plugin.appbrand.page.l) nVar.jDj.getFirst()).aes();
                nVar.jDm.e(((com.tencent.mm.plugin.appbrand.page.l) nVar.jDj.getFirst()).aex());
            }
            this.iqO.iGV.jz(3);
            this.iqB.onResume();
            g gVar = this.iqJ;
            boolean z = this.iqT;
            Map hashMap = new HashMap();
            AppBrandStatObject appBrandStatObject = this.iqH;
            if (appBrandStatObject != null) {
                hashMap.put("scene", Integer.valueOf(appBrandStatObject.scene));
            }
            JSONObject abW = this.iqw.iNZ.abW();
            if (abW != null) {
                hashMap.put("referrerInfo", abW);
            }
            abW = this.iqw.abU();
            if (abW != null) {
                hashMap.put("shareInfo", abW);
            }
            hashMap.put("relaunch", Boolean.valueOf(z));
            hashMap.put("reLaunch", Boolean.valueOf(z));
            if (z) {
                Yx = Yx();
                hashMap.put("path", com.tencent.mm.plugin.appbrand.p.l.uB(Yx));
                hashMap.put("query", com.tencent.mm.plugin.appbrand.p.l.uC(Yx));
            } else {
                Yx = this.iqC.aeq();
            }
            x.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", hashMap.get("path"), hashMap.get("query"), hashMap.get("relaunch"), Yx);
            com.tencent.mm.plugin.appbrand.q.c.m(hashMap);
            gVar.v(hashMap).a(this.iqB).afs();
            if (this.iqT) {
                if (Yz()) {
                    this.iqC.aiT().loadUrl(Yx());
                } else {
                    this.iqC.W(Yx(), true);
                }
            }
            AppBrandInitConfig appBrandInitConfig = this.iqw;
            if (!bh.ov(appBrandInitConfig.appId)) {
                AppBrandSysConfig oS = a.oS(appBrandInitConfig.appId);
                if (oS != null) {
                    AppBrandStatObject oT = a.oT(appBrandInitConfig.appId);
                    if (oT != null) {
                        x.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", appBrandInitConfig.appId, Integer.valueOf(appBrandInitConfig.iGA));
                        AppBrandMainProcessService.a(new UpdateTask(new AppBrandTaskUsageRecorder$LaunchCheckParams(appBrandInitConfig, oT, oS.iOI.iGL, v.ZP().iGL, h.ph(appBrandInitConfig.appId).irG)));
                    }
                }
            }
            b bVar = this.iqL;
            x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
            av.a(bVar.jRM);
            a(this.iqx);
            com.tencent.mm.plugin.appbrand.task.c.uf(this.mAppId);
            this.iqS = false;
            this.iqT = false;
            a(new 3(this));
        }
    }

    public final void cleanup() {
        if (!this.mFinished) {
            this.mFinished = true;
            x.i("MicroMsg.AppBrandRuntime", "onDestroy: %s", this.mAppId);
            String str = this.mAppId;
            if (DebuggerShell.acg()) {
                com.tencent.mm.plugin.appbrand.q.c.Dm().F(new 4(this, str));
            }
            MainProcessTask mainProcessTask = this.iqI;
            String str2 = this.mAppId;
            mainProcessTask.jJF = AppBrandRemoteTaskController.a.jJN;
            mainProcessTask.mAppId = str2;
            AppBrandMainProcessService.a(mainProcessTask);
            AppBrandMainProcessService.b(this.ird);
            MMToClientEvent.sb(this.mAppId);
            c.oY(this.mAppId);
            c.a(this.mAppId, c$a.ON_DESTROY);
            j.sg(this.mAppId);
            AppBrandStickyBannerLogic.a.uv(this.mAppId);
            a.oV(this.mAppId);
            AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.jzy;
            appBrandMusicClientService.jzx.clear();
            appBrandMusicClientService.jzz = "";
            com.tencent.mm.plugin.appbrand.media.a.onDestroy();
            this.iqt.aWs();
            com.tencent.mm.plugin.appbrand.b.b bVar = this.iqO;
            com.tencent.mm.plugin.appbrand.b.c cVar = bVar.iGV;
            cVar.iHf.set(true);
            cVar.quit();
            cVar.b(com.tencent.mm.plugin.appbrand.b.a.iGT);
            ac.getContext().unregisterComponentCallbacks(bVar.iGX);
            synchronized (bVar.iGW) {
                bVar.iGW.clear();
            }
            if (this.iqG != null) {
                this.iqD.removeView(this.iqG);
            }
            com.tencent.mm.plugin.appbrand.jsapi.file.a aVar = this.iqz;
            if (aVar != null) {
                aVar.release();
                this.iqz = null;
            }
            if (this.irb != null) {
                com.tencent.mm.plugin.appbrand.report.a.k kVar = this.irb;
                try {
                    i pl = i.pl(kVar.irF.mAppId);
                    kVar.jIa = com.tencent.mm.plugin.appbrand.report.a.ce(ac.getContext());
                    kVar.appId = kVar.irF.mAppId;
                    kVar.fIm = kVar.irF.iqx == null ? 0 : kVar.irF.iqx.iOI.iGL;
                    kVar.fno = kVar.irF.iqw.iGA + 1;
                    kVar.scene = kVar.irF.Yw();
                    kVar.jID = kVar.jIC ? 1 : 0;
                    kVar.jIE = pl.irK.get() ? 1 : 0;
                    kVar.jIF = bh.Wp() - kVar.jIB;
                    kVar.jIG = bh.Wp();
                    x.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + kVar.toString());
                    com.tencent.mm.plugin.report.d.pPH.h(14576, kVar.jIa, kVar.appId, Integer.valueOf(kVar.fIm), Integer.valueOf(kVar.fno), Integer.valueOf(kVar.scene), kVar.fqu, Integer.valueOf(kVar.jID), Integer.valueOf(kVar.jIE), Long.valueOf(kVar.jIF), Long.valueOf(kVar.jIG));
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", e);
                }
            }
            this.irb = null;
            c.pc(this.mAppId);
            if (this.iqB != null) {
                this.iqB.cleanup();
            }
            if (this.iqC != null) {
                this.iqC.cleanup();
                this.iqD.removeView(this.iqC);
            }
            a.a(this.mAppId, null);
            a.a(this.mAppId, null);
            i.remove(this.mAppId);
            this.iqA.clear();
            this.iqw.startTime = System.currentTimeMillis();
        }
    }

    public final void finish() {
        this.iqt.runOnUiThread(new 5(this));
    }

    final void reload() {
        cleanup();
        a(this.iqw, this.iqH);
        Yt();
        x.i("MicroMsg.AppBrandRuntime", "reload: %s", this.mAppId);
    }

    public final void close() {
        if (this.iqu.YJ() != 1) {
            finish();
        } else if (Yy()) {
            this.iqu.finish();
        } else {
            this.iqu.close();
        }
    }

    @TargetApi(21)
    final void a(AppBrandSysConfig appBrandSysConfig) {
        if (VERSION.SDK_INT >= 21 && !Yy()) {
            int aK = com.tencent.mm.plugin.appbrand.ui.j.aK(this.iqy.iMy.iMU, WebView.NIGHT_MODE_COLOR);
            this.iqt.setTaskDescription(new TaskDescription(appBrandSysConfig.frn, null, aK));
            com.tencent.mm.modelappbrand.a.b.Jj().a(new 11(this, appBrandSysConfig, aK), appBrandSysConfig.iOg, null);
        }
    }

    public final boolean YF() {
        if (!this.iqR || this.iqV != 0) {
            return false;
        }
        cleanup();
        return true;
    }

    final void jr(int i) {
        int i2 = 369;
        if (Yz()) {
            i2 = 777;
        }
        com.tencent.mm.plugin.report.service.g.pQN.a((long) i2, (long) i, 1, false);
    }
}
