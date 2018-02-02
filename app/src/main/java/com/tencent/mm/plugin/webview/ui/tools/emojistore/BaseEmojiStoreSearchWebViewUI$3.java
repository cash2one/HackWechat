package com.tencent.mm.plugin.webview.ui.tools.emojistore;

class BaseEmojiStoreSearchWebViewUI$3 implements Runnable {
    final /* synthetic */ BaseEmojiStoreSearchWebViewUI tBL;

    BaseEmojiStoreSearchWebViewUI$3(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI) {
        this.tBL = baseEmojiStoreSearchWebViewUI;
    }

    public final void run() {
        BaseEmojiStoreSearchWebViewUI.a(this.tBL).clearFocus();
        this.tBL.aWs();
    }
}
