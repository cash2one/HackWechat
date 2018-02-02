package android.support.design.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class r {
    WeakReference<View> fq;
    final ArrayList<a> jI = new ArrayList();
    a jJ = null;
    Animation jK = null;
    private AnimationListener jL = new 1(this);

    r() {
    }

    public final void a(int[] iArr, Animation animation) {
        a aVar = new a(iArr, animation, (byte) 0);
        animation.setAnimationListener(this.jL);
        this.jI.add(aVar);
    }

    final View aq() {
        return this.fq == null ? null : (View) this.fq.get();
    }
}
