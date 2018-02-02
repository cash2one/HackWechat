package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class WebViewDownloadUI$3 implements OnClickListener {
    final /* synthetic */ String fgU;
    final /* synthetic */ WebViewDownloadUI txr;
    final /* synthetic */ String txs;
    final /* synthetic */ String val$url;

    WebViewDownloadUI$3(WebViewDownloadUI webViewDownloadUI, String str, String str2, String str3) {
        this.txr = webViewDownloadUI;
        this.fgU = str;
        this.txs = str2;
        this.val$url = str3;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", Long.valueOf(WebViewDownloadUI.c(this.txr)), WebViewDownloadUI.a(this.txr));
        g.pQN.h(14217, this.fgU, Integer.valueOf(3), this.txs, this.val$url, Integer.valueOf(0));
        if (WebViewDownloadUI.c(this.txr) <= 0) {
            x.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
        } else {
            x.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", Integer.valueOf(f.aAd().bX(WebViewDownloadUI.c(this.txr))));
            if (f.aAd().bX(WebViewDownloadUI.c(this.txr)) > 0) {
                Toast.makeText(this.txr.mController.xIM, this.txr.getString(R.l.eWz), 1).show();
                this.txr.finish();
                return;
            }
        }
        Toast.makeText(this.txr.mController.xIM, this.txr.getString(R.l.eWy), 1).show();
    }
}
