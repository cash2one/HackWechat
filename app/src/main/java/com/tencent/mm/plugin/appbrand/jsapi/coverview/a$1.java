package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;

class a$1 extends AnimatorListenerAdapter {
    final /* synthetic */ f jiC;
    final /* synthetic */ a jjh;

    a$1(a aVar, f fVar) {
        this.jjh = aVar;
        this.jiC = fVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.jiC.sj(this.jjh.e("ok", null));
    }
}
