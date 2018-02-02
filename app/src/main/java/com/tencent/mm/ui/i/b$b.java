package com.tencent.mm.ui.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.i.b.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
class b$b extends p {
    boolean zcj;
    final /* synthetic */ b zqj;

    private b$b(b bVar) {
        this.zqj = bVar;
        this.zcj = true;
    }

    public final boolean b(WebView webView, String str) {
        x.d("Twitter-WebView", "Redirect URL: " + str);
        if (str.startsWith("wechatapp://sign-in-twitter.wechatapp.com/")) {
            Bundle ZL = ZL(str);
            if (ZL.getString("denied") == null) {
                b.a(this.zqj).k(ZL);
            } else {
                b.a(this.zqj).onCancel();
            }
            this.zqj.dismiss();
        } else {
            this.zqj.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
        return true;
    }

    public final void a(WebView webView, int i, String str, String str2) {
        super.a(webView, i, str, str2);
        this.zcj = false;
        a a = b.a(this.zqj);
        b bVar = new b(str, i, str2);
        a.cyw();
        try {
            this.zqj.dismiss();
            b.b(this.zqj).dismiss();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
        }
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        x.d("Twitter-WebView", "Webview loading URL: " + str);
        super.b(webView, str, bitmap);
        try {
            b.b(this.zqj).show();
            b.b(this.zqj).setOnDismissListener(new OnDismissListener(this) {
                final /* synthetic */ b$b zqk;

                {
                    this.zqk = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    if (this.zqk.zcj && this.zqk.zqj != null) {
                        b.a(this.zqk.zqj).onCancel();
                        this.zqk.zqj.dismiss();
                    }
                }
            });
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
        }
    }

    public final void a(WebView webView, String str) {
        super.a(webView, str);
        this.zcj = false;
        try {
            b.b(this.zqj).dismiss();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
        }
        b.c(this.zqj).setBackgroundColor(0);
        b.d(this.zqj).setVisibility(0);
        b.e(this.zqj).setVisibility(0);
    }

    private static Bundle ZK(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
            }
        }
        return bundle;
    }

    private static Bundle ZL(String str) {
        try {
            URL url = new URL(str.replace("wechatapp", "http"));
            Bundle ZK = ZK(url.getQuery());
            ZK.putAll(ZK(url.getRef()));
            return ZK;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }
}
