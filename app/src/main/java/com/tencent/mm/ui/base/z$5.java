package com.tencent.mm.ui.base;

import android.view.ViewTreeObserver.OnPreDrawListener;

class z$5 implements OnPreDrawListener {
    final /* synthetic */ z yhd;

    z$5(z zVar) {
        this.yhd = zVar;
    }

    public final boolean onPreDraw() {
        if (this.yhd.ygY) {
            this.yhd.ygY = false;
            z zVar = this.yhd;
            zVar.kO.removeCallbacks(zVar.yhb);
            zVar.kO.postDelayed(zVar.yhb, 100);
        }
        return true;
    }
}
