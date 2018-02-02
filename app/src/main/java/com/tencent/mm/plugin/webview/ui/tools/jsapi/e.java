package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.Base64;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

public final class e implements b {
    private MMWebView juE;
    private d tFj;

    public e(MMWebView mMWebView, d dVar) {
        this.juE = mMWebView;
        this.tFj = dVar;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://private/setresult/");
    }

    public final boolean BU(String str) {
        String str2 = null;
        if (this.juE != null) {
            this.juE.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
        }
        String substring = str.substring(27);
        if (bh.ov(substring)) {
            x.e("MicroMsg.JsApiResultHandler", "SetResultHandler handleUrl fail, value is null");
            return false;
        }
        int indexOf = substring.indexOf("&");
        if (indexOf <= 0) {
            x.e("MicroMsg.JsApiResultHandler", "SetResultHandler, handleUrl fail, invalid splitorIdx = %d", new Object[]{Integer.valueOf(indexOf)});
            return false;
        }
        byte[] decode;
        String substring2 = substring.substring(0, indexOf);
        try {
            decode = Base64.decode(substring.substring(indexOf + 1), 0);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiResultHandler", "SetResultHandler decodeBase64 failed");
            decode = null;
        }
        if (decode != null) {
            str2 = new String(decode);
        }
        x.i("MicroMsg.JsApiResultHandler", "SetResultHandler, scene = %s, result = %s", new Object[]{substring2, str2});
        this.tFj.keep_setReturnValue(substring2, str2);
        return true;
    }
}
