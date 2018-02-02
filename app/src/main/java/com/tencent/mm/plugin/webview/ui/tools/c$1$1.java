package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.ui.tools.c.1;
import com.tencent.mm.sdk.platformtools.x;

class c$1$1 implements OnCancelListener {
    final /* synthetic */ 1 twH;

    c$1$1(1 1) {
        this.twH = 1;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        try {
            dialogInterface.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.OAuthSession", "onCancel, ex = " + e.getMessage());
        }
    }
}
