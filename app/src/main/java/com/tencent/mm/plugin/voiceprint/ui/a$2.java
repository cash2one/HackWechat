package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.plugin.voiceprint.ui.a.a;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements AnimationListener {
    final /* synthetic */ View kXI;
    final /* synthetic */ a siE;
    final /* synthetic */ int siF;

    a$2(a aVar, int i, View view) {
        this.siE = aVar;
        this.siF = i;
        this.kXI = view;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.siE != null) {
            this.siE.bFN();
        }
        x.d("MicroMsg.VoiceViewAnimationHelper", "onAnimationEnd ");
        Animation translateAnimation = new TranslateAnimation(0, (float) this.siF, 0, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setStartOffset(0);
        translateAnimation.setRepeatMode(-1);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new 1(this));
        this.kXI.startAnimation(translateAnimation);
    }
}
