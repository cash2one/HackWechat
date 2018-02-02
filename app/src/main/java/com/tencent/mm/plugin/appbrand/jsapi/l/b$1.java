package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.t.5;

class b$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ p jdJ;
    final /* synthetic */ int jrA;
    final /* synthetic */ long jrB;
    final /* synthetic */ b jrC;

    b$1(b bVar, p pVar, int i, long j, int i2) {
        this.jrC = bVar;
        this.jdJ = pVar;
        this.jrA = i;
        this.jrB = j;
        this.gOK = i2;
    }

    public final void run() {
        t tVar = this.jdJ.jDS;
        int i = this.jrA;
        long j = this.jrB;
        if (tVar.jEX != null) {
            tVar.jEX.cancel();
            tVar.jEX = null;
        }
        Animator ofInt = ValueAnimator.ofInt(new int[]{tVar.getView().getScrollY(), i});
        ofInt.addUpdateListener(new 5(tVar));
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.start();
        tVar.jEX = ofInt;
        this.jdJ.E(this.gOK, this.jrC.e("ok", null));
    }
}
