package com.google.android.gms.c;

import android.util.Log;
import com.google.android.gms.c.ah.a;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.FutureTask;

class ah$a$1 extends FutureTask<T> {
    final /* synthetic */ a aYt;

    ah$a$1(a aVar, Runnable runnable, Object obj) {
        this.aYt = aVar;
        super(runnable, obj);
    }

    protected final void setException(Throwable th) {
        UncaughtExceptionHandler b = ah.b(this.aYt.aYs);
        if (b != null) {
            b.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            new StringBuilder("MeasurementExecutor: job failed with ").append(th);
        }
        super.setException(th);
    }
}
