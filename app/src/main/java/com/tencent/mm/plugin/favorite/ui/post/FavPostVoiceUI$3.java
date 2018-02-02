package com.tencent.mm.plugin.favorite.ui.post;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.R;

class FavPostVoiceUI$3 implements Runnable {
    final /* synthetic */ FavPostVoiceUI myN;

    FavPostVoiceUI$3(FavPostVoiceUI favPostVoiceUI) {
        this.myN = favPostVoiceUI;
    }

    public final void run() {
        this.myN.findViewById(R.h.cWH).setVisibility(0);
        FavPostVoiceUI.d(this.myN).setVisibility(0);
        this.myN.findViewById(R.h.cgU).setVisibility(0);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300);
        FavPostVoiceUI.d(this.myN).startAnimation(alphaAnimation);
        this.myN.findViewById(R.h.cWH).startAnimation(alphaAnimation);
        this.myN.findViewById(R.h.cgU).startAnimation(translateAnimation);
    }
}
