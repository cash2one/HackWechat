package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class OAuthUI$7 implements a {
    final /* synthetic */ OAuthUI twM;

    OAuthUI$7(OAuthUI oAuthUI) {
        this.twM = oAuthUI;
    }

    public final void a(c cVar, String str, boolean z) {
        x.i("MicroMsg.OAuthUI", "onResult, url = " + str + ", isShowLocalErrorPage = " + z);
        if (cVar != null) {
            cVar.twD = false;
        }
        if (z) {
            String string;
            try {
                string = this.twM.getString(R.l.ezG);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.OAuthUI", e, "", new Object[0]);
                string = null;
            }
            x.i("MicroMsg.OAuthUI", "onResult, html = " + string);
            if (this.twM.ptK != null) {
                this.twM.ptK.loadUrl(string);
                if (this.twM.trN != null) {
                    this.twM.trN.bRa().fIG = string;
                }
            }
        } else if (!bh.ov(str) && this.twM.ptK != null) {
            this.twM.ptK.loadUrl(str);
            if (this.twM.trN != null) {
                this.twM.trN.bRa().fIG = str;
            }
        }
    }

    public final void c(boolean z, String str, String str2, String str3) {
        if (z) {
            OAuthUI.a(this.twM, str2, str3, str);
        } else {
            OAuthUI.b(this.twM, str3);
        }
    }
}
