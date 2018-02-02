package com.google.android.gms.analytics.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.stats.b;
import java.util.Collections;

public final class t extends o {
    final a aGq = new a(this);
    d aGr;
    private final ae aGs;
    private j aGt;

    protected t(q qVar) {
        super(qVar);
        this.aGt = new j(qVar.aFD);
        this.aGs = new 1(this, qVar);
    }

    static /* synthetic */ void a(t tVar) {
        q.mY();
        if (tVar.isConnected()) {
            tVar.au("Inactivity, disconnecting from device AnalyticsService");
            tVar.disconnect();
        }
    }

    public final boolean connect() {
        q.mY();
        mQ();
        if (this.aGr != null) {
            return true;
        }
        d na = this.aGq.na();
        if (na == null) {
            return false;
        }
        this.aGr = na;
        mZ();
        return true;
    }

    public final boolean d(c cVar) {
        w.ag(cVar);
        q.mY();
        mQ();
        d dVar = this.aGr;
        if (dVar == null) {
            return false;
        }
        try {
            dVar.a(cVar.aFb, cVar.aFe, cVar.aFg ? ac.nB() : ac.nC(), Collections.emptyList());
            mZ();
            return true;
        } catch (RemoteException e) {
            au("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public final void disconnect() {
        q.mY();
        mQ();
        try {
            b.pi().a(this.aFo.mContext, this.aGq);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        if (this.aGr != null) {
            this.aGr = null;
            this.aFo.mU().mK();
        }
    }

    public final boolean isConnected() {
        q.mY();
        mQ();
        return this.aGr != null;
    }

    void mZ() {
        this.aGt.start();
        this.aGs.Z(((Long) aj.aIc.get()).longValue());
    }

    protected final void mf() {
    }
}
