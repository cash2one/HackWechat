package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.chatting.gallery.j.2;

class j$2$1 implements Runnable {
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ 2 yGC;

    j$2$1(2 2, Intent intent) {
        this.yGC = 2;
        this.val$intent = intent;
    }

    public final void run() {
        d.b(this.yGC.yGA.yDo.yCS.mController.xIM, "webview", ".ui.tools.WebViewUI", this.val$intent);
    }
}
