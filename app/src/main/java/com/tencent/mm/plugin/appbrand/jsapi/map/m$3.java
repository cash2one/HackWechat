package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.sdk.platformtools.x;

class m$3 implements AnimatorListener {
    final /* synthetic */ m jmx;

    m$3(m mVar) {
        this.jmx = mVar;
    }

    public final void onAnimationStart(Animator animator) {
        x.d("MicroMsg.JsApiTranslateMapMarker", "MarkerTranslateAnimator start");
    }

    public final void onAnimationEnd(Animator animator) {
        x.d("MicroMsg.JsApiTranslateMapMarker", "MarkerTranslateAnimator end");
        m.c(this.jmx).afh();
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
