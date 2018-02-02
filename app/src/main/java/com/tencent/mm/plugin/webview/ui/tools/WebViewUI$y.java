package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.aj.h;
import com.tencent.mm.plugin.webview.model.aj.i;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqvideo.proxy.api.IUtils;
import java.util.ArrayList;

class WebViewUI$y implements IUtils {
    final /* synthetic */ WebViewUI tAv;

    private WebViewUI$y(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void javaUtilLog(int i, String str, String str2) {
        switch (i) {
            case 2:
                x.v(str, str2);
                return;
            case 3:
                x.d(str, str2);
                return;
            case 4:
                x.i(str, str2);
                return;
            case 5:
                x.w(str, str2);
                return;
            case 6:
                x.e(str, str2);
                return;
            default:
                return;
        }
    }

    public final void httpproxyReport(String... strArr) {
        i bRf = this.tAv.trN.bRf();
        if (!(strArr == null || strArr.length == 0)) {
            if (bRf.ttc == null) {
                bRf.ttc = new ArrayList();
            } else {
                bRf.ttc.clear();
            }
            for (Object add : strArr) {
                x.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", new Object[]{strArr[r0]});
                bRf.ttc.add(add);
            }
        }
        i bRf2 = this.tAv.trN.bRf();
        d dVar = this.tAv.juQ;
        if (bRf2.ttc != null && bRf2.ttc.size() != 0 && dVar != null) {
            d.a(dVar, 12033, bRf2.ttc);
            bRf2.ttc.clear();
        }
    }

    public final void idKeyReport(String str, String str2, String str3) {
        x.i("MicroMsg.WebViewUI", "idkey report, id = %s, key = %s, value = %s", new Object[]{str, str2, str3});
        if (!bh.ov(str) && !bh.ov(str2) && !bh.ov(str3)) {
            g.pQN.a((long) bh.getInt(str, 0), (long) bh.getInt(str2, 0), (long) bh.getInt(str3, 0), false);
        }
    }

    public final void kvReport(String... strArr) {
        h bRg = this.tAv.trN.bRg();
        if (!(strArr == null || strArr.length == 0)) {
            if (bRg.ttc == null) {
                bRg.ttc = new ArrayList();
            } else {
                bRg.ttc.clear();
            }
            for (Object add : strArr) {
                x.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", new Object[]{strArr[r0]});
                bRg.ttc.add(add);
            }
        }
        h bRg2 = this.tAv.trN.bRg();
        d dVar = this.tAv.juQ;
        if (bRg2.ttc != null && bRg2.ttc.size() != 0 && dVar != null) {
            d.a(dVar, 12666, bRg2.ttc);
            bRg2.ttc.clear();
        }
    }
}
