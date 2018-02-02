package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class da$a extends Handler {
    volatile boolean a;
    private /* synthetic */ da b;

    private da$a(da daVar, Looper looper) {
        this.b = daVar;
        super(looper);
        this.a = false;
        this.a = false;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.b.a) {
            synchronized (da.a(this.b)) {
                if (!(da.b(this.b) == null || this.a)) {
                    sendEmptyMessageDelayed(0, 30000);
                }
            }
            da.a(this.b, ea.b(da.c(this.b)));
        }
    }
}
