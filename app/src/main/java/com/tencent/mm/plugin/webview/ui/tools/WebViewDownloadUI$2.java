package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.5;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class WebViewDownloadUI$2 implements OnClickListener {
    final /* synthetic */ String fgU;
    final /* synthetic */ String jdg;
    final /* synthetic */ String jkM;
    final /* synthetic */ String nbP;
    final /* synthetic */ String sdO;
    final /* synthetic */ WebViewDownloadUI txr;
    final /* synthetic */ String txs;
    final /* synthetic */ String txt;
    final /* synthetic */ String val$url;

    WebViewDownloadUI$2(WebViewDownloadUI webViewDownloadUI, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.txr = webViewDownloadUI;
        this.val$url = str;
        this.jkM = str2;
        this.jdg = str3;
        this.fgU = str4;
        this.sdO = str5;
        this.txs = str6;
        this.txt = str7;
        this.nbP = str8;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", new Object[]{WebViewDownloadUI.a(this.txr)});
        switch (5.txv[WebViewDownloadUI.a(this.txr).ordinal()]) {
            case 1:
                if (!an.isNetworkConnected(WebViewDownloadUI.b(this.txr))) {
                    Toast.makeText(WebViewDownloadUI.b(this.txr), this.txr.getString(R.l.emh), 0).show();
                    x.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
                    return;
                } else if (an.isWifi(WebViewDownloadUI.b(this.txr))) {
                    WebViewDownloadUI.a(this.txr, this.val$url, this.jkM, this.jdg, this.fgU, this.sdO, this.txs, this.txt, this.nbP);
                    return;
                } else {
                    g.pQN.h(14217, new Object[]{this.fgU, Integer.valueOf(4), this.txs, this.val$url, Integer.valueOf(0)});
                    h.a(this.txr, this.txr.getString(R.l.eWB), this.txr.getString(R.l.eWC), this.txr.getString(R.l.eWw), this.txr.getString(R.l.dEn), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WebViewDownloadUI$2 txu;

                        {
                            this.txu = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.pQN.h(14217, new Object[]{this.txu.fgU, Integer.valueOf(5), this.txu.txs, this.txu.val$url, Integer.valueOf(0)});
                            WebViewDownloadUI.a(this.txu.txr, this.txu.val$url, this.txu.jkM, this.txu.jdg, this.txu.fgU, this.txu.sdO, this.txu.txs, this.txu.txt, this.txu.nbP);
                            dialogInterface.dismiss();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WebViewDownloadUI$2 txu;

                        {
                            this.txu = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.pQN.h(14217, new Object[]{this.txu.fgU, Integer.valueOf(6), this.txu.txs, this.txu.val$url, Integer.valueOf(0)});
                            dialogInterface.dismiss();
                        }
                    }, R.e.bui);
                    return;
                }
            default:
                x.e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
                return;
        }
    }
}
