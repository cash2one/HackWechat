package com.tencent.mm.ui.base;

import android.view.ViewTreeObserver.OnScrollChangedListener;

class z$6 implements OnScrollChangedListener {
    final /* synthetic */ z yhd;

    z$6(z zVar) {
        this.yhd = zVar;
    }

    public final void onScrollChanged() {
        if (!this.yhd.ygY && !this.yhd.fJl) {
            this.yhd.ygY = true;
            if (this.yhd.ygR != null) {
                this.yhd.ygR.cro();
            }
            if (this.yhd.ygM != null) {
                this.yhd.ygM.yhg.dismiss();
            }
            if (this.yhd.ygN != null) {
                this.yhd.ygN.yhg.dismiss();
            }
        }
    }
}
