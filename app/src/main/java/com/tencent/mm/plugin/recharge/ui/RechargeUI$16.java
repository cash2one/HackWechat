package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.q;

class RechargeUI$16 implements OnClickListener {
    final /* synthetic */ RechargeUI pDQ;

    RechargeUI$16(RechargeUI rechargeUI) {
        this.pDQ = rechargeUI;
    }

    public final void onClick(View view) {
        if (!bh.ov(RechargeUI.h(this.pDQ).sQt.sQD)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", RechargeUI.h(this.pDQ).sQt.sQD);
            intent.putExtra("geta8key_username", q.FS());
            d.b(this.pDQ, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }
}
