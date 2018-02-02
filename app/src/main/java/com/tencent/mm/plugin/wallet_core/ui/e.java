package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

public final class e extends p {
    private Context context;

    public e(Context context) {
        this.context = context;
    }

    public final boolean b(WebView webView, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        x.d("MicroMsg.ProtoColWebViewClient", "raw url: %s", new Object[]{intent.getStringExtra("rawUrl")});
        d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }
}
