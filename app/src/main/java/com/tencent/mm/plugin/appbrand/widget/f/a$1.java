package com.tencent.mm.plugin.appbrand.widget.f;

import android.view.ViewPropertyAnimator;

class a$1 implements Runnable {
    final /* synthetic */ a keX;

    a$1(a aVar) {
        this.keX = aVar;
    }

    public final void run() {
        a aVar = this.keX;
        if (aVar.getAlpha() != 0.0f && aVar.keW == null) {
            aVar.animate().cancel();
            ViewPropertyAnimator animate = aVar.animate();
            aVar.keW = animate;
            animate.alpha(0.0f).setListener(new a$3(aVar)).start();
        }
    }
}
