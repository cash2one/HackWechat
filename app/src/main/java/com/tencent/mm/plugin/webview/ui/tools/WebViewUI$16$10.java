package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.16;
import com.tencent.xweb.f;

class WebViewUI$16$10 implements OnClickListener {
    final /* synthetic */ f mZO;
    final /* synthetic */ 16 tBh;
    final /* synthetic */ String val$url;

    WebViewUI$16$10(16 16, String str, f fVar) {
        this.tBh = 16;
        this.val$url = str;
        this.mZO = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(11683, new Object[]{this.val$url, Integer.valueOf(1), Integer.valueOf(this.tBh.tAv.mZs)});
        this.mZO.cancel();
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.tBh.tAv.finish();
    }
}
