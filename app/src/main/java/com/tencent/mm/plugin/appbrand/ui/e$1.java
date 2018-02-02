package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup;

class e$1 implements Runnable {
    final /* synthetic */ e jLH;

    e$1(e eVar) {
        this.jLH = eVar;
    }

    public final void run() {
        View view = this.jLH;
        if (view.getParent() instanceof ViewGroup) {
            view.animate().alpha(0.0f).withEndAction(new 2(this, view, (ViewGroup) view.getParent())).withStartAction(new 1(this)).start();
        }
    }
}
