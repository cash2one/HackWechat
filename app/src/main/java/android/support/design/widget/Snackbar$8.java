package android.support.design.widget;

import android.support.v4.view.an;
import android.support.v4.view.z;
import android.view.View;

class Snackbar$8 extends an {
    final /* synthetic */ Snackbar jw;
    final /* synthetic */ int val$event;

    Snackbar$8(Snackbar snackbar, int i) {
        this.jw = snackbar;
        this.val$event = i;
    }

    public final void p(View view) {
        Snackbar$SnackbarLayout c = Snackbar.c(this.jw);
        z.d(c.jy, 1.0f);
        z.U(c.jy).q(0.0f).d(180).e(0).start();
        if (c.jz.getVisibility() == 0) {
            z.d(c.jz, 1.0f);
            z.U(c.jz).q(0.0f).d(180).e(0).start();
        }
    }

    public final void q(View view) {
        Snackbar.a(this.jw, this.val$event);
    }
}
