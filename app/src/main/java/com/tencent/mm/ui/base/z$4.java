package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class z$4 implements OnAttachStateChangeListener {
    final /* synthetic */ z yhd;

    z$4(z zVar) {
        this.yhd = zVar;
    }

    public final void onViewAttachedToWindow(View view) {
    }

    public final void onViewDetachedFromWindow(View view) {
        z zVar = this.yhd;
        zVar.kO.getViewTreeObserver().removeOnScrollChangedListener(zVar.yha);
        zVar.kO.getViewTreeObserver().removeOnPreDrawListener(zVar.ygZ);
        zVar.cqd();
        zVar.cqc();
        zVar.ygM = null;
        zVar.ygN = null;
        zVar.ygR = null;
    }
}
