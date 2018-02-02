package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.internal.k.i;
import com.google.android.gms.common.internal.r.a;

public final class k$d extends a {
    private k aOm;
    private final int aOn;

    public k$d(k kVar, int i) {
        this.aOm = kVar;
        this.aOn = i;
    }

    public final void a(int i, IBinder iBinder, Bundle bundle) {
        w.i(this.aOm, "onPostInitComplete can be called only once per call to getRemoteService");
        this.aOm.a(i, iBinder, bundle, this.aOn);
        this.aOm = null;
    }

    public final void b(int i, Bundle bundle) {
        w.i(this.aOm, "onAccountValidationComplete can be called only once per call to validateAccount");
        k kVar = this.aOm;
        kVar.mHandler.sendMessage(kVar.mHandler.obtainMessage(5, this.aOn, -1, new i(kVar, i, bundle)));
        this.aOm = null;
    }
}
