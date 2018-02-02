package com.tencent.mm.plugin.webview.ui.tools.emojistore;

class BaseEmojiStoreSearchWebViewUI$4 implements Runnable {
    final /* synthetic */ BaseEmojiStoreSearchWebViewUI tBL;

    BaseEmojiStoreSearchWebViewUI$4(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI) {
        this.tBL = baseEmojiStoreSearchWebViewUI;
    }

    public final void run() {
        if (BaseEmojiStoreSearchWebViewUI.b(this.tBL) != null) {
            BaseEmojiStoreSearchWebViewUI.c(this.tBL).bUs();
        }
    }
}
