package com.google.android.gms.common.internal;

protected abstract class k$c<TListener> {
    private TListener aLN;
    final /* synthetic */ k aOk;
    private boolean aOl = false;

    public k$c(k kVar, TListener tListener) {
        this.aOk = kVar;
        this.aLN = tListener;
    }

    protected abstract void ae(TListener tListener);

    public final void oM() {
        synchronized (this) {
            Object obj = this.aLN;
            if (this.aOl) {
                new StringBuilder("Callback proxy ").append(this).append(" being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                ae(obj);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.aOl = true;
        }
        unregister();
    }

    public final void oN() {
        synchronized (this) {
            this.aLN = null;
        }
    }

    public final void unregister() {
        oN();
        synchronized (k.c(this.aOk)) {
            k.c(this.aOk).remove(this);
        }
    }
}
