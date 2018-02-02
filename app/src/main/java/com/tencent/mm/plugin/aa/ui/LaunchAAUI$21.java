package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class LaunchAAUI$21 implements OnClickListener {
    final /* synthetic */ LaunchAAUI ijW;
    final /* synthetic */ String val$url;

    LaunchAAUI$21(LaunchAAUI launchAAUI, String str) {
        this.ijW = launchAAUI;
        this.val$url = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.val$url);
        d.b(this.ijW.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
