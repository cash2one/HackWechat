package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class ad {
    private static ad tsv = new ad();
    HashMap<String, WebViewJSSDKFileItem> tsw = new HashMap();

    public static final ad bQP() {
        return tsv;
    }

    public final void b(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        if (webViewJSSDKFileItem == null || bh.ov(webViewJSSDKFileItem.fus)) {
            x.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
            return;
        }
        x.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", new Object[]{webViewJSSDKFileItem.fus, webViewJSSDKFileItem.iLu});
        this.tsw.put(webViewJSSDKFileItem.fus, webViewJSSDKFileItem);
    }

    public final WebViewJSSDKFileItem Oo(String str) {
        if (!bh.ov(str)) {
            return (WebViewJSSDKFileItem) this.tsw.get(str);
        }
        x.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
        return null;
    }
}
