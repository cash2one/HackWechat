package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.app.c;
import android.support.v7.view.menu.l.a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;

final class g implements OnClickListener, OnDismissListener, OnKeyListener, a {
    c LA;
    e LB;
    private a LC;
    f eg;

    public g(f fVar) {
        this.eg = fVar;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.LA.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.LA.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.eg.C(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.eg.performShortcut(i, keyEvent, 0);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.LB.a(this.eg, true);
    }

    public final void a(f fVar, boolean z) {
        if ((z || fVar == this.eg) && this.LA != null) {
            this.LA.dismiss();
        }
        if (this.LC != null) {
            this.LC.a(fVar, z);
        }
    }

    public final boolean d(f fVar) {
        if (this.LC != null) {
            return this.LC.d(fVar);
        }
        return false;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.eg.a((h) this.LB.getAdapter().getItem(i), null, 0);
    }
}
