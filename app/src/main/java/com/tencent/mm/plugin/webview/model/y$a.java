package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.platformtools.x;

public final class y$a {
    public static Bundle bQK() {
        x.d("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths : %s", g.zZ().F("WebViewConfig", "oauthHostPath"));
        Bundle bundle = new Bundle();
        bundle.putString("oauth_host_paths", r0);
        return bundle;
    }
}
