package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;

class m$g implements b, c {
    final /* synthetic */ m aLb;

    private m$g(m mVar) {
        this.aLb = mVar;
    }

    public final void a(ConnectionResult connectionResult) {
        this.aLb.aKJ.lock();
        try {
            if (this.aLb.d(connectionResult)) {
                this.aLb.op();
                this.aLb.on();
            } else {
                this.aLb.e(connectionResult);
            }
            this.aLb.aKJ.unlock();
        } catch (Throwable th) {
            this.aLb.aKJ.unlock();
        }
    }

    public final void dh(int i) {
    }

    public final void e(Bundle bundle) {
        this.aLb.aKR.a(new m.b(this.aLb));
    }
}
