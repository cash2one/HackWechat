package com.google.android.gms.a.a;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class a$b extends Thread {
    private WeakReference<a> aEs;
    private long aEt;
    CountDownLatch aEu = new CountDownLatch(1);
    boolean aEv = false;

    public a$b(a aVar, long j) {
        this.aEs = new WeakReference(aVar);
        this.aEt = j;
        start();
    }

    private void disconnect() {
        a aVar = (a) this.aEs.get();
        if (aVar != null) {
            aVar.finish();
            this.aEv = true;
        }
    }

    public final void run() {
        try {
            if (!this.aEu.await(this.aEt, TimeUnit.MILLISECONDS)) {
                disconnect();
            }
        } catch (InterruptedException e) {
            disconnect();
        }
    }
}
