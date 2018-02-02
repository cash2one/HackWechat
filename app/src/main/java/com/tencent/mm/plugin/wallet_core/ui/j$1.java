package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class j$1 implements OnClickListener {
    final /* synthetic */ String sTO;
    final /* synthetic */ Context val$context;

    j$1(String str, Context context) {
        this.sTO = str;
        this.val$context = context;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        x.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[]{this.sTO});
        intent.putExtra("rawUrl", r1);
        intent.putExtra("geta8key_username", q.FS());
        intent.putExtra("pay_channel", 1);
        d.b(this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
