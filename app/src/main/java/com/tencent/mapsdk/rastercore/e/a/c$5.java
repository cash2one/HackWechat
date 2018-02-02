package com.tencent.mapsdk.rastercore.e.a;

import android.os.Handler;
import android.view.animation.Animation;

class c$5 extends a {
    final /* synthetic */ c a;

    c$5(c cVar) {
        this.a = cVar;
    }

    public final void onAnimationEnd(Animation animation) {
        new Handler().post(new 1(this));
    }
}
