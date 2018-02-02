package com.tencent.mapsdk.rastercore.e.a;

import android.os.Handler;
import android.view.animation.Animation;

class c$7 extends a {
    final /* synthetic */ c a;

    c$7(c cVar) {
        this.a = cVar;
    }

    public final void onAnimationEnd(Animation animation) {
        new Handler().post(new 1(this));
    }
}
