package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class ProtocolThreeOneUI$4 implements OnClickListener {
    final /* synthetic */ ProtocolThreeOneUI mIQ;

    ProtocolThreeOneUI$4(ProtocolThreeOneUI protocolThreeOneUI) {
        this.mIQ = protocolThreeOneUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mIQ.mHs);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.mIQ.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
