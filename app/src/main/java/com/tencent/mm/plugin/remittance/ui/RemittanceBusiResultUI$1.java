package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;

class RemittanceBusiResultUI$1 implements OnClickListener {
    final /* synthetic */ RemittanceBusiResultUI pNo;

    RemittanceBusiResultUI$1(RemittanceBusiResultUI remittanceBusiResultUI) {
        this.pNo = remittanceBusiResultUI;
    }

    public final void onClick(View view) {
        this.pNo.finish();
    }
}
