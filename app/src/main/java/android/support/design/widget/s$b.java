package android.support.design.widget;

import android.support.v4.view.z;
import android.view.View;

class s$b implements Runnable {
    final /* synthetic */ s jW;
    private final boolean jX;
    private final View mView;

    s$b(s sVar, View view, boolean z) {
        this.jW = sVar;
        this.mView = view;
        this.jX = z;
    }

    public final void run() {
        if (s.b(this.jW) != null && s.b(this.jW).cL()) {
            z.a(this.mView, this);
        } else if (this.jX && s.a(this.jW) != null) {
            s.a(this.jW).onDismiss(this.mView);
        }
    }
}
