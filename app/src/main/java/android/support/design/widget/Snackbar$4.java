package android.support.design.widget;

class Snackbar$4 implements Snackbar$SnackbarLayout$a {
    final /* synthetic */ Snackbar jw;

    Snackbar$4(Snackbar snackbar) {
        this.jw = snackbar;
    }

    public final void an() {
        if (q.ap().c(this.jw.jv)) {
            Snackbar.am().post(new Runnable(this) {
                final /* synthetic */ Snackbar$4 jx;

                {
                    this.jx = r1;
                }

                public final void run() {
                    Snackbar.a(this.jx.jw, 3);
                }
            });
        }
    }
}
