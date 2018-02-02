package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class MallProductSubmitUI$6 implements OnClickListener {
    final /* synthetic */ MallProductSubmitUI pgR;

    MallProductSubmitUI$6(MallProductSubmitUI mallProductSubmitUI) {
        this.pgR = mallProductSubmitUI;
    }

    public final void onClick(View view) {
        f d = MallProductSubmitUI.d(this.pgR);
        d.iQz.startActivityForResult(new Intent(d.iQz, MallProductReceiptUI.class), 4);
    }
}
