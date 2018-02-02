package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;

class BaseAppBrandRecentView$c$1 implements Runnable {
    final /* synthetic */ c kfB;

    BaseAppBrandRecentView$c$1(c cVar) {
        this.kfB = cVar;
    }

    public final void run() {
        if (this.kfB.kfw.kfc != null) {
            this.kfB.kfw.kfc.ms(this.kfB.kfw.anY().size());
        }
        this.kfB.kfw.fm().UR.notifyChanged();
    }
}
