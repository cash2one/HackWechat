package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class f$1 implements OnClickListener {
    final /* synthetic */ f sTc;

    f$1(f fVar) {
        this.sTc = fVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof String) {
            Intent intent = new Intent();
            x.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", new Object[]{(String) view.getTag()});
            intent.putExtra("rawUrl", r0);
            intent.putExtra("geta8key_username", q.FS());
            intent.putExtra("pay_channel", 1);
            d.b(f.a(this.sTc), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, WalletChangeBankcardUI.sEK);
        }
    }
}
