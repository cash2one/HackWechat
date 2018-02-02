package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;

class MallProductSelectAmountView$1 implements OnClickListener {
    final /* synthetic */ MallProductSelectAmountView pgi;

    MallProductSelectAmountView$1(MallProductSelectAmountView mallProductSelectAmountView) {
        this.pgi = mallProductSelectAmountView;
    }

    public final void onClick(View view) {
        if (MallProductSelectAmountView.a(this.pgi) + 1 <= MallProductSelectAmountView.b(this.pgi)) {
            MallProductSelectAmountView.e(this.pgi);
            if (MallProductSelectAmountView.f(this.pgi)) {
                MallProductSelectAmountView.g(this.pgi).setText(MallProductSelectAmountView.a(this.pgi));
            }
            if (MallProductSelectAmountView.c(this.pgi) != null) {
                MallProductSelectAmountView.c(this.pgi).es(MallProductSelectAmountView.a(this.pgi));
            }
        } else if (MallProductSelectAmountView.c(this.pgi) != null) {
            MallProductSelectAmountView.c(this.pgi).di(MallProductSelectAmountView.a(this.pgi), MallProductSelectAmountView.d(this.pgi));
        }
    }
}
