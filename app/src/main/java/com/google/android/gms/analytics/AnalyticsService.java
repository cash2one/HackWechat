package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public final class AnalyticsService extends Service {
    private static Boolean aEz;
    private final Handler mHandler = new Handler();

    public static boolean z(Context context) {
        w.ag(context);
        if (aEz != null) {
            return aEz.booleanValue();
        }
        boolean a = k.a(context, AnalyticsService.class);
        aEz = Boolean.valueOf(a);
        return a;
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        f mS = q.A(this).mS();
        if (com.google.android.gms.common.internal.f.aNs) {
            mS.au("Device AnalyticsService is starting up");
        } else {
            mS.au("Local AnalyticsService is starting up");
        }
    }

    public final void onDestroy() {
        f mS = q.A(this).mS();
        if (com.google.android.gms.common.internal.f.aNs) {
            mS.au("Device AnalyticsService is shutting down");
        } else {
            mS.au("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            synchronized (AnalyticsReceiver.aEw) {
                as asVar = AnalyticsReceiver.aEx;
                if (asVar != null && asVar.aZf.isHeld()) {
                    asVar.release();
                }
            }
        } catch (SecurityException e) {
        }
        q A = q.A(this);
        f mS = A.mS();
        String action = intent.getAction();
        if (com.google.android.gms.common.internal.f.aNs) {
            mS.a("Device AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        } else {
            mS.a("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            A.mU().a(new 1(this, i2, A, mS));
        }
        return 2;
    }
}
