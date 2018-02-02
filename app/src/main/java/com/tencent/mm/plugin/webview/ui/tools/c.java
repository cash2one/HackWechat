package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;

final class c {
    ak hkO = new ak(new 1(this), false);
    d juQ;
    r mIl;
    boolean twC = false;
    boolean twD = false;
    final a twE;
    OAuthUI twF;

    private c(OAuthUI oAuthUI, a aVar, d dVar) {
        this.twF = oAuthUI;
        this.twE = aVar;
        this.juQ = dVar;
    }

    public static c a(OAuthUI oAuthUI, String str, Req req, a aVar, d dVar) {
        c cVar = new c(oAuthUI, aVar, dVar);
        String str2 = req.scope;
        String str3 = req.state;
        if (cVar.twC) {
            x.e("MicroMsg.OAuthSession", "already getting");
        } else {
            cVar.twD = true;
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_appid", str);
            bundle.putString("geta8key_data_scope", str2);
            bundle.putString("geta8key_data_state", str3);
            try {
                cVar.juQ.r(233, bundle);
                cVar.twC = true;
            } catch (Exception e) {
                x.w("MicroMsg.OAuthSession", "startGetA8Key, ex = " + e.getMessage());
            }
            cVar.hkO.J(3000, 3000);
        }
        return cVar;
    }
}
