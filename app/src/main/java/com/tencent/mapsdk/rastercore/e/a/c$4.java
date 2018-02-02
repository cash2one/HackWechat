package com.tencent.mapsdk.rastercore.e.a;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;

class c$4 extends a {
    final /* synthetic */ View a;
    final /* synthetic */ c b;

    c$4(c cVar, View view) {
        this.b = cVar;
        this.a = view;
    }

    public final void onAnimationEnd(Animation animation) {
        new Handler().post(new 1(this));
    }
}
