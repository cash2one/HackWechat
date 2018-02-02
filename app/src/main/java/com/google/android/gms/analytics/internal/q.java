package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.a;
import com.google.android.gms.analytics.b;
import com.google.android.gms.analytics.c;
import com.google.android.gms.c.ah;
import com.google.android.gms.c.v;
import com.google.android.gms.c.w;
import com.google.android.gms.common.internal.f;

public class q {
    private static q aFU;
    public final v aFD = w.pH();
    final Context aFV;
    final ac aFW = r.b(this);
    final f aFX;
    private final ah aFY;
    private final m aFZ;
    final ag aGa;
    private final l aGb;
    final i aGc;
    private final a aGd;
    private final y aGe;
    public final a aGf;
    public final v aGg;
    public final af aGh;
    final Context mContext;

    private q(r rVar) {
        Context context = rVar.aGj;
        com.google.android.gms.common.internal.w.i(context, "Application context can't be null");
        com.google.android.gms.common.internal.w.e(context instanceof Application, "getApplicationContext didn't return the application");
        Context context2 = rVar.aGk;
        com.google.android.gms.common.internal.w.ag(context2);
        this.mContext = context;
        this.aFV = context2;
        f fVar = new f(this);
        fVar.mR();
        this.aFX = fVar;
        if (f.aNs) {
            mS().aw("Google Analytics " + p.VERSION + " is starting up.");
        } else {
            mS().aw("Google Analytics " + p.VERSION + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        }
        i f = r.f(this);
        f.mR();
        this.aGc = f;
        l lVar = new l(this);
        lVar.mR();
        this.aGb = lVar;
        m mVar = new m(this, rVar);
        y a = r.a(this);
        a aVar = new a(this);
        v vVar = new v(this);
        af afVar = new af(this);
        ah S = ah.S(context);
        S.aYq = new 1(this);
        this.aFY = S;
        c aVar2 = new a(this);
        a.mR();
        this.aGe = a;
        aVar.mR();
        this.aGf = aVar;
        vVar.mR();
        this.aGg = vVar;
        afVar.mR();
        this.aGh = afVar;
        ag e = r.e(this);
        e.mR();
        this.aGa = e;
        mVar.mR();
        this.aFZ = mVar;
        if (f.aNs) {
            mS().d("Device AnalyticsService version", p.VERSION);
        }
        l mW = aVar2.aHf.mW();
        if (mW.mE()) {
            e.mm().setLogLevel(mW.getLogLevel());
        }
        if (mW.mH()) {
            aVar2.aEL = mW.mI();
        }
        if (mW.mE()) {
            b mm = e.mm();
            if (mm != null) {
                mm.setLogLevel(mW.getLogLevel());
            }
        }
        aVar2.aEI = true;
        this.aGd = aVar2;
        mVar.aFK.start();
    }

    public static q A(Context context) {
        com.google.android.gms.common.internal.w.ag(context);
        if (aFU == null) {
            synchronized (q.class) {
                if (aFU == null) {
                    v pH = w.pH();
                    long elapsedRealtime = pH.elapsedRealtime();
                    q qVar = new q(new r(context.getApplicationContext()));
                    aFU = qVar;
                    a.me();
                    elapsedRealtime = pH.elapsedRealtime() - elapsedRealtime;
                    long longValue = ((Long) aj.aIi.get()).longValue();
                    if (elapsedRealtime > longValue) {
                        qVar.mS().c("Slow initialization (ms)", Long.valueOf(elapsedRealtime), Long.valueOf(longValue));
                    }
                }
            }
        }
        return aFU;
    }

    public static void a(o oVar) {
        com.google.android.gms.common.internal.w.i(oVar, "Analytics service not created/initialized");
        com.google.android.gms.common.internal.w.e(oVar.isInitialized(), "Analytics service not initialized");
    }

    public static void mY() {
        ah.mY();
    }

    public final f mS() {
        a(this.aFX);
        return this.aFX;
    }

    public final ah mT() {
        com.google.android.gms.common.internal.w.ag(this.aFY);
        return this.aFY;
    }

    public final m mU() {
        a(this.aFZ);
        return this.aFZ;
    }

    public final a mV() {
        com.google.android.gms.common.internal.w.ag(this.aGd);
        a aVar = this.aGd;
        boolean z = aVar.aEI && !aVar.aEJ;
        com.google.android.gms.common.internal.w.e(z, "Analytics instance not initialized");
        return this.aGd;
    }

    public final l mW() {
        a(this.aGb);
        return this.aGb;
    }

    public final y mX() {
        a(this.aGe);
        return this.aGe;
    }
}
