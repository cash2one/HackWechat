package com.tencent.mm.ui.chatting;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class ChattingUI$a$13 implements Runnable {
    final /* synthetic */ a ywR;

    ChattingUI$a$13(a aVar) {
        this.ywR = aVar;
    }

    public final void run() {
        if (this.ywR.yvM.yCh != null && this.ywR.yvM.yCh.getVisibility() == 0) {
            this.ywR.FA(1);
        } else if (a.o(this.ywR)) {
            this.ywR.FA(3);
        } else {
            this.ywR.FA(0);
        }
        Animation translateAnimation = new TranslateAnimation((float) a.m(this.ywR).getWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.ywR.getContext(), 17432581));
        a.m(this.ywR).startAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ChattingUI$a$13 ywU;

            {
                this.ywU = r1;
            }

            public final void onAnimationStart(Animation animation) {
                a.m(this.ywU.ywR).setClickable(false);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                a.m(this.ywU.ywR).setClickable(true);
            }
        });
    }
}
