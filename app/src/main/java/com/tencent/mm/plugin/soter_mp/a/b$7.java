package com.tencent.mm.plugin.soter_mp.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.R;

class b$7 implements AnimationListener {
    final /* synthetic */ CharSequence lp;
    final /* synthetic */ b rTf;

    b$7(b bVar, CharSequence charSequence) {
        this.rTf = bVar;
        this.lp = charSequence;
    }

    public final void onAnimationStart(Animation animation) {
        this.rTf.rSY.setImageResource(R.k.dyD);
        this.rTf.jCB.setText(this.lp);
        this.rTf.jCB.setTextColor(this.rTf.jCB.getResources().getColor(R.e.bud));
        this.rTf.jCB.removeCallbacks(this.rTf.rTe);
    }

    public final void onAnimationEnd(Animation animation) {
        this.rTf.jCB.post(this.rTf.rTe);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
