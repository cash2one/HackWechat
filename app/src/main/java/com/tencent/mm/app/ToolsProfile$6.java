package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.app.ToolsProfile.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;

class ToolsProfile$6 implements ActivityLifecycleCallbacks {
    final /* synthetic */ ToolsProfile ffM;
    private int ffN = 0;
    private Set<Activity> ffO = new HashSet();

    ToolsProfile$6(ToolsProfile toolsProfile) {
        this.ffM = toolsProfile;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.ffN++;
        this.ffO.add(activity);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.ffN--;
        x.d("MicroMsg.ToolsProfile", "onActivityDestroyed, after destroy, activityInstanceNum = %d", new Object[]{Integer.valueOf(this.ffN)});
        if (this.ffN == 0) {
            a.ua();
            x.i("MicroMsg.ToolsProfile", "onActivityDestroyed, xwebCanReboot = %b", new Object[]{Boolean.valueOf(WebView.getCanReboot())});
            if (WebView.getCanReboot()) {
                Process.killProcess(Process.myPid());
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        this.ffO.remove(activity);
        a.ub();
    }

    public final void onActivityResumed(Activity activity) {
        if (!this.ffO.contains(activity)) {
            a.uc();
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
