package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.28;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class WalletOfflineCoinPurseUI$28$2 extends g {
    final /* synthetic */ 28 oZb;
    final /* synthetic */ Bankcard oZe;

    WalletOfflineCoinPurseUI$28$2(28 28, Context context, Bankcard bankcard) {
        this.oZb = 28;
        this.oZe = bankcard;
        super(context);
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", new Object[]{this.oZe.field_forbid_url});
        intent.putExtra("rawUrl", r1);
        intent.putExtra("geta8key_username", q.FS());
        intent.putExtra("pay_channel", 1);
        d.b(this.oZb.oYH.mController.xIM, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
