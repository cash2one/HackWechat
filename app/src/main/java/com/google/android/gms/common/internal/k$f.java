package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.e;

protected class k$f implements e {
    final /* synthetic */ k aOk;

    public k$f(k kVar) {
        this.aOk = kVar;
    }

    public final void b(ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            this.aOk.a(null, k.d(this.aOk));
        } else if (k.e(this.aOk) != null) {
            k.e(this.aOk).a(connectionResult);
        }
    }

    public final void c(ConnectionResult connectionResult) {
        throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
    }
}
