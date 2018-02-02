package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class WebViewUI$22 implements ValueCallback<String> {
    final /* synthetic */ WebViewUI tAv;
    final /* synthetic */ Intent val$intent;

    WebViewUI$22(WebViewUI webViewUI, Intent intent) {
        this.tAv = webViewUI;
        this.val$intent = intent;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        x.i("MicroMsg.WebViewUI", "onReceiveValue value = %s", new Object[]{str});
        if (!bh.ov(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optBoolean("ret")) {
                    this.val$intent.putExtra("title", jSONObject.optString("appName"));
                    this.val$intent.putExtra("thumb_url", jSONObject.optString("apkIconUrl"));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e, "onReceiveValue", new Object[0]);
            }
        }
        this.tAv.startActivity(this.val$intent);
    }
}
