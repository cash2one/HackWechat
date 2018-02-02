package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

class WebViewUI$u implements b {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$u(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final boolean BT(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return s.eE(str, "weixin://readershare/");
    }

    public final boolean BU(String str) {
        h.a(this.tAv, "", new String[]{this.tAv.getString(R.l.eBY)}, "", new c(this) {
            final /* synthetic */ WebViewUI$u tBC;

            {
                this.tBC = r1;
            }

            public final void jl(int i) {
                if (i == 0) {
                    WebViewUI$u webViewUI$u = this.tBC;
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("shortUrl", webViewUI$u.tAv.getIntent().getStringExtra("shortUrl"));
                        bundle.putInt(DownloadSettingTable$Columns.TYPE, webViewUI$u.tAv.getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0));
                        webViewUI$u.tAv.juQ.a(4, bundle, webViewUI$u.hashCode());
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewUI", "share fail, ex = " + e.getMessage());
                    }
                }
            }
        });
        return true;
    }
}
