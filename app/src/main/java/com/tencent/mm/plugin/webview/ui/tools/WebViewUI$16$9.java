package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.16;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.f;

class WebViewUI$16$9 implements OnDismissListener {
    final /* synthetic */ f mZO;
    final /* synthetic */ 16 tBh;
    final /* synthetic */ PBool tBi;

    WebViewUI$16$9(16 16, PBool pBool, f fVar) {
        this.tBh = 16;
        this.tBi = pBool;
        this.mZO = fVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        x.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
        if (!this.tBi.value) {
            this.mZO.cancel();
        }
    }
}
