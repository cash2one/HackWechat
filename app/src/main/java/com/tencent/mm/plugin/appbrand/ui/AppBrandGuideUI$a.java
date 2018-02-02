package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;

public final class AppBrandGuideUI$a implements ActivityLifecycleCallbacks, f {
    public boolean jKH = false;
    public String jKI;

    public static Application akB() {
        return (Application) ac.getContext().getApplicationContext();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof AppBrandGuideUI) {
            this.jKH = false;
        }
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        if ((activity instanceof AppBrandGuideUI) || (activity instanceof AppBrandLauncherUI)) {
            this.jKH = false;
        }
        if (g.Dh().Cy() && this.jKH) {
            RunningTaskInfo ah = bh.ah(activity, activity.getTaskId());
            boolean z = (ah == null || ah.baseActivity == null) ? false : ah.baseActivity.getClassName().endsWith(".LauncherUI") || !ah.baseActivity.getClassName().contains(".AppBrandUI");
            if (z) {
                this.jKH = false;
                activity.startActivity(new Intent(activity, AppBrandGuideUI.class));
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void ak(String str, int i) {
        this.jKH = false;
    }
}
