package com.google.android.gms.analytics.internal;

public abstract class o extends n {
    private boolean aFR;
    private boolean aFS;

    protected o(q qVar) {
        super(qVar);
    }

    public final boolean isInitialized() {
        return this.aFR && !this.aFS;
    }

    protected final void mQ() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void mR() {
        mf();
        this.aFR = true;
    }

    protected abstract void mf();
}
