package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.16;
import com.tencent.mm.pointers.PBool;
import com.tencent.xweb.f;

class WebViewUI$16$11 implements OnClickListener {
    final /* synthetic */ f mZO;
    final /* synthetic */ 16 tBh;
    final /* synthetic */ PBool tBi;

    WebViewUI$16$11(16 16, PBool pBool, f fVar) {
        this.tBh = 16;
        this.tBi = pBool;
        this.mZO = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.tBi.value = true;
        this.mZO.confirm();
    }
}
