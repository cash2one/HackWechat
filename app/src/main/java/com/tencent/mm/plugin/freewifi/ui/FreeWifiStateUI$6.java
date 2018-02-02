package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class FreeWifiStateUI$6 implements OnClickListener {
    final /* synthetic */ FreeWifiStateUI mIt;

    FreeWifiStateUI$6(FreeWifiStateUI freeWifiStateUI) {
        this.mIt = freeWifiStateUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mIt.mHs);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.mIt.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
