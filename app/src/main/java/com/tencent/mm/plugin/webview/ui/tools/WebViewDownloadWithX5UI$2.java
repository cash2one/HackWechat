package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class WebViewDownloadWithX5UI$2 implements OnClickListener {
    final /* synthetic */ WebViewDownloadWithX5UI txA;
    final /* synthetic */ long txB;
    final /* synthetic */ String txs;
    final /* synthetic */ String val$url;

    WebViewDownloadWithX5UI$2(WebViewDownloadWithX5UI webViewDownloadWithX5UI, long j, String str, String str2) {
        this.txA = webViewDownloadWithX5UI;
        this.txB = j;
        this.val$url = str;
        this.txs = str2;
    }

    public final void onClick(View view) {
        if (an.isNetworkConnected(WebViewDownloadWithX5UI.a(this.txA))) {
            ar.Hg();
            if (!c.isSDCardAvailable()) {
                Toast.makeText(WebViewDownloadWithX5UI.a(this.txA), this.txA.getString(R.l.emj), 0).show();
                x.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, sdcard not ready");
                return;
            } else if (this.txB > 0 && !f.aC(this.txB)) {
                Toast.makeText(WebViewDownloadWithX5UI.a(this.txA), this.txA.getString(R.l.emi), 0).show();
                x.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, not enough space, require size = " + this.txB);
                return;
            } else if (an.isWifi(WebViewDownloadWithX5UI.a(this.txA))) {
                WebViewDownloadWithX5UI.a(this.txA, this.val$url, this.txs);
                return;
            } else {
                g.pQN.h(14217, new Object[]{"", Integer.valueOf(4), this.txs, this.val$url, Integer.valueOf(1)});
                h.a(this.txA, this.txA.getString(R.l.eWB), this.txA.getString(R.l.eWC), this.txA.getString(R.l.eWw), this.txA.getString(R.l.dEn), false, new 1(this), new 2(this), R.e.bui);
                return;
            }
        }
        Toast.makeText(WebViewDownloadWithX5UI.a(this.txA), this.txA.getString(R.l.emh), 0).show();
        x.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, network not ready");
    }
}
