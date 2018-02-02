package com.tencent.mm.ui.f.a;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

class f$a extends p {
    final /* synthetic */ f zci;
    boolean zcj;

    private f$a(f fVar) {
        this.zci = fVar;
        this.zcj = true;
    }

    public final boolean b(WebView webView, String str) {
        x.d("Facebook-WebView", "Redirect URL: " + str);
        if (str.startsWith("fbconnect://success")) {
            Bundle ZL = e.ZL(str);
            String string = ZL.getString("error");
            if (string == null) {
                string = ZL.getString("error_type");
            }
            if (string == null) {
                f.a(this.zci).k(ZL);
            } else if (string.equals("access_denied") || string.equals("OAuthAccessDeniedException")) {
                f.a(this.zci).onCancel();
            } else {
                f.a(this.zci).a(new d(string));
            }
            this.zci.dismiss();
            return true;
        } else if (str.startsWith("fbconnect://cancel")) {
            f.a(this.zci).onCancel();
            try {
                this.zci.dismiss();
                return true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
                return true;
            }
        } else if (str.contains("touch")) {
            return false;
        } else {
            this.zci.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
    }

    public final void a(WebView webView, int i, String str, String str2) {
        super.a(webView, i, str, str2);
        this.zcj = false;
        f.a(this.zci).a(new b(str, i, str2));
        try {
            this.zci.dismiss();
            f.b(this.zci).dismiss();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
        }
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        x.d("Facebook-WebView", "Webview loading URL: " + str);
        super.b(webView, str, bitmap);
        try {
            f.b(this.zci).show();
            f.b(this.zci).setOnDismissListener(new 1(this));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
        }
    }

    public final void a(WebView webView, String str) {
        super.a(webView, str);
        this.zcj = false;
        try {
            f.b(this.zci).dismiss();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
        }
        f.c(this.zci).setBackgroundColor(0);
        f.d(this.zci).setVisibility(0);
        f.e(this.zci).setVisibility(0);
    }
}
