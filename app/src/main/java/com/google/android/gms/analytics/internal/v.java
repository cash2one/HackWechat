package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.aj;

public final class v extends o {
    private final aj aGG = new aj();

    v(q qVar) {
        super(qVar);
    }

    protected final void mf() {
        this.aFo.mT().pR().a(this.aGG);
        l mW = this.aFo.mW();
        String mD = mW.mD();
        if (mD != null) {
            this.aGG.aEW = mD;
        }
        String mC = mW.mC();
        if (mC != null) {
            this.aGG.aEX = mC;
        }
    }

    public final aj nh() {
        mQ();
        return this.aGG;
    }
}
