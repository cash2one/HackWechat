package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.regex.Pattern;

class WebViewUI$17 implements DownloadListener {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$17(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        int i = 1;
        x.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + str + ", mimetype = " + str4 + ", userAgent = " + str2);
        int intExtra = this.tAv.getIntent().getIntExtra("key_download_restrict", 0);
        if (!bh.ov(this.tAv.getIntent().getStringExtra("key_function_id"))) {
            g.pQN.h(14596, this.tAv.getIntent().getStringExtra("key_function_id"), Integer.valueOf(intExtra), Integer.valueOf(0));
        }
        if (intExtra == 1) {
            x.e("MicroMsg.WebViewUI", "not allow download file : %s", str);
            return;
        }
        if (str4 == null || !str4.equalsIgnoreCase("application/vnd.android.package-archive")) {
            intExtra = 0;
        } else {
            x.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", str);
            d.a(this.tAv.juQ, 11154, str);
            intExtra = 1;
        }
        if (this.tAv.juR == null || this.tAv.juR.bSs() == null) {
            x.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
            return;
        }
        if (str4 != null) {
            x.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", Boolean.valueOf(WebViewUI.O(this.tAv)));
            CharSequence Ps = WebViewUI.Ps(str3);
            int i2 = (Ps == null || !Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", Ps)) ? 0 : 1;
            boolean contains = a.tGw.contains(str4.toLowerCase());
            if (!r4 || (i2 == 0 && !contains)) {
                i = 0;
            }
        } else {
            i = 0;
        }
        if (i == 0 && !this.tAv.juR.bSs().gn(24) && !WebViewUI.P(this.tAv)) {
            x.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
        } else if (intExtra != 0) {
            WebViewUI.a(this.tAv, str, j);
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            try {
                this.tAv.startActivity(intent);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "startActivity fail, e = " + e.getMessage());
            }
        }
    }
}
