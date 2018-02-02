package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class k$a extends k$c<Boolean> {
    public final Bundle aOj;
    final /* synthetic */ k aOk;
    public final int statusCode;

    protected k$a(k kVar, int i, Bundle bundle) {
        this.aOk = kVar;
        super(kVar, Boolean.valueOf(true));
        this.statusCode = i;
        this.aOj = bundle;
    }

    protected final /* synthetic */ void ae(Object obj) {
        PendingIntent pendingIntent = null;
        if (((Boolean) obj) == null) {
            k.a(this.aOk, 1);
            return;
        }
        switch (this.statusCode) {
            case 0:
                if (!oL()) {
                    k.a(this.aOk, 1);
                    h(new ConnectionResult(8, null));
                    return;
                }
                return;
            case 10:
                k.a(this.aOk, 1);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                k.a(this.aOk, 1);
                if (this.aOj != null) {
                    pendingIntent = (PendingIntent) this.aOj.getParcelable("pendingIntent");
                }
                h(new ConnectionResult(this.statusCode, pendingIntent));
                return;
        }
    }

    protected abstract void h(ConnectionResult connectionResult);

    protected abstract boolean oL();
}
