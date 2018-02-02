package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

class BaseEmojiStoreSearchWebViewUI$a extends i {
    final /* synthetic */ BaseEmojiStoreSearchWebViewUI tBL;

    private BaseEmojiStoreSearchWebViewUI$a(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI) {
        this.tBL = baseEmojiStoreSearchWebViewUI;
        super(baseEmojiStoreSearchWebViewUI);
    }

    public final void a(WebView webView, String str) {
        x.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", str);
        super.a(webView, str);
        this.tBL.showOptionMenu(false);
        BaseEmojiStoreSearchWebViewUI.a(this.tBL).ZR(this.tBL.fDj);
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        this.tBL.showOptionMenu(false);
    }
}
