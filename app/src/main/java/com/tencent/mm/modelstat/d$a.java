package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class d$a implements ActivityLifecycleCallbacks {
    private int hQC;
    private int hQD;
    int hQE;
    int hQF;

    d$a() {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        d.a(d.SR(), 1, activity);
    }

    public final void onActivityStarted(Activity activity) {
        this.hQE++;
        x.i("MicroMsg.ClickFlowStatSender", "started[%d]", new Object[]{Integer.valueOf(this.hQE)});
        d.a(d.SR(), 2, activity);
    }

    public final void onActivityResumed(Activity activity) {
        this.hQC++;
        x.i("MicroMsg.ClickFlowStatSender", "resumed[%d]", new Object[]{Integer.valueOf(this.hQC)});
        d.a(d.SR(), 3, activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.hQD++;
        x.i("MicroMsg.ClickFlowStatSender", "paused[%d]", new Object[]{Integer.valueOf(this.hQD)});
        d.a(d.SR(), 4, activity);
        f SU = f.SU();
        if (activity != null && (activity instanceof MMActivity)) {
            SU.q(activity.getClass().getName(), ((MMActivity) activity).cmZ());
            x.v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", new Object[]{r1, Long.valueOf(r2), Integer.valueOf(SU.hRt.size())});
        }
    }

    public final void onActivityStopped(Activity activity) {
        this.hQF++;
        x.i("MicroMsg.ClickFlowStatSender", "stopped[%d]", new Object[]{Integer.valueOf(this.hQF)});
        d.a(d.SR(), 5, activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        d.a(d.SR(), 6, activity);
    }
}
