package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.base.i.a.a;

class SelectConversationUI$5 implements a {
    final /* synthetic */ String val$url;
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$5(SelectConversationUI selectConversationUI, String str) {
        this.zpv = selectConversationUI;
        this.val$url = str;
    }

    public final void aJL() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.val$url);
        intent.putExtra("showShare", false);
        d.b(this.zpv.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
