package com.tencent.mm.ui;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;

class z$4 implements Runnable {
    final /* synthetic */ z xLL;
    final /* synthetic */ int[] xLN;
    final /* synthetic */ FitSystemWindowLayoutView xLO;
    final /* synthetic */ ViewGroup xLP;

    z$4(z zVar, int[] iArr, FitSystemWindowLayoutView fitSystemWindowLayoutView, ViewGroup viewGroup) {
        this.xLL = zVar;
        this.xLN = iArr;
        this.xLO = fitSystemWindowLayoutView;
        this.xLP = viewGroup;
    }

    public final void run() {
        this.xLL.qwI.getSupportActionBar().getCustomView().getLocationInWindow(this.xLN);
        int i = this.xLN[1];
        if (i > 0) {
            this.xLL.xLy.a(this.xLO, new Rect(0, i, 0, 0), this.xLP);
        } else if (d.fM(20)) {
            this.xLO.setOnApplyWindowInsetsListener(new 1(this));
        }
    }
}
