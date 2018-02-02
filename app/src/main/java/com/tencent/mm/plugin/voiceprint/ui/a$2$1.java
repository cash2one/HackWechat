package com.tencent.mm.plugin.voiceprint.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.voiceprint.ui.a.2;
import com.tencent.mm.sdk.platformtools.x;

class a$2$1 implements AnimationListener {
    final /* synthetic */ 2 siG;

    a$2$1(2 2) {
        this.siG = 2;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        x.i("MicroMsg.VoiceViewAnimationHelper", "next end");
        if (this.siG.siE != null) {
            this.siG.siE.bFO();
        }
    }
}
