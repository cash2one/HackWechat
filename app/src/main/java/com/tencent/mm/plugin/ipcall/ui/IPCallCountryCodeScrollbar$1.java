package com.tencent.mm.plugin.ipcall.ui;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.bv.a;

class IPCallCountryCodeScrollbar$1 implements Runnable {
    final /* synthetic */ int nJp;
    final /* synthetic */ int nJq;
    final /* synthetic */ IPCallCountryCodeScrollbar nJr;

    IPCallCountryCodeScrollbar$1(IPCallCountryCodeScrollbar iPCallCountryCodeScrollbar, int i, int i2) {
        this.nJr = iPCallCountryCodeScrollbar;
        this.nJp = i;
        this.nJq = i2;
    }

    public final void run() {
        if (this.nJr.nJi.length > 0) {
            int measureText = ((int) IPCallCountryCodeScrollbar.a(this.nJr).measureText(this.nJr.nJi[this.nJr.nJi.length - 1])) + a.fromDPToPix(this.nJr.getContext(), 8);
            if (measureText > this.nJp) {
                LayoutParams layoutParams = this.nJr.getLayoutParams();
                layoutParams.width = measureText;
                layoutParams.height = this.nJq;
                this.nJr.setLayoutParams(layoutParams);
            }
        }
    }
}
