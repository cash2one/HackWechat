package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;

class o$4 implements c {
    final /* synthetic */ o aLH;
    final /* synthetic */ a aLI;
    final /* synthetic */ int aLJ;

    o$4(o oVar, a aVar, int i) {
        this.aLH = oVar;
        this.aLI = aVar;
        this.aLJ = i;
    }

    public final void a(ConnectionResult connectionResult) {
        this.aLH.aKJ.lock();
        try {
            this.aLH.aLA.a(connectionResult, this.aLI, this.aLJ);
        } finally {
            this.aLH.aKJ.unlock();
        }
    }
}
