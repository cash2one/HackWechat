package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;

class cy$1 implements Runnable {
    private /* synthetic */ Handler a;
    private /* synthetic */ HandlerThread b;

    cy$1(Handler handler, HandlerThread handlerThread) {
        this.a = handler;
        this.b = handlerThread;
    }

    public final void run() {
        try {
            if (this.a != null) {
                this.a.removeCallbacksAndMessages(null);
            }
            if (this.b != null) {
                this.b.quit();
            }
        } catch (Throwable th) {
        }
    }
}
