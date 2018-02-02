package android.support.v4.view;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.e.b;

class e$b$a extends Handler {
    final /* synthetic */ b xi;

    e$b$a(b bVar) {
        this.xi = bVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                b.b(this.xi).onShowPress(b.a(this.xi));
                return;
            case 2:
                b.c(this.xi);
                return;
            case 3:
                if (b.d(this.xi) == null) {
                    return;
                }
                if (b.e(this.xi)) {
                    b.f(this.xi);
                    return;
                } else {
                    b.d(this.xi).onSingleTapConfirmed(b.a(this.xi));
                    return;
                }
            default:
                throw new RuntimeException("Unknown message " + message);
        }
    }
}
