package com.tencent.mm.plugin.appbrand.ui;

import android.app.ActivityManager.TaskDescription;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.d.b;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;
import com.tencent.mm.plugin.appbrand.widget.c.h;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(1)
public class AppBrandUI extends MMActivity implements android.support.v4.app.a.a, m {
    private static HashSet<MMActivity> jMM = new HashSet();
    private c irr = new 3(this);
    private final com.tencent.mm.plugin.appbrand.widget.input.a jMI = new com.tencent.mm.plugin.appbrand.widget.input.a(this);
    private f jMJ;
    private i jMK;
    private d jML;
    private Intent jMN = null;
    public boolean jMO = false;
    private Boolean jMP;
    private i jMQ = null;

    static /* synthetic */ void a(AppBrandUI appBrandUI, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        if (appBrandUI.jMQ == null || !appBrandUI.jMQ.isShowing()) {
            i.a aVar = new a(appBrandUI.mController.xIM);
            aVar.Ez(j.dGO);
            aVar.EA(j.iyo);
            aVar.mi(false);
            aVar.EC(j.iyK).a(new 4(appBrandUI, appBrandRemoteTaskController));
            appBrandUI.jMQ = aVar.akx();
            appBrandUI.jMQ.show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.AppBrandUI", "onCreate");
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "pref_appbrand_process", 4);
        String str = ac.Br() + ":start_time";
        Editor edit = sharedPreferences.edit();
        if (sharedPreferences.contains(str)) {
            edit.remove(str);
            com.tencent.mm.plugin.report.d.pPH.a(365, 2, 1, false);
        }
        com.tencent.mm.plugin.report.d.pPH.a(365, 4, 1, false);
        edit.putLong(str, System.currentTimeMillis());
        edit.commit();
        x.v("MicroMsg.AppBrandReporter", "onProcessStart");
        KVCommCrossProcessReceiver.boe();
        View frameLayout = new FrameLayout(this.mController.xIM);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(frameLayout);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.jMI;
        if (!(aVar.activity == null || aVar.activity.getWindow() == null || frameLayout.getParent() == null || !(frameLayout.getParent() instanceof ViewGroup))) {
            aVar.jWE = true;
            ViewGroup viewGroup = (ViewGroup) frameLayout.getParent();
            viewGroup.removeView(frameLayout);
            Context context = aVar.activity;
            aVar.activity.getWindow().getDecorView();
            View lVar = new l(context, frameLayout);
            viewGroup.addView(lVar, new LayoutParams(-1, -1));
            if (VERSION.SDK_INT < 20) {
                af.a.a(aVar.activity, viewGroup);
                aVar.a(lVar);
            }
        }
        this.jMJ = new f(this, this.irr, frameLayout);
        this.jMK = new i(this, this.jMJ);
        e eVar = this.jMK;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        try {
            ac.getContext().registerReceiver(eVar.iHp, intentFilter);
        } catch (Exception e) {
            x.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "register screen off receiver e = " + e);
        }
        this.jML = new 1(this, this);
        d dVar = this.jML;
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        try {
            ac.getContext().registerReceiver(dVar.tP, intentFilter);
        } catch (Exception e2) {
            x.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "register screen off receiver e = " + e2);
        }
        jMM.add(this);
        com.tencent.mm.plugin.appbrand.config.d abO = com.tencent.mm.plugin.appbrand.config.d.e.abO();
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
        synchronized (abO) {
            abO.mFinished = false;
        }
        com.tencent.mm.plugin.appbrand.q.a.a.jSv.init(this);
        this.jMN = getIntent();
    }

    public void onNewIntent(Intent intent) {
        if (intent == null || !intent.getBooleanExtra("key_appbrand_bring_ui_to_front", false)) {
            x.i("MicroMsg.AppBrandUI", "onNewIntent");
            this.jMN = intent;
            this.jMO = true;
        } else if (this.jMJ == null || this.jMJ.irp.size() == 0) {
            finish();
        }
    }

    protected final void afg() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConfigurationChanged(Configuration configuration) {
        x.i("MicroMsg.AppBrandUI", "onConfigurationChanged newConfig: %s", new Object[]{Integer.valueOf(configuration.orientation)});
        super.onConfigurationChanged(configuration);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.jMI;
        if (configuration != null) {
            x.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityConfigurationChanged, orientation %d", new Object[]{Integer.valueOf(configuration.orientation)});
            aVar.amu();
        }
        f fVar = this.jMJ;
        x.d("MicroMsg.AppBrandRuntimeContainer", "AppBrandRuntimeContainer.onConfigurationChanged newConfig [%d]", new Object[]{Integer.valueOf(configuration.orientation)});
        if (fVar.irp != null) {
            Iterator it = fVar.irp.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        com.tencent.mm.plugin.appbrand.config.d abO = com.tencent.mm.plugin.appbrand.config.d.e.abO();
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler.onConfigurationChanged");
        if (this == null || configuration == null) {
            boolean z;
            String str = "MicroMsg.AppBrandDeviceOrientationHandler";
            Throwable runtimeException = new RuntimeException();
            String str2 = "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]";
            Object[] objArr = new Object[2];
            if (this == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Boolean.valueOf(configuration == null);
            x.printErrStackTrace(str, runtimeException, str2, objArr);
        }
        List linkedList = new LinkedList();
        synchronized (abO) {
            if (abO.mFinished) {
                x.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged Finished = true");
            } else if (abO.iNc == null) {
                x.d("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
            } else {
                b b = com.tencent.mm.plugin.appbrand.config.d.b(configuration);
                str = "MicroMsg.AppBrandDeviceOrientationHandler";
                str2 = "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]";
                objArr = new Object[1];
                objArr[0] = b == null ? "null" : b.name();
                x.i(str, str2, objArr);
                if (abO.iNc.iNi != null) {
                    linkedList.add(new d$c(abO.iNc.iNi, b, b == abO.iNc.iNj, "CurrentRequest.listener result received"));
                }
                abO.iNc = null;
                if (abO.iNd != null) {
                    if (b == abO.iNd.iNj) {
                        if (abO.iNd.iNi != null) {
                            linkedList.add(new d$c(abO.iNd.iNi, b, true, "PendingRequest.Listener orientation equal direct"));
                        }
                        abO.iNd = null;
                    } else if (this == null) {
                        x.e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
                        if (abO.iNd.iNi != null) {
                            linkedList.add(new d$c(abO.iNd.iNi, b, false, "PendingRequest.Listener activity == null"));
                        }
                    } else {
                        abO.iNc = abO.iNd;
                        abO.iNd = null;
                        com.tencent.mm.plugin.appbrand.config.d.a(this, abO.iNc);
                    }
                }
            }
        }
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.jMI;
        if (layoutParams != null) {
            x.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityWindowAttributesChanged, oldFlags %d, newFlags %d", new Object[]{Integer.valueOf(aVar.jWF), Integer.valueOf(layoutParams.flags)});
            if (layoutParams.flags != aVar.jWF) {
                aVar.jWF = layoutParams.flags;
                aVar.amu();
            }
        }
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        Object obj = 1;
        Object obj2 = (intent == null || (intent.getFlags() & SQLiteDatabase.CREATE_IF_NECESSARY) <= 0) ? null : 1;
        if (intent == null || !com.tencent.mm.plugin.appbrand.q.c.b(intent.getComponent()).equals(com.tencent.mm.plugin.appbrand.q.c.b(getComponentName()))) {
            obj = null;
        }
        boolean u = AppBrandProcessProxyUI.u(intent);
        boolean v = AppBrandLaunchProxyUI.v(intent);
        if (this.jMJ.YI() != null) {
            String str = this.jMJ.YI().mAppId;
            if (v) {
                com.tencent.mm.plugin.appbrand.c.a(str, com.tencent.mm.plugin.appbrand.c.c.iqp);
            } else if ((obj2 == null || r0 != null || u) && com.tencent.mm.plugin.appbrand.c.c.iql == com.tencent.mm.plugin.appbrand.c.pe(str)) {
                com.tencent.mm.plugin.appbrand.c.a(str, com.tencent.mm.plugin.appbrand.c.c.iqo);
            }
        }
        try {
            this.jMJ.YI().iqC.jDm.jHm = intent;
        } catch (Exception e) {
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void onStart() {
        super.onStart();
        x.i("MicroMsg.AppBrandUI", "onStart");
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        x.i("MicroMsg.AppBrandUI", "onWindowFocusChanged %b", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            this.jMO = false;
        }
    }

    public void onResume() {
        Exception exception;
        Object obj;
        com.tencent.mm.plugin.appbrand.e eVar;
        com.tencent.mm.plugin.appbrand.e YI;
        super.onResume();
        x.i("MicroMsg.AppBrandUI", "onResume");
        if (this.jMN != null) {
            setIntent(this.jMN);
            Bundle extras = this.jMN.getExtras();
            if (extras == null) {
                finish();
            } else {
                AppBrandInitConfig appBrandInitConfig;
                AppBrandStatObject appBrandStatObject;
                try {
                    extras.setClassLoader(AppBrandInitConfig.class.getClassLoader());
                    appBrandInitConfig = (AppBrandInitConfig) extras.getParcelable("key_appbrand_init_config");
                    try {
                        appBrandStatObject = (AppBrandStatObject) extras.getParcelable("key_appbrand_stat_object");
                    } catch (Exception e) {
                        Exception exception2 = e;
                        Object obj2 = appBrandInitConfig;
                        exception = exception2;
                        x.e("MicroMsg.AppBrandUI", "getParcelable: %s", new Object[]{exception});
                        obj = eVar;
                        appBrandStatObject = null;
                        if (appBrandInitConfig == null) {
                        }
                        finish();
                        this.jMN = null;
                        YI = this.jMJ.YI();
                        if (YI != null) {
                            YI.onResume();
                        }
                        com.tencent.mm.modelstat.d.b(3, "AppBrandUI_" + this.jMJ.YI().mAppId, hashCode());
                    }
                } catch (Exception e2) {
                    exception = e2;
                    eVar = null;
                    x.e("MicroMsg.AppBrandUI", "getParcelable: %s", new Object[]{exception});
                    obj = eVar;
                    appBrandStatObject = null;
                    if (appBrandInitConfig == null) {
                    }
                    finish();
                    this.jMN = null;
                    YI = this.jMJ.YI();
                    if (YI != null) {
                        YI.onResume();
                    }
                    com.tencent.mm.modelstat.d.b(3, "AppBrandUI_" + this.jMJ.YI().mAppId, hashCode());
                }
                if (appBrandInitConfig == null && appBrandStatObject != null) {
                    if (!bh.ov(appBrandInitConfig.iNT)) {
                        com.tencent.mm.plugin.appbrand.config.d.e.abO().a(this, com.tencent.mm.plugin.appbrand.config.d.a(appBrandInitConfig, null), new 2(this));
                    }
                    x.i("MicroMsg.AppBrandUI", "load() config %s , stat %s", new Object[]{appBrandInitConfig, appBrandStatObject});
                    if (appBrandInitConfig.Yz()) {
                        com.tencent.mm.plugin.appbrand.app.b.YZ();
                    }
                    this.jMJ.a(null, appBrandInitConfig, appBrandStatObject);
                    initActivityOpenAnimation(getIntent());
                } else if (this.jMJ == null || this.jMJ.YI() == null) {
                    finish();
                }
            }
            this.jMN = null;
        }
        YI = this.jMJ.YI();
        if (YI != null) {
            YI.onResume();
        }
        try {
            com.tencent.mm.modelstat.d.b(3, "AppBrandUI_" + this.jMJ.YI().mAppId, hashCode());
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.AppBrandUI", th, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.AppBrandUI", "onPause");
        com.tencent.mm.plugin.appbrand.e YI = this.jMJ.YI();
        if (YI != null) {
            YI.onPause();
        }
        try {
            com.tencent.mm.modelstat.d.b(4, "AppBrandUI_" + this.jMJ.YI().mAppId, hashCode());
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.AppBrandUI", th, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
    }

    protected void initActivityOpenAnimation(Intent intent) {
        AppBrandStatObject appBrandStatObject;
        try {
            appBrandStatObject = (AppBrandStatObject) (intent == null ? null : intent.getParcelableExtra("key_appbrand_stat_object"));
        } catch (Exception e) {
            appBrandStatObject = null;
        }
        if (appBrandStatObject != null) {
            f.a(this, appBrandStatObject);
        } else if (!AppBrandLaunchProxyUI.v(intent)) {
            super.initActivityOpenAnimation(intent);
        }
    }

    protected void initActivityCloseAnimation() {
        if (this != null) {
            overridePendingTransition(q.a.ism, q.a.isn);
        }
    }

    public void finish() {
        if (!isFinishing() && !this.xIq) {
            if (VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            initActivityCloseAnimation();
            int cgD = bh.cgD();
            x.i("MicroMsg.AppBrandReporterManager", "report now process mem : %d", new Object[]{Integer.valueOf(bh.cgD())});
            cgD = cgD <= 90 ? 2 : cgD <= 130 ? 3 : cgD <= 170 ? 4 : cgD <= com.tencent.mm.plugin.appbrand.jsapi.share.i.CTRL_INDEX ? 5 : 6;
            g.pQN.a(386, 1, 1, false);
            g.pQN.a(386, (long) cgD, 1, false);
        }
    }

    public boolean moveTaskToBack(boolean z) {
        try {
            boolean moveTaskToBack = super.moveTaskToBack(z);
            initActivityCloseAnimation();
            return moveTaskToBack;
        } catch (NullPointerException e) {
            jMM.remove(this);
            if (!akC()) {
                finish();
            }
            return true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.AppBrandUI", "onDestroy");
        this.jMJ.cleanup();
        jMM.remove(this);
        if (this.jML != null) {
            try {
                ac.getContext().unregisterReceiver(this.jML.tP);
            } catch (Exception e) {
                x.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "unregister screen off receiver e = " + e);
            }
        }
        if (this.jMK != null) {
            try {
                ac.getContext().unregisterReceiver(this.jMK.iHp);
            } catch (Exception e2) {
                x.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "unregister screen off receiver e = " + e2);
            }
        }
        akC();
        com.tencent.mm.plugin.appbrand.config.d abO = com.tencent.mm.plugin.appbrand.config.d.e.abO();
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "release");
        synchronized (abO) {
            if (abO.iNc == null && abO.iNd == null) {
                x.i("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
            } else {
                x.i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", new Object[]{abO.iNc, abO.iNd});
                abO.iNc = null;
                abO.iNd = null;
                abO.mFinished = true;
            }
        }
        com.tencent.mm.plugin.appbrand.q.a.a.jSv.release();
    }

    public void onBackPressed() {
        com.tencent.mm.plugin.appbrand.e YI = this.jMJ.YI();
        if (YI == null) {
            return;
        }
        if (YI.iqE == null) {
            if (YI.iqG != null) {
                Object obj;
                com.tencent.mm.plugin.appbrand.widget.c.e eVar = YI.iqG;
                h hVar = (h) eVar.jWv.peekLast();
                if (hVar == null) {
                    eVar.setVisibility(8);
                    obj = null;
                } else {
                    hVar.onCancel();
                    eVar.b(hVar);
                    obj = 1;
                }
                if (obj != null) {
                    return;
                }
            }
            if (YI.iqC != null) {
                n nVar = YI.iqC;
                if (!nVar.aiT().aex().aeG()) {
                    nVar.aiS();
                    return;
                }
                return;
            }
            return;
        }
        YI.finish();
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.jMI;
        if (aVar.activity != null && aVar.activity.getWindow() != null) {
            aVar.activity.getWindow().setSoftInputMode(16);
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final boolean needShowIdcError() {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.plugin.appbrand.e YI = this.jMJ.YI();
        if (YI != null) {
            com.tencent.mm.plugin.appbrand.a.a(YI.mAppId, i, strArr, iArr);
        }
    }

    public final boolean akR() {
        boolean z = true;
        if (this.jMP != null) {
            return this.jMP.booleanValue();
        }
        ActivityInfo activityInfo;
        try {
            activityInfo = ac.getContext().getPackageManager().getActivityInfo(getComponentName(), FileUtils.S_IWUSR);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandUI", "runInStandaloneTask, resolve info e = %s", new Object[]{e});
            activityInfo = null;
        }
        if (activityInfo == null) {
            return true;
        }
        if (ac.getPackageName().equals(activityInfo.taskAffinity)) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        this.jMP = valueOf;
        return valueOf.booleanValue();
    }

    public void setTaskDescription(TaskDescription taskDescription) {
        if (akR()) {
            super.setTaskDescription(taskDescription);
        }
    }

    protected boolean akC() {
        Runnable 5 = new 5(this);
        if (!jMM.isEmpty()) {
            x.i("MicroMsg.AppBrandUI", "Activity running");
            com.tencent.mm.bz.a.post(5);
            return false;
        } else if (DebuggerShell.acg()) {
            return false;
        } else {
            com.tencent.mm.bz.a.post(new 6(this, 5));
            return true;
        }
    }
}
