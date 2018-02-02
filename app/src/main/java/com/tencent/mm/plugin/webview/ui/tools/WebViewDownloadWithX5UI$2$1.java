package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI.2;

class WebViewDownloadWithX5UI$2$1 implements OnClickListener {
    final /* synthetic */ 2 txC;

    WebViewDownloadWithX5UI$2$1(2 2) {
        this.txC = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(14217, "", Integer.valueOf(5), this.txC.txs, this.txC.val$url, Integer.valueOf(1));
        WebViewDownloadWithX5UI.a(this.txC.txA, this.txC.val$url, this.txC.txs);
        dialogInterface.dismiss();
    }
}
