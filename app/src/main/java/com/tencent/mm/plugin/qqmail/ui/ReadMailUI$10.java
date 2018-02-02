package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;

class ReadMailUI$10 extends e {
    final /* synthetic */ ReadMailUI puG;

    ReadMailUI$10(ReadMailUI readMailUI, MMWebView mMWebView) {
        this.puG = readMailUI;
        super(mMWebView, true);
    }

    public final boolean HV(String str) {
        x.d("MicroMsg.ReadMailUI", "url:%s", new Object[]{str});
        if (str != null && str.startsWith(WebView.SCHEME_MAILTO)) {
            String replace = str.trim().replace(WebView.SCHEME_MAILTO, "");
            Intent intent = new Intent(this.puG, ComposeUI.class);
            intent.putExtra("composeType", 4);
            intent.putExtra("toList", new String[]{replace + " " + replace});
            this.puG.startActivity(intent);
            return true;
        } else if (str != null && str.startsWith(WebView.SCHEME_TEL)) {
            r1 = new Intent("android.intent.action.DIAL", Uri.parse(str));
            r1.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.puG.startActivity(r1);
            return true;
        } else if (str == null || str.startsWith("data:")) {
            return false;
        } else {
            if (ReadMailUI.g(this.puG).ptE) {
                ReadMailUI.g(this.puG).ptE = false;
                return true;
            } else if (!str.startsWith("http")) {
                return false;
            } else {
                r1 = new Intent();
                r1.putExtra("rawUrl", str);
                d.b(this.puG, "webview", ".ui.tools.WebViewUI", r1);
                return true;
            }
        }
    }

    public final void f(com.tencent.xweb.WebView webView, String str) {
        x.d("MicroMsg.ReadMailUI", "load res:%s", new Object[]{str});
    }

    public final void e(com.tencent.xweb.WebView webView, String str) {
        webView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
        webView.evaluateJavascript("javascript:" + ReadMailUI.bln(), null);
        webView.evaluateJavascript("javascript:" + ReadMailUI.blo(), null);
        webView.evaluateJavascript("javascript:" + ReadMailUI.blp(), null);
        if (ReadMailUI.l(this.puG).isConnected()) {
            if (!ReadMailUI.t(this.puG)) {
                ReadMailUI.u(this.puG);
            }
            ReadMailUI.a(this.puG, new ReadMailProxy(ReadMailUI.l(this.puG), null, new ReadMailUI$b(this.puG), new c(this.puG)));
            ReadMailUI.v(this.puG).REMOTE_CALL("addDownloadCallback", new Object[0]);
        }
        new af(this.puG.getMainLooper()).postDelayed(new 1(this), 200);
        new af(this.puG.getMainLooper()).postDelayed(new 2(this), 400);
    }
}
