package com.tencent.mm.plugin.wallet_payu.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wallet_core.ui.g.a;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements a {
    final /* synthetic */ Context val$context;

    c$2(Context context) {
        this.val$context = context;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.PayUUtil", "hy: user clicked the tos span");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?lang=en_US&check=false&t=weixin_agreement&s=terms");
        intent.putExtra("showShare", false);
        d.b(this.val$context, "webview", ".ui.tools.WebViewUI", intent);
    }
}
