package com.tencent.mm.plugin.webview.ui.tools;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$w implements b {
    final /* synthetic */ WebViewUI tAv;
    private final String tBv;

    private WebViewUI$w(WebViewUI webViewUI) {
        this.tAv = webViewUI;
        this.tBv = "weixin://openapi/openwebview/result?";
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://openapi/openwebview/result?");
    }

    public final boolean BU(String str) {
        Resp resp = new Resp();
        Uri parse = Uri.parse(str);
        resp.result = parse.getQuery();
        resp.errCode = bh.getInt(parse.getQueryParameter("errCode"), 0);
        resp.errStr = parse.getQueryParameter("errMsg");
        resp.transaction = this.tAv.getIntent().getStringExtra("transaction_for_openapi_openwebview");
        String queryParameter = parse.getQueryParameter("appid");
        if (bh.ov(queryParameter)) {
            x.e("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler handleUrl, appId is null");
        } else {
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            p.ae(bundle);
            Args args = new Args();
            try {
                args.targetPkgName = this.tAv.juQ.OP(queryParameter);
                args.bundle = bundle;
                x.d("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[]{args});
                MMessageActV2.send(this.tAv, args);
                this.tAv.finish();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
            }
        }
        return true;
    }
}
