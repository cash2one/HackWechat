package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewGroup;

class d$3 implements Runnable {
    final /* synthetic */ d jLi;

    d$3(d dVar) {
        this.jLi = dVar;
    }

    public final void run() {
        this.jLi.setVisibility(8);
        if (this.jLi.getParent() != null) {
            ((ViewGroup) this.jLi.getParent()).removeView(this.jLi);
        }
    }
}
