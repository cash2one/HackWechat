package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class RechargeUI$11 implements OnClickListener {
    final /* synthetic */ RechargeUI pDQ;

    RechargeUI$11(RechargeUI rechargeUI) {
        this.pDQ = rechargeUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", RechargeUI.a(this.pDQ));
        d.b(this.pDQ, "webview", ".ui.tools.WebViewUI", intent);
    }
}
