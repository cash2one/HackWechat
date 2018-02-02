package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.voiceprint.ui.a.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements AnimationListener {
    final /* synthetic */ a siD;

    a$1(a aVar) {
        this.siD = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.siD != null) {
            this.siD.bFO();
        }
        x.d("MicroMsg.VoiceViewAnimationHelper", "playTipAnim end");
    }
}
