package com.google.android.gms.common.api;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.k.a;
import com.google.android.gms.common.api.o.c;
import com.google.android.gms.common.api.o.e;
import com.google.android.gms.common.internal.w;

public final class l implements p {
    private final o aKH;

    public l(o oVar) {
        this.aKH = oVar;
    }

    private <A extends b> void a(e<A> eVar) {
        this.aKH.b(eVar);
        o oVar = this.aKH;
        b bVar = (b) oVar.aLx.get(eVar.nT());
        w.i(bVar, "Appropriate Api was not requested.");
        if (bVar.isConnected() || !this.aKH.aLy.containsKey(eVar.nT())) {
            eVar.a(bVar);
        } else {
            eVar.c(new Status(17));
        }
    }

    public final <A extends b, R extends g, T extends a<R, A>> T a(T t) {
        return b(t);
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
    }

    public final <A extends b, T extends a<? extends g, A>> T b(T t) {
        try {
            a((e) t);
        } catch (DeadObjectException e) {
            this.aKH.a(new 1(this, this));
        }
        return t;
    }

    public final void begin() {
        while (!this.aKH.aLr.isEmpty()) {
            try {
                a((e) this.aKH.aLr.remove());
            } catch (DeadObjectException e) {
            }
        }
    }

    public final void connect() {
    }

    public final void dh(int i) {
        if (i == 1) {
            o oVar = this.aKH;
            if (!oVar.aLs) {
                oVar.aLs = true;
                if (oVar.aLw == null) {
                    oVar.aLw = new c(oVar);
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addDataScheme("package");
                    oVar.mContext.getApplicationContext().registerReceiver(oVar.aLw, intentFilter);
                }
                oVar.aLv.sendMessageDelayed(oVar.aLv.obtainMessage(1), oVar.aLt);
                oVar.aLv.sendMessageDelayed(oVar.aLv.obtainMessage(2), oVar.aLu);
            }
        }
        for (e a : this.aKH.aLD) {
            a.a(new Status(8, "The connection to Google Play services was lost"));
        }
        this.aKH.f(null);
        this.aKH.aLq.do(i);
        this.aKH.aLq.oO();
        if (i == 2) {
            this.aKH.connect();
        }
    }

    public final void disconnect() {
        this.aKH.aLy.clear();
        this.aKH.os();
        this.aKH.f(null);
        this.aKH.aLq.oO();
    }

    public final void e(Bundle bundle) {
    }

    public final String getName() {
        return "CONNECTED";
    }
}
