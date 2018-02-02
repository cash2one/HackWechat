package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.view.View;

class Snackbar$6 extends an {
    final /* synthetic */ Snackbar jw;

    Snackbar$6(Snackbar snackbar) {
        this.jw = snackbar;
    }

    public final void p(View view) {
        SnackbarLayout c = Snackbar.c(this.jw);
        z.d(c.jy, 0.0f);
        z.U(c.jy).q(1.0f).d(180).e(70).start();
        if (c.jz.getVisibility() == 0) {
            z.d(c.jz, 0.0f);
            z.U(c.jz).q(1.0f).d(180).e(70).start();
        }
    }

    public final void q(View view) {
        Snackbar.f(this.jw);
    }
}
