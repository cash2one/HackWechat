package android.support.design.widget;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.design.a.a;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.design.widget.Snackbar.2;
import android.support.design.widget.Snackbar.3;
import android.support.design.widget.Snackbar.4;
import android.support.design.widget.Snackbar.5;
import android.support.v4.view.z;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

class Snackbar$1 implements Callback {
    Snackbar$1() {
    }

    public final boolean handleMessage(Message message) {
        Snackbar snackbar;
        switch (message.what) {
            case 0:
                snackbar = (Snackbar) message.obj;
                if (snackbar.jt.getParent() == null) {
                    LayoutParams layoutParams = snackbar.jt.getLayoutParams();
                    if (layoutParams instanceof d) {
                        Behavior snackbar$a = new Snackbar$a(snackbar);
                        snackbar$a.jT = s.c(0.0f, 0.1f, 1.0f);
                        snackbar$a.jU = s.c(0.0f, 0.6f, 1.0f);
                        snackbar$a.jR = 0;
                        snackbar$a.jO = new 3(snackbar);
                        ((d) layoutParams).a(snackbar$a);
                    }
                    snackbar.js.addView(snackbar.jt);
                }
                snackbar.jt.jC = new 4(snackbar);
                if (!z.ai(snackbar.jt)) {
                    snackbar.jt.jB = new 5(snackbar);
                } else if (snackbar.al()) {
                    snackbar.ai();
                } else {
                    snackbar.aj();
                }
                return true;
            case 1:
                snackbar = (Snackbar) message.obj;
                int i = message.arg1;
                if (!snackbar.al() || snackbar.jt.getVisibility() != 0) {
                    snackbar.ak();
                } else if (VERSION.SDK_INT >= 14) {
                    z.U(snackbar.jt).s((float) snackbar.jt.getHeight()).b(a.eB).d(250).a(new Snackbar$8(snackbar, i)).start();
                } else {
                    Animation loadAnimation = AnimationUtils.loadAnimation(snackbar.jt.getContext(), a.aR);
                    loadAnimation.setInterpolator(a.eB);
                    loadAnimation.setDuration(250);
                    loadAnimation.setAnimationListener(new 2(snackbar, i));
                    snackbar.jt.startAnimation(loadAnimation);
                }
                return true;
            default:
                return false;
        }
    }
}
