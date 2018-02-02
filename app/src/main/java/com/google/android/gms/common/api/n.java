package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.k.a;
import com.google.android.gms.common.api.o.e;
import java.util.Collections;

public final class n implements p {
    private final o aKH;

    public n(o oVar) {
        this.aKH = oVar;
    }

    public final <A extends b, R extends g, T extends a<R, A>> T a(T t) {
        this.aKH.aLr.add(t);
        return t;
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
    }

    public final <A extends b, T extends a<? extends g, A>> T b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void begin() {
        for (b disconnect : this.aKH.aLx.values()) {
            disconnect.disconnect();
        }
        this.aKH.aLz = Collections.emptySet();
    }

    public final void connect() {
        o oVar = this.aKH;
        oVar.aKJ.lock();
        try {
            oVar.aLA = new m(oVar, oVar.aKY, oVar.aKZ, oVar.aKg, oVar.aKh, oVar.aKJ, oVar.mContext);
            oVar.aLA.begin();
            oVar.aLp.signalAll();
        } finally {
            oVar.aKJ.unlock();
        }
    }

    public final void dh(int i) {
    }

    public final void disconnect() {
        for (e cancel : this.aKH.aLr) {
            cancel.cancel();
        }
        this.aKH.aLr.clear();
        this.aKH.aLy.clear();
        this.aKH.os();
    }

    public final void e(Bundle bundle) {
    }

    public final String getName() {
        return "DISCONNECTED";
    }
}
