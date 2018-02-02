package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class ProtocolThreeTwoUI$6 implements OnClickListener {
    final /* synthetic */ ProtocolThreeTwoUI mIW;

    ProtocolThreeTwoUI$6(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.mIW = protocolThreeTwoUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mIW.mHs);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.mIW.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
