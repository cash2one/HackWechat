package android.support.design.widget;

import android.view.MotionEvent;
import android.view.View;

final class Snackbar$a extends s<Snackbar$SnackbarLayout> {
    final /* synthetic */ Snackbar jw;

    Snackbar$a(Snackbar snackbar) {
        this.jw = snackbar;
    }

    public final boolean r(View view) {
        return view instanceof Snackbar$SnackbarLayout;
    }

    private boolean a(CoordinatorLayout coordinatorLayout, Snackbar$SnackbarLayout snackbar$SnackbarLayout, MotionEvent motionEvent) {
        if (coordinatorLayout.b(snackbar$SnackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    q.ap().a(Snackbar.b(this.jw));
                    break;
                case 1:
                case 3:
                    q.ap().b(Snackbar.b(this.jw));
                    break;
            }
        }
        return super.a(coordinatorLayout, snackbar$SnackbarLayout, motionEvent);
    }
}
