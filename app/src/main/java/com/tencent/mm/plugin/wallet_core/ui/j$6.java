package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class j$6 implements OnClickListener {
    final /* synthetic */ ECardInfo sTP;
    final /* synthetic */ Context val$context;

    public j$6(ECardInfo eCardInfo, Context context) {
        this.sTP = eCardInfo;
        this.val$context = context;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        x.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[]{this.sTP.sMn});
        intent.putExtra("rawUrl", r1);
        intent.putExtra("geta8key_username", q.FS());
        intent.putExtra("pay_channel", 1);
        d.b(this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
