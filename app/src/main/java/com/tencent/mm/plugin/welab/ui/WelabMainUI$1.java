package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.sdk.platformtools.w;

class WelabMainUI$1 implements OnClickListener {
    final /* synthetic */ WelabMainUI tQc;

    WelabMainUI$1(WelabMainUI welabMainUI) {
        this.tQc = welabMainUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("title", view.getResources().getString(d.tPv));
        intent.putExtra("rawUrl", this.tQc.mController.xIM.getString(d.tPr, new Object[]{w.cfi(), Integer.valueOf(com.tencent.mm.protocal.d.vAz)}));
        intent.putExtra("showShare", false);
        com.tencent.mm.bm.d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }
}
