package com.tencent.xweb;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.c.e;

public class j {
    e Aqd;

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        callback.invoke(str, true, true);
    }

    public void onHideCustomView() {
        if (this.Aqd != null) {
            this.Aqd.onHideCustomView();
        }
    }

    public boolean a(WebView webView, String str, String str2, f fVar) {
        if (this.Aqd != null) {
            return this.Aqd.a(str, str2, fVar);
        }
        return false;
    }

    public boolean b(WebView webView, String str, String str2, f fVar) {
        if (this.Aqd != null) {
            return this.Aqd.b(str, str2, fVar);
        }
        return false;
    }

    public boolean a(WebView webView, String str, String str2, String str3, e eVar) {
        if (this.Aqd != null) {
            return this.Aqd.a(str, str2, str3, eVar);
        }
        return false;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        valueCallback.onReceiveValue(null);
    }

    public boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, a aVar) {
        return false;
    }

    public void a(WebView webView, int i) {
    }

    public void d(WebView webView, String str) {
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        if (this.Aqd != null) {
            this.Aqd.onShowCustomView(view, customViewCallback);
        }
    }
}
