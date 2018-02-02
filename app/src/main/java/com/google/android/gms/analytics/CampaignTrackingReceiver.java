package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public class CampaignTrackingReceiver extends BroadcastReceiver {
    static Object aEw = new Object();
    static as aEx;
    static Boolean aEy;

    public static boolean y(Context context) {
        w.ag(context);
        if (aEy != null) {
            return aEy.booleanValue();
        }
        boolean a = k.a(context, CampaignTrackingReceiver.class, true);
        aEy = Boolean.valueOf(a);
        return a;
    }

    public void am(String str) {
    }

    public Class<? extends CampaignTrackingService> md() {
        return CampaignTrackingService.class;
    }

    public void onReceive(Context context, Intent intent) {
        f mS = q.A(context).mS();
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        mS.c("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            mS.ax("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean z = CampaignTrackingService.z(context);
        if (!z) {
            mS.ax("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        am(stringExtra);
        if (com.google.android.gms.common.internal.f.aNs) {
            mS.ay("Received unexpected installation campaign on package side");
            return;
        }
        Class md = md();
        w.ag(md);
        Intent intent2 = new Intent(context, md);
        intent2.putExtra("referrer", stringExtra);
        synchronized (aEw) {
            context.startService(intent2);
            if (z) {
                try {
                    if (aEx == null) {
                        as asVar = new as(context, "Analytics campaign WakeLock");
                        aEx = asVar;
                        asVar.pU();
                    }
                    aEx.pT();
                } catch (SecurityException e) {
                    mS.ax("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
                return;
            }
        }
    }
}
