package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;

class CollectBillListUI$5 implements OnClickListener {
    final /* synthetic */ CollectBillListUI llF;

    CollectBillListUI$5(CollectBillListUI collectBillListUI) {
        this.llF = collectBillListUI;
    }

    public final void onClick(View view) {
        CollectBillListUI.d(this.llF).dismiss();
    }
}
