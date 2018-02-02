package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.k.a;

protected final class k$h extends a {
    final /* synthetic */ k aOk;

    public k$h(k kVar) {
        this.aOk = kVar;
        super(kVar, 0, null);
    }

    protected final void h(ConnectionResult connectionResult) {
        k.a(this.aOk).b(connectionResult);
        k.oH();
    }

    protected final boolean oL() {
        k.a(this.aOk).b(ConnectionResult.aJC);
        return true;
    }
}
