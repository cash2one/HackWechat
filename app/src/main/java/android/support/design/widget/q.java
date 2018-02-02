package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class q {
    private static q jD;
    b jE;
    b jF;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new 1(this));
    final Object mLock = new Object();

    interface a {
    }

    static q ap() {
        if (jD == null) {
            jD = new q();
        }
        return jD;
    }

    private q() {
    }

    public final void a(a aVar) {
        synchronized (this.mLock) {
            if (d(aVar)) {
                this.mHandler.removeCallbacksAndMessages(this.jE);
            }
        }
    }

    public final void b(a aVar) {
        synchronized (this.mLock) {
            if (d(aVar)) {
                b(this.jE);
            }
        }
    }

    public final boolean c(a aVar) {
        boolean z;
        synchronized (this.mLock) {
            z = d(aVar) || e(aVar);
        }
        return z;
    }

    final boolean a(b bVar) {
        if (((a) bVar.jH.get()) == null) {
            return false;
        }
        this.mHandler.removeCallbacksAndMessages(bVar);
        return true;
    }

    final boolean d(a aVar) {
        return this.jE != null && this.jE.f(aVar);
    }

    final boolean e(a aVar) {
        return this.jF != null && this.jF.f(aVar);
    }

    final void b(b bVar) {
        if (bVar.duration != -2) {
            int i = 2750;
            if (bVar.duration > 0) {
                i = bVar.duration;
            } else if (bVar.duration == -1) {
                i = 1500;
            }
            this.mHandler.removeCallbacksAndMessages(bVar);
            this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 0, bVar), (long) i);
        }
    }
}
