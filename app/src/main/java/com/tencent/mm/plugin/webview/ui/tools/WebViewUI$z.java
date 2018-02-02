package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.net.URLDecoder;

class WebViewUI$z implements b {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$z(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://private/gethtml/");
    }

    public final boolean BU(String str) {
        try {
            String decode = URLDecoder.decode(str.substring(25));
            Bundle bundle = new Bundle();
            bundle.putString("nowUrl", WebViewUI.aO(this.tAv));
            bundle.putString("tweetid", bh.ou(this.tAv.getIntent().getStringExtra("tweetid")));
            bundle.putString("htmlData", decode);
            bundle.putInt(DownloadSettingTable$Columns.TYPE, this.tAv.getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0));
            this.tAv.juQ.a(3, bundle, this.tAv.hashCode());
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "edw ViewImageGetHtmlHandler handleUrl, ex = " + e.getMessage());
            return false;
        }
    }
}
