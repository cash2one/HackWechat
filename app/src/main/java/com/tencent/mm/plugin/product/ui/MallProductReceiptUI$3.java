package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.product.b.d;

class MallProductReceiptUI$3 implements OnClickListener {
    final /* synthetic */ MallProductReceiptUI pga;

    MallProductReceiptUI$3(MallProductReceiptUI mallProductReceiptUI) {
        this.pga = mallProductReceiptUI;
    }

    public final void onClick(View view) {
        d c = MallProductReceiptUI.c(this.pga);
        c.pec.clear();
        c.bjh();
        MallProductReceiptUI.d(this.pga).notifyDataSetChanged();
    }
}
