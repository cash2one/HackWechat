package com.tencent.mapsdk.rastercore.e.a;

import android.view.animation.Animation;

class c$2 extends a {
    private /* synthetic */ c a;

    c$2(c cVar) {
        this.a = cVar;
    }

    public final void onAnimationEnd(Animation animation) {
        c.g(this.a).setAnimationListener(null);
        c.h(this.a);
    }
}
