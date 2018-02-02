package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class SDKOAuthUI$5 implements a {
    final /* synthetic */ SDKOAuthUI txf;

    SDKOAuthUI$5(SDKOAuthUI sDKOAuthUI) {
        this.txf = sDKOAuthUI;
    }

    public final boolean uF() {
        if (this.txf.isFinishing()) {
            x.i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
        } else {
            SDKOAuthUI.e(this.txf);
        }
        return false;
    }
}
