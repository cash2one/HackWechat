package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.internal.w;
import java.lang.ref.WeakReference;

class m$d implements e {
    private final WeakReference<m> aLc;
    private final a<?> aLi;
    final int aLj;

    public m$d(m mVar, a<?> aVar, int i) {
        this.aLc = new WeakReference(mVar);
        this.aLi = aVar;
        this.aLj = i;
    }

    public final void b(ConnectionResult connectionResult) {
        boolean z = false;
        m mVar = (m) this.aLc.get();
        if (mVar != null) {
            if (Looper.myLooper() == mVar.aKH.aKf) {
                z = true;
            }
            w.d(z, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            mVar.aKJ.lock();
            try {
                if (mVar.di(0)) {
                    if (!connectionResult.isSuccess()) {
                        mVar.b(connectionResult, this.aLi, this.aLj);
                    }
                    if (mVar.ok()) {
                        mVar.ol();
                    }
                    mVar.aKJ.unlock();
                }
            } finally {
                mVar.aKJ.unlock();
            }
        }
    }

    public final void c(ConnectionResult connectionResult) {
        boolean z = true;
        m mVar = (m) this.aLc.get();
        if (mVar != null) {
            if (Looper.myLooper() != mVar.aKH.aKf) {
                z = false;
            }
            w.d(z, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
            mVar.aKJ.lock();
            try {
                if (mVar.di(1)) {
                    if (!connectionResult.isSuccess()) {
                        mVar.b(connectionResult, this.aLi, this.aLj);
                    }
                    if (mVar.ok()) {
                        mVar.om();
                    }
                    mVar.aKJ.unlock();
                }
            } finally {
                mVar.aKJ.unlock();
            }
        }
    }
}
