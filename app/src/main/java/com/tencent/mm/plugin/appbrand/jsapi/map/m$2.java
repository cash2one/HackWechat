package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.sdk.platformtools.x;

class m$2 implements AnimatorListener {
    final /* synthetic */ m jmx;

    m$2(m mVar) {
        this.jmx = mVar;
    }

    public final void onAnimationStart(Animator animator) {
        x.d("MicroMsg.JsApiTranslateMapMarker", "MarkerRotateAnimator start");
    }

    public final void onAnimationEnd(Animator animator) {
        x.d("MicroMsg.JsApiTranslateMapMarker", "MarkerRotateAnimator end");
        m.c(this.jmx).afh();
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
