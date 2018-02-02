package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.collect.ui.CollectBillUI.1;
import com.tencent.mm.protocal.c.cm;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;

class CollectBillUI$1$1 implements OnClickListener {
    final /* synthetic */ cm llW;
    final /* synthetic */ 1 llX;

    CollectBillUI$1$1(1 1, cm cmVar) {
        this.llX = 1;
        this.llW = cmVar;
    }

    public final void onClick(View view) {
        if (!bh.ov(this.llW.url)) {
            e.l(this.llX.llV.mController.xIM, this.llW.url, true);
        }
    }
}
