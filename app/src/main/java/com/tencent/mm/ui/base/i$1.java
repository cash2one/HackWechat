package com.tencent.mm.ui.base;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mm.ui.base.i.a.b;

class i$1 implements OnClickListener {
    final /* synthetic */ b xZl;
    final /* synthetic */ ImageView xZm;
    final /* synthetic */ i xZn;

    i$1(i iVar, b bVar, ImageView imageView) {
        this.xZn = iVar;
        this.xZl = bVar;
        this.xZm = imageView;
    }

    public final void onClick(View view) {
        if (this.xZl != null) {
            this.xZl.caR();
        }
        if (this.xZm.isSelected()) {
            i.c(this.xZn).startAnimation(i.b(this.xZn));
            i.b(this.xZn).setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ i$1 xZo;

                {
                    this.xZo = r1;
                }

                public final void onAnimationStart(Animation animation) {
                    i.a(this.xZo.xZn, i.d(this.xZo.xZn));
                }

                public final void onAnimationEnd(Animation animation) {
                    i.c(this.xZo.xZn).setVisibility(8);
                    i.a(this.xZo.xZn, 0);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            ObjectAnimator.ofFloat(this.xZm, "rotation", new float[]{180.0f, 0.0f}).setDuration(200).start();
            this.xZm.setSelected(false);
            return;
        }
        i.c(this.xZn).startAnimation(i.e(this.xZn));
        i.e(this.xZn).setAnimationListener(new 2(this));
        ObjectAnimator.ofFloat(this.xZm, "rotation", new float[]{0.0f, 180.0f}).setDuration(200).start();
        this.xZm.setSelected(true);
    }
}
