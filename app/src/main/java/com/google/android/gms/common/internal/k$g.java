package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.k.a;

protected final class k$g extends a {
    final /* synthetic */ k aOk;
    public final IBinder aOo;

    public k$g(k kVar, int i, IBinder iBinder, Bundle bundle) {
        this.aOk = kVar;
        super(kVar, i, bundle);
        this.aOo = iBinder;
    }

    protected final void h(ConnectionResult connectionResult) {
        if (k.e(this.aOk) != null) {
            k.e(this.aOk).a(connectionResult);
        }
        k.oH();
    }

    protected final boolean oL() {
        try {
            String interfaceDescriptor = this.aOo.getInterfaceDescriptor();
            if (this.aOk.nY().equals(interfaceDescriptor)) {
                IInterface f = this.aOk.f(this.aOo);
                if (f == null || !k.a(this.aOk, 2, 3, f)) {
                    return false;
                }
                if (k.b(this.aOk) != null) {
                    k.b(this.aOk).e(null);
                }
                return true;
            }
            new StringBuilder("service descriptor mismatch: ").append(this.aOk.nY()).append(" vs. ").append(interfaceDescriptor);
            return false;
        } catch (RemoteException e) {
            return false;
        }
    }
}
