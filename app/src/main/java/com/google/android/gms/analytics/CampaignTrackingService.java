package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.ac;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.m.2;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public class CampaignTrackingService extends Service {
    private static Boolean aEz;
    private Handler mHandler;

    public static boolean z(Context context) {
        w.ag(context);
        if (aEz != null) {
            return aEz.booleanValue();
        }
        boolean a = k.a(context, CampaignTrackingService.class);
        aEz = Boolean.valueOf(a);
        return a;
    }

    protected final void a(final f fVar, Handler handler, final int i) {
        handler.post(new Runnable(this) {
            final /* synthetic */ CampaignTrackingService aEG;

            public final void run() {
                boolean stopSelfResult = this.aEG.stopSelfResult(i);
                if (stopSelfResult) {
                    fVar.c("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
                }
            }
        });
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        q.A(this).mS().au("CampaignTrackingService is starting up");
    }

    public void onDestroy() {
        q.A(this).mS().au("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            synchronized (CampaignTrackingReceiver.aEw) {
                as asVar = CampaignTrackingReceiver.aEx;
                if (asVar != null && asVar.aZf.isHeld()) {
                    asVar.release();
                }
            }
        } catch (SecurityException e) {
        }
        q A = q.A(this);
        f mS = A.mS();
        String str = null;
        if (com.google.android.gms.common.internal.f.aNs) {
            mS.ay("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            handler = new Handler(getMainLooper());
            this.mHandler = handler;
        }
        if (TextUtils.isEmpty(str)) {
            if (!com.google.android.gms.common.internal.f.aNs) {
                mS.ax("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            A.mT().d(new 1(this, mS, handler, i2));
        } else {
            int nw = ac.nw();
            if (str.length() > nw) {
                mS.c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(nw));
                str = str.substring(0, nw);
            }
            mS.a("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), str);
            n mU = A.mU();
            Runnable 2 = new 2(this, mS, handler, i2);
            w.h(str, "campaign param can't be empty");
            mU.aFo.mT().d(new 2(mU, str, 2));
        }
        return 2;
    }
}
