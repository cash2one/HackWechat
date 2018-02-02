package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.y.b;
import com.tencent.mm.sdk.platformtools.x;

class y$c$1 implements OnCancelListener {
    final /* synthetic */ y$d tsl;
    final /* synthetic */ b tsm;

    y$c$1(y$d com_tencent_mm_plugin_webview_model_y_d, b bVar) {
        this.tsl = com_tencent_mm_plugin_webview_model_y_d;
        this.tsm = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize user cancel");
        this.tsl.aCx();
        this.tsm.remove(1254);
    }
}
