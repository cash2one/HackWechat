package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.o.b;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.t.a;
import java.lang.ref.WeakReference;

class m$b extends a {
    private final WeakReference<m> aLc;

    m$b(m mVar) {
        this.aLc = new WeakReference(mVar);
    }

    public final void a(final ResolveAccountResponse resolveAccountResponse) {
        final m mVar = (m) this.aLc.get();
        if (mVar != null) {
            mVar.aKH.a(new b(this, mVar) {
                final /* synthetic */ m$b aLh;

                public final void oj() {
                    m mVar = mVar;
                    ResolveAccountResponse resolveAccountResponse = resolveAccountResponse;
                    if (mVar.di(0)) {
                        ConnectionResult connectionResult = resolveAccountResponse.aMa;
                        if (connectionResult.isSuccess()) {
                            mVar.aKV = p.a.g(resolveAccountResponse.aMW);
                            mVar.aKU = true;
                            mVar.aKW = resolveAccountResponse.aKW;
                            mVar.aKX = resolveAccountResponse.aNl;
                            mVar.ol();
                        } else if (mVar.d(connectionResult)) {
                            mVar.op();
                            mVar.ol();
                        } else {
                            mVar.e(connectionResult);
                        }
                    }
                }
            });
        }
    }
}
