package com.tencent.xweb.x5;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient$a;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.ab;
import com.tencent.xweb.j;
import com.tencent.xweb.x5.g.c;
import com.tencent.xweb.x5.g.d;
import com.tencent.xweb.x5.g.e;
import com.tencent.xweb.x5.g.f;
import com.tencent.xweb.x5.g.g;
import org.xwalk.core.Log;

class j$1 extends b {
    final /* synthetic */ j Ash;

    j$1(j jVar) {
        this.Ash = jVar;
    }

    public final void onProgressChanged(WebView webView, int i) {
        Log.i("X5WebView", "onProgressChanged, progress = " + i);
        if (this.Ash.Aro != null) {
            this.Ash.Aro.a(this.Ash.Arl, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    public final void onReceivedTitle(WebView webView, String str) {
        Log.i("X5WebView", "onReceivedTitle: " + str);
        if (this.Ash.Aro != null) {
            this.Ash.Aro.d(this.Ash.Arl, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        Log.i("X5WebView", "onShowCustomView");
        if (this.Ash.Aro != null) {
            this.Ash.Aro.onShowCustomView(view, new c(customViewCallback));
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    public final void onHideCustomView() {
        Log.i("X5WebView", "onHideCustomView");
        if (this.Ash.Aro != null) {
            this.Ash.Aro.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Log.i("X5WebView", "onJsAlert");
        if (this.Ash.Aro != null) {
            return this.Ash.Aro.a(this.Ash.Arl, str, str2, new f(jsResult));
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Log.i("X5WebView", "onJsConfirm");
        if (this.Ash.Aro != null) {
            return this.Ash.Aro.b(this.Ash.Arl, str, str2, new f(jsResult));
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        Log.i("X5WebView", "onJsPrompt");
        if (this.Ash.Aro == null) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return this.Ash.Aro.a(this.Ash.Arl, str, str2, str3, new g(jsPromptResult));
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        Log.i("X5WebView", "onGeolocationPermissionsShowPrompt");
        if (this.Ash.Aro != null) {
            this.Ash.Aro.onGeolocationPermissionsShowPrompt(str, new e(geolocationPermissionsCallback));
        } else {
            super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }
    }

    public final void onGeolocationPermissionsHidePrompt() {
        Log.i("X5WebView", "onGeolocationPermissionsHidePrompt");
        if (this.Ash.Aro == null) {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Log.i("X5WebView", "onConsoleMessage " + consoleMessage.message());
        if (this.Ash.Aro == null) {
            return super.onConsoleMessage(consoleMessage);
        }
        android.webkit.ConsoleMessage consoleMessage2;
        j jVar = this.Ash.Aro;
        if (consoleMessage == null) {
            consoleMessage2 = null;
        } else {
            MessageLevel messageLevel = MessageLevel.DEBUG;
            switch (g$1.ArL[consoleMessage.messageLevel().ordinal()]) {
                case 1:
                    messageLevel = MessageLevel.DEBUG;
                    break;
                case 2:
                    messageLevel = MessageLevel.ERROR;
                    break;
                case 3:
                    messageLevel = MessageLevel.LOG;
                    break;
                case 4:
                    messageLevel = MessageLevel.TIP;
                    break;
                case 5:
                    messageLevel = MessageLevel.WARNING;
                    break;
            }
            consoleMessage2 = new android.webkit.ConsoleMessage(consoleMessage.message(), consoleMessage.sourceId(), consoleMessage.lineNumber(), messageLevel);
        }
        return jVar.onConsoleMessage(consoleMessage2);
    }

    public final void openFileChooser(ab<Uri> abVar, String str, String str2) {
        Log.i("X5WebView", "openFileChooser with three param");
        if (this.Ash.Aro != null) {
            this.Ash.Aro.openFileChooser(abVar, str, str2);
        } else {
            abVar.onReceiveValue(null);
        }
    }

    public final boolean onShowFileChooser(WebView webView, ab<Uri[]> abVar, WebChromeClient$a webChromeClient$a) {
        Log.i("X5WebView", "onShowFileChooser last method");
        if (this.Ash.Aro != null) {
            return this.Ash.Aro.a(this.Ash.Arl, abVar, new d(webChromeClient$a));
        }
        return super.onShowFileChooser(webView, new a.d(abVar), webChromeClient$a);
    }

    public final View getVideoLoadingProgressView() {
        if (this.Ash.Aro != null) {
            return this.Ash.Aro.getVideoLoadingProgressView();
        }
        return super.getVideoLoadingProgressView();
    }
}
