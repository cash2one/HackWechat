package android.support.design.widget;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.q.a;
import android.support.v4.view.z;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public final class Snackbar {
    private static final Handler jr = new Handler(Looper.getMainLooper(), new 1());
    final ViewGroup js;
    final SnackbarLayout jt;
    private final AccessibilityManager ju;
    final a jv;

    static /* synthetic */ void a(Snackbar snackbar) {
        q ap = q.ap();
        a aVar = snackbar.jv;
        synchronized (ap.mLock) {
            if (ap.d(aVar)) {
                ap.a(ap.jE);
            } else if (ap.e(aVar)) {
                ap.a(ap.jF);
            }
        }
    }

    final void ai() {
        if (VERSION.SDK_INT >= 14) {
            z.c(this.jt, (float) this.jt.getHeight());
            z.U(this.jt).s(0.0f).b(a.eB).d(250).a(new 6(this)).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.jt.getContext(), android.support.design.a.a.aQ);
        loadAnimation.setInterpolator(a.eB);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new 7(this));
        this.jt.startAnimation(loadAnimation);
    }

    final void aj() {
        q ap = q.ap();
        a aVar = this.jv;
        synchronized (ap.mLock) {
            if (ap.d(aVar)) {
                ap.b(ap.jE);
            }
        }
    }

    final void ak() {
        q ap = q.ap();
        a aVar = this.jv;
        synchronized (ap.mLock) {
            if (ap.d(aVar)) {
                ap.jE = null;
                if (!(ap.jF == null || ap.jF == null)) {
                    ap.jE = ap.jF;
                    ap.jF = null;
                    if (((a) ap.jE.jH.get()) == null) {
                        ap.jE = null;
                    }
                }
            }
        }
        ViewParent parent = this.jt.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.jt);
        }
    }

    final boolean al() {
        return !this.ju.isEnabled();
    }
}
