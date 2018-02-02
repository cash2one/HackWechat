package com.tencent.mm.plugin.game.gamewebview.e;

import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;
import com.tencent.xweb.j.a;

class b$a extends j {
    final /* synthetic */ b naI;

    private b$a(b bVar) {
        this.naI = bVar;
    }

    public final void a(WebView webView, int i) {
        if (b.m(this.naI) != null) {
            b.m(this.naI).a(webView, i);
        }
    }

    public final void d(WebView webView, String str) {
        x.i("MicroMsg.GameWebView", "onReceivedTitle, title = %s", new Object[]{str});
        if (b.m(this.naI) != null) {
            b.m(this.naI).d(webView, str);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        x.i("MicroMsg.GameWebView", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
        if (b.m(this.naI) != null) {
            b.m(this.naI).onShowCustomView(view, customViewCallback);
        }
    }

    public final void onHideCustomView() {
        x.i("MicroMsg.GameWebView", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
        if (b.m(this.naI) != null) {
            b.m(this.naI).onHideCustomView();
        }
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        x.i("MicroMsg.GameWebView", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[]{str});
        if (b.m(this.naI) != null) {
            b.m(this.naI).onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, a aVar) {
        if (b.m(this.naI) != null) {
            return b.m(this.naI).a(webView, valueCallback, aVar);
        }
        return super.a(webView, valueCallback, aVar);
    }

    public final boolean b(WebView webView, String str, String str2, f fVar) {
        if (b.m(this.naI) != null) {
            return b.m(this.naI).b(webView, str, str2, fVar);
        }
        return super.b(webView, str, str2, fVar);
    }

    public final boolean a(WebView webView, String str, String str2, String str3, e eVar) {
        if (b.m(this.naI) != null) {
            return b.m(this.naI).a(webView, str, str2, str3, eVar);
        }
        return super.a(webView, str, str2, str3, eVar);
    }

    public final boolean a(WebView webView, String str, String str2, f fVar) {
        if (b.m(this.naI) != null) {
            return b.m(this.naI).a(webView, str, str2, fVar);
        }
        return super.a(webView, str, str2, fVar);
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage != null ? consoleMessage.message() : null;
        x.i("MicroMsg.GameWebView", "onConsoleMessage : %s", new Object[]{message});
        if (b.m(this.naI) != null) {
            return b.m(this.naI).onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
