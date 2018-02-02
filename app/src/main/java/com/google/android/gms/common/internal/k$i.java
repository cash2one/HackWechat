package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.k.a;

protected final class k$i extends a {
    final /* synthetic */ k aOk;

    public k$i(k kVar, int i, Bundle bundle) {
        this.aOk = kVar;
        super(kVar, i, bundle);
    }

    protected final void h(ConnectionResult connectionResult) {
        k.a(this.aOk).c(connectionResult);
        k.oH();
    }

    protected final boolean oL() {
        k.a(this.aOk).c(ConnectionResult.aJC);
        return true;
    }
}
