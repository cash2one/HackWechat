package com.tencent.mm.ui.chatting;

import com.tencent.mm.pluginsdk.e;

class AppBrandServiceChattingUI$2 implements Runnable {
    final /* synthetic */ AppBrandServiceChattingUI ypO;

    AppBrandServiceChattingUI$2(AppBrandServiceChattingUI appBrandServiceChattingUI) {
        this.ypO = appBrandServiceChattingUI;
    }

    public final void run() {
        if (this.ypO.ypM != null) {
            e.a(this.ypO, this.ypO.ypM.getBodyView());
        }
    }
}
