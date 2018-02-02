package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.16;
import com.tencent.xweb.f;

class WebViewUI$16$8 implements OnClickListener {
    final /* synthetic */ f mZO;
    final /* synthetic */ 16 tBh;

    WebViewUI$16$8(16 16, f fVar) {
        this.tBh = 16;
        this.mZO = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mZO.cancel();
    }
}
