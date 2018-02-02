package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.16;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$16$1 implements OnClickListener {
    final /* synthetic */ Callback mZL;
    final /* synthetic */ String mZM;
    final /* synthetic */ 16 tBh;

    WebViewUI$16$1(16 16, Callback callback, String str) {
        this.tBh = 16;
        this.mZL = callback;
        this.mZM = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok, origin = %s");
        this.mZL.invoke(this.mZM, true, false);
        d.a(this.tBh.tAv.juQ, 14340, this.tBh.tAv.fIG, this.tBh.tAv.aPk(), Integer.valueOf(WebViewUI.J(this.tBh.tAv)), this.tBh.tAv.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(aj.bQU()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
    }
}
