package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class FreeWifiFrontPageUI$4 implements OnClickListener {
    final /* synthetic */ FreeWifiFrontPageUI mHw;

    FreeWifiFrontPageUI$4(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        this.mHw = freeWifiFrontPageUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mHw.mHs);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.mHw.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
