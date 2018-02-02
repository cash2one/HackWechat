package com.tencent.mm.plugin.appbrand.launching;

import android.os.Process;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.3;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.4;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareResult;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

class AppBrandPrepareTask$2 implements i<PrepareResult> {
    final /* synthetic */ AppBrandPrepareTask jwZ;

    AppBrandPrepareTask$2(AppBrandPrepareTask appBrandPrepareTask) {
        this.jwZ = appBrandPrepareTask;
    }

    public final /* synthetic */ void as(Object obj) {
        PrepareResult prepareResult = (PrepareResult) obj;
        AppBrandPrepareTask appBrandPrepareTask = this.jwZ;
        x.i("MicroMsg.AppBrandPrepareTask", "[applaunch] runInClientProcess, event = %d, %s %d", new Object[]{Integer.valueOf(PrepareResult.a(prepareResult)), PrepareParams.a(appBrandPrepareTask.jwV), Integer.valueOf(PrepareParams.b(appBrandPrepareTask.jwV))});
        switch (PrepareResult.a(prepareResult)) {
            case 1:
                if (appBrandPrepareTask.jwW != null) {
                    appBrandPrepareTask.jwW.onDownloadStarted();
                    return;
                }
                return;
            case 2:
                if (PrepareResult.b(prepareResult) == null && PrepareResult.c(prepareResult) == null) {
                    c.Dm().F(new 3(appBrandPrepareTask));
                }
                if (appBrandPrepareTask.jwW != null) {
                    if (PrepareResult.b(prepareResult) != null) {
                        c.Dm().F(new 4(appBrandPrepareTask, PrepareResult.b(prepareResult).iOI));
                        if (PrepareResult.b(prepareResult).iOL != null) {
                            com.tencent.mm.plugin.appbrand.i.pm(PrepareResult.b(prepareResult).appId).irM = PrepareResult.b(prepareResult).iOL;
                        }
                    } else {
                        x.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, config null");
                        if (!(PrepareResult.c(prepareResult) == null || appBrandPrepareTask.jwX == null || ((MMActivity) appBrandPrepareTask.jwX.get()) == null)) {
                            PrepareResult.c(prepareResult).ca(ac.getContext());
                        }
                    }
                    appBrandPrepareTask.jwW.b(PrepareResult.b(prepareResult));
                } else {
                    x.e("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, but callback is null");
                }
                c.bk(appBrandPrepareTask);
                return;
            case 3:
                WeakReference weakReference = appBrandPrepareTask.jwX;
                MMActivity mMActivity = weakReference == null ? null : (MMActivity) weakReference.get();
                if (mMActivity != null) {
                    mMActivity.finish();
                    mMActivity.overridePendingTransition(0, 0);
                }
                Process.killProcess(Process.myPid());
                return;
            case 4:
                if (appBrandPrepareTask.jwW != null) {
                    appBrandPrepareTask.jwW.js(PrepareResult.d(prepareResult));
                    return;
                }
                return;
            case 5:
                if (appBrandPrepareTask.jwW != null) {
                    appBrandPrepareTask.jwW.a(PrepareResult.e(prepareResult));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
