package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public final class AnalyticsReceiver extends BroadcastReceiver {
    static Object aEw = new Object();
    static as aEx;
    static Boolean aEy;

    public static boolean y(Context context) {
        w.ag(context);
        if (aEy != null) {
            return aEy.booleanValue();
        }
        boolean a = k.a(context, AnalyticsReceiver.class, false);
        aEy = Boolean.valueOf(a);
        return a;
    }

    public final void onReceive(Context context, Intent intent) {
        f mS = q.A(context).mS();
        String action = intent.getAction();
        if (com.google.android.gms.common.internal.f.aNs) {
            mS.c("Device AnalyticsReceiver got", action);
        } else {
            mS.c("Local AnalyticsReceiver got", action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean z = AnalyticsService.z(context);
            Intent intent2 = new Intent(context, AnalyticsService.class);
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (aEw) {
                context.startService(intent2);
                if (z) {
                    try {
                        if (aEx == null) {
                            as asVar = new as(context, "Analytics WakeLock");
                            aEx = asVar;
                            asVar.pU();
                        }
                        aEx.pT();
                    } catch (SecurityException e) {
                        mS.ax("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
            }
        }
    }
}
