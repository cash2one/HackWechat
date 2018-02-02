package com.google.android.gms.analytics.internal;

import java.lang.Thread.UncaughtExceptionHandler;

class q$1 implements UncaughtExceptionHandler {
    final /* synthetic */ q aGi;

    q$1(q qVar) {
        this.aGi = qVar;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        f fVar = this.aGi.aFX;
        if (fVar != null) {
            fVar.f("Job execution failed", th);
        }
    }
}
