package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class FreeWifiPcUI$3 implements OnClickListener {
    final /* synthetic */ FreeWifiPcUI mIm;

    FreeWifiPcUI$3(FreeWifiPcUI freeWifiPcUI) {
        this.mIm = freeWifiPcUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", FreeWifiPcUI.f(this.mIm));
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.mIm.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
