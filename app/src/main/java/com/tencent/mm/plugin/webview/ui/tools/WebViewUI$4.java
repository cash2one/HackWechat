package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Color;
import android.webkit.ValueCallback;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$4 implements ValueCallback<String> {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$4(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        x.d("MicroMsg.WebViewUI", "get background color s = %s", new Object[]{str});
        if (!bh.ov(str)) {
            int color = this.tAv.getResources().getColor(R.e.buh);
            String[] split;
            if (WebViewUI.aPr().matcher(str).matches()) {
                split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                if (split.length == 4) {
                    try {
                        color = Color.argb(bh.getInt(bh.ou(split[3]).trim(), 0), bh.getInt(bh.ou(split[0]).trim(), 0), bh.getInt(bh.ou(split[1]).trim(), 0), bh.getInt(bh.ou(split[2]).trim(), 0));
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e});
                        return;
                    }
                }
                return;
            } else if (WebViewUI.bTg().matcher(str).matches()) {
                split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                if (split.length == 3) {
                    try {
                        color = Color.argb(255, bh.getInt(bh.ou(split[0]).trim(), 0), bh.getInt(bh.ou(split[1]).trim(), 0), bh.getInt(bh.ou(split[2]).trim(), 0));
                    } catch (Exception e2) {
                        x.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e2});
                        return;
                    }
                }
                return;
            } else {
                x.d("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, can not match", new Object[]{str});
            }
            WebViewUI.o(this.tAv).AF(color);
            WebViewUI.o(this.tAv).bSv();
        }
    }
}
