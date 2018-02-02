package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.a;
import com.tencent.mm.sdk.platformtools.x;

class BaseSearchWebviewUI$1 implements a {
    final /* synthetic */ BaseSearchWebviewUI tCD;

    BaseSearchWebviewUI$1(BaseSearchWebviewUI baseSearchWebviewUI) {
        this.tCD = baseSearchWebviewUI;
    }

    public final void onReady() {
        BaseSearchWebviewUI.a(this.tCD);
        x.d("BaseSearchWebviewUI", "jsapi ready");
        int i = this.tCD.scene;
        String str = this.tCD.fqu;
        str = this.tCD.tjs;
    }
}
