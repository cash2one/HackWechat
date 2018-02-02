package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.b;
import java.lang.ref.WeakReference;

class m$a extends b {
    private final WeakReference<m> aLc;

    m$a(m mVar) {
        this.aLc = new WeakReference(mVar);
    }

    public final void a(final ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
        final m mVar = (m) this.aLc.get();
        if (mVar != null) {
            mVar.aKH.a(new o.b(this, mVar) {
                final /* synthetic */ m$a aLf;

                public final void oj() {
                    m mVar = mVar;
                    ConnectionResult connectionResult = connectionResult;
                    if (!mVar.di(2)) {
                        return;
                    }
                    if (connectionResult.isSuccess()) {
                        mVar.on();
                    } else if (mVar.d(connectionResult)) {
                        mVar.op();
                        mVar.on();
                    } else {
                        mVar.e(connectionResult);
                    }
                }
            });
        }
    }
}
