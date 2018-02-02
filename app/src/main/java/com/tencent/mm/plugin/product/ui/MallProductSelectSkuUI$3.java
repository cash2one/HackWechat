package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.plugin.wxpay.a$i;

class MallProductSelectSkuUI$3 implements MallProductSelectAmountView$a {
    final /* synthetic */ MallProductSelectSkuUI pgr;

    MallProductSelectSkuUI$3(MallProductSelectSkuUI mallProductSelectSkuUI) {
        this.pgr = mallProductSelectSkuUI;
    }

    public final void es(int i) {
        MallProductSelectSkuUI.b(this.pgr).mCount = i;
        MallProductSelectSkuUI.c(this.pgr).setVisibility(8);
    }

    public final void di(int i, int i2) {
        switch (i2) {
            case 1:
                MallProductSelectSkuUI.c(this.pgr).setText(a$i.uLy);
                MallProductSelectSkuUI.c(this.pgr).setVisibility(0);
                return;
            case 3:
                MallProductSelectSkuUI.c(this.pgr).setText(this.pgr.getString(a$i.uLz, new Object[]{Integer.valueOf(i)}));
                MallProductSelectSkuUI.c(this.pgr).setVisibility(0);
                return;
            default:
                return;
        }
    }
}
