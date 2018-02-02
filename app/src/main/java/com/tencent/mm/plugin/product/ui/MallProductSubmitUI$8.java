package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class MallProductSubmitUI$8 implements OnItemClickListener {
    final /* synthetic */ MallProductSubmitUI pgR;

    MallProductSubmitUI$8(MallProductSubmitUI mallProductSubmitUI) {
        this.pgR = mallProductSubmitUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.pgR.dismissDialog(1);
        MallProductSubmitUI.b(this.pgR).uC(i);
        MallProductSubmitUI.a(this.pgR);
    }
}
