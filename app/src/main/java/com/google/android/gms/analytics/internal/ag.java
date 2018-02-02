package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.common.internal.w;

public final class ag extends o {
    boolean aHp;
    boolean aHq;
    private AlarmManager aHr = ((AlarmManager) this.aFo.mContext.getSystemService("alarm"));

    protected ag(q qVar) {
        super(qVar);
    }

    private PendingIntent nJ() {
        Intent intent = new Intent(this.aFo.mContext, AnalyticsReceiver.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(this.aFo.mContext, 0, intent, 0);
    }

    public final void cancel() {
        mQ();
        this.aHq = false;
        this.aHr.cancel(nJ());
    }

    protected final void mf() {
        try {
            this.aHr.cancel(nJ());
            if (ac.ny() > 0) {
                ActivityInfo receiverInfo = this.aFo.mContext.getPackageManager().getReceiverInfo(new ComponentName(this.aFo.mContext, AnalyticsReceiver.class), 2);
                if (receiverInfo != null && receiverInfo.enabled) {
                    au("Receiver registered. Using alarm for local dispatch.");
                    this.aHp = true;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    public final void nI() {
        mQ();
        w.d(this.aHp, "Receiver not registered");
        long ny = ac.ny();
        if (ny > 0) {
            cancel();
            long elapsedRealtime = this.aFo.aFD.elapsedRealtime() + ny;
            this.aHq = true;
            this.aHr.setInexactRepeating(2, elapsedRealtime, 0, nJ());
        }
    }
}
