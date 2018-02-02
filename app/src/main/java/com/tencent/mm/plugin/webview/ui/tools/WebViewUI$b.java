package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$b implements b {
    final /* synthetic */ WebViewUI tAv;
    public final String tBt;

    private WebViewUI$b(WebViewUI webViewUI) {
        this.tAv = webViewUI;
        this.tBt = "weixin://addfriend/";
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://addfriend/");
    }

    public final boolean BU(String str) {
        if (this.tAv.juR.bSs().gn(5)) {
            String substring = str.substring(19);
            if (bh.ov(substring)) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("from_webview", true);
            bundle.putString("userName", substring);
            try {
                this.tAv.juQ.a(8, bundle, this.tAv.hashCode());
                return true;
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "AddFriendHandler, ex = " + e.getMessage());
                return true;
            }
        }
        x.e("MicroMsg.WebViewUI", "AddFriendHandler, permission fail");
        return true;
    }
}
