package com.tencent.mm.plugin.luckymoney.particles;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class c$1 implements OnAttachStateChangeListener {
    final /* synthetic */ c oeD;

    c$1(c cVar) {
        this.oeD = cVar;
    }

    public final void onViewAttachedToWindow(View view) {
    }

    public final void onViewDetachedFromWindow(View view) {
        this.oeD.aXn();
    }
}
