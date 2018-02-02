package com.google.android.gms.analytics.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.w;

abstract class ae {
    private static volatile Handler aHk;
    final q aFo;
    final Runnable aHl = new 1(this);
    volatile long aHm;
    private boolean aHn;

    ae(q qVar) {
        w.ag(qVar);
        this.aFo = qVar;
    }

    public final void Z(long j) {
        cancel();
        if (j >= 0) {
            this.aHm = this.aFo.aFD.currentTimeMillis();
            if (!getHandler().postDelayed(this.aHl, j)) {
                this.aFo.mS().f("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final void cancel() {
        this.aHm = 0;
        getHandler().removeCallbacks(this.aHl);
    }

    final Handler getHandler() {
        if (aHk != null) {
            return aHk;
        }
        Handler handler;
        synchronized (ae.class) {
            if (aHk == null) {
                aHk = new Handler(this.aFo.mContext.getMainLooper());
            }
            handler = aHk;
        }
        return handler;
    }

    public final boolean nG() {
        return this.aHm != 0;
    }

    public abstract void run();
}
