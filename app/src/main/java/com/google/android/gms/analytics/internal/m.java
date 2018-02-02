package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.c.ah;
import com.google.android.gms.common.internal.w;

public final class m extends o {
    final w aFK;

    public m(q qVar, r rVar) {
        super(qVar);
        w.ag(rVar);
        this.aFK = rVar.c(qVar);
    }

    public final long a(s sVar) {
        mQ();
        w.ag(sVar);
        q.mY();
        long d = this.aFK.d(sVar);
        if (d == 0) {
            this.aFK.c(sVar);
        }
        return d;
    }

    public final void a(ah ahVar) {
        mQ();
        this.aFo.mT().d(new 4(this, ahVar));
    }

    public final void c(final c cVar) {
        w.ag(cVar);
        mQ();
        d("Hit delivery requested", cVar);
        this.aFo.mT().d(new Runnable(this) {
            final /* synthetic */ m aFM;

            public final void run() {
                this.aFM.aFK.c(cVar);
            }
        });
    }

    public final void mJ() {
        mQ();
        Context context = this.aFo.mContext;
        if (AnalyticsReceiver.y(context) && AnalyticsService.z(context)) {
            Intent intent = new Intent(context, AnalyticsService.class);
            intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            context.startService(intent);
            return;
        }
        a(null);
    }

    public final void mK() {
        mQ();
        ah.mY();
        this.aFK.mK();
    }

    final void mL() {
        q.mY();
        this.aFK.mL();
    }

    protected final void mf() {
        this.aFK.mR();
    }

    final void onServiceConnected() {
        q.mY();
        this.aFK.onServiceConnected();
    }
}
