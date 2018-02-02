package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class SDKOAuthUI$3 implements OnClickListener {
    final /* synthetic */ String hnj;
    final /* synthetic */ SDKOAuthUI txf;

    SDKOAuthUI$3(SDKOAuthUI sDKOAuthUI, String str) {
        this.txf = sDKOAuthUI;
        this.hnj = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SDKOAuthUI.b(this.txf, this.hnj);
    }
}
