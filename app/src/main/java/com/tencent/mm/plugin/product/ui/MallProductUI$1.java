package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.plugin.product.ui.f.a;

class MallProductUI$1 implements a {
    final /* synthetic */ MallProductUI phb;

    MallProductUI$1(MallProductUI mallProductUI) {
        this.phb = mallProductUI;
    }

    public final void m(int i, int i2, String str) {
        if (i == 0 && i2 == 0) {
            this.phb.au();
            if (MallProductUI.a(this.phb) != null) {
                MallProductUI.a(this.phb).postDelayed(new 1(this), 200);
            }
        } else if (i2 == -10010003) {
            this.phb.uD(0);
            MallProductUI.b(this.phb).setVisibility(8);
            MallProductUI.c(this.phb).setVisibility(0);
            MallProductUI.d(this.phb);
        } else {
            this.phb.Ht(str);
        }
    }
}
