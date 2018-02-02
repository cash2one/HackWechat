package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class BaseEmojiStoreSearchWebViewUI$1 implements OnTouchListener {
    final /* synthetic */ BaseEmojiStoreSearchWebViewUI tBL;

    BaseEmojiStoreSearchWebViewUI$1(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI) {
        this.tBL = baseEmojiStoreSearchWebViewUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.tBL.aWs();
        return false;
    }
}
