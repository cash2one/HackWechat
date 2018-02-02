package com.tencent.d.b.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.d.a.c.c;

public class g {
    private static volatile g Ado = null;
    private Handler Adp = null;
    private Handler Adq = null;

    private g() {
        HandlerThread handlerThread = new HandlerThread("SoterGenKeyHandlerThreadName");
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            this.Adp = new Handler(handlerThread.getLooper());
        } else {
            c.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
            this.Adp = new Handler(Looper.getMainLooper());
        }
        this.Adq = new Handler(Looper.getMainLooper());
    }

    public static g cGk() {
        if (Ado != null) {
            return Ado;
        }
        g gVar;
        synchronized (g.class) {
            if (Ado == null) {
                Ado = new g();
            }
            gVar = Ado;
        }
        return gVar;
    }

    public final void A(Runnable runnable) {
        this.Adp.post(runnable);
    }

    public final void k(Runnable runnable, long j) {
        this.Adp.postDelayed(runnable, j);
    }

    public final void y(Runnable runnable) {
        this.Adq.post(runnable);
    }
}
