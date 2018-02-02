package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

final class dg$a extends Handler {
    volatile boolean a;
    private /* synthetic */ dg b;

    private dg$a(dg dgVar, Looper looper) {
        this.b = dgVar;
        super(looper);
        this.a = false;
        this.a = false;
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public final void handleMessage(Message message) {
        if (this.b.a) {
            List list = null;
            if (dg.b(this.b) != null) {
                try {
                    list = dg.b(this.b).getAllCellInfo();
                } catch (Throwable th) {
                }
                this.b.onCellInfoChanged(list);
            }
            synchronized (dg.c(this.b)) {
                if (!(dg.d(this.b) == null || this.a)) {
                    sendEmptyMessageDelayed(0, 30000);
                }
            }
        }
    }
}
