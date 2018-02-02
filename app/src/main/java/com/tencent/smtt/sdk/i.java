package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.a;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

final class i extends X5ProxyWebChromeClient {
    private WebView zVo;
    private WebChromeClient zWv;

    public i(IX5WebChromeClient iX5WebChromeClient, WebView webView, WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.zVo = webView;
        this.zWv = webChromeClient;
    }

    public final Bitmap getDefaultVideoPoster() {
        return this.zWv.getDefaultVideoPoster();
    }

    public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public final void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWv.onCloseWindow(this.zVo);
    }

    public final void onConsoleMessage(String str, int i, String str2) {
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.zWv.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, final Message message) {
        WebView webView = this.zVo;
        webView.getClass();
        final WebViewTransport webViewTransport = new WebViewTransport(webView);
        Message obtain = Message.obtain(message.getTarget(), new Runnable(this) {
            final /* synthetic */ i zWw;

            public final void run() {
                WebView webView = webViewTransport.getWebView();
                if (webView != null) {
                    ((IX5WebViewBase.WebViewTransport) message.obj).setWebView(webView.zZl);
                }
                message.sendToTarget();
            }
        });
        obtain.obj = webViewTransport;
        return this.zWv.onCreateWindow(this.zVo, z, z2, obtain);
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        this.zWv.onExceededDatabaseQuota(str, str2, j, j2, j3, new a(this, quotaUpdater));
    }

    public final void onGeolocationPermissionsHidePrompt() {
        this.zWv.onGeolocationPermissionsHidePrompt();
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        this.zWv.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
    }

    public final void onHideCustomView() {
        this.zWv.onHideCustomView();
    }

    public final boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.zVo.zZl = iX5WebViewBase;
        return this.zWv.onJsAlert(this.zVo, str, str2, jsResult);
    }

    public final boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.zVo.zZl = iX5WebViewBase;
        return this.zWv.onJsBeforeUnload(this.zVo, str, str2, jsResult);
    }

    public final boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.zVo.zZl = iX5WebViewBase;
        return this.zWv.onJsConfirm(this.zVo, str, str2, jsResult);
    }

    public final boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.zVo.zZl = iX5WebViewBase;
        return this.zWv.onJsPrompt(this.zVo, str, str2, str3, jsPromptResult);
    }

    public final boolean onJsTimeout() {
        return this.zWv.onJsTimeout();
    }

    public final void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWv.onProgressChanged(this.zVo, i);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        this.zWv.onReachedMaxAppCacheSize(j, j2, new a(this, quotaUpdater));
    }

    public final void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWv.onReceivedIcon(this.zVo, bitmap);
    }

    public final void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWv.onReceivedTitle(this.zVo, str);
    }

    public final void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWv.onReceivedTouchIconUrl(this.zVo, str, z);
    }

    public final void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWv.onRequestFocus(this.zVo);
    }

    public final void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        this.zWv.onShowCustomView(view, i, customViewCallback);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        this.zWv.onShowCustomView(view, customViewCallback);
    }

    public final boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        ab 3 = new 3(this, valueCallback);
        a 4 = new 4(this, fileChooserParams);
        this.zVo.zZl = iX5WebViewBase;
        return this.zWv.onShowFileChooser(this.zVo, 3, 4);
    }

    public final void openFileChooser(final ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z) {
        this.zWv.openFileChooser(new ab<Uri>(this) {
            final /* synthetic */ i zWw;

            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                Uri uri = (Uri) obj;
                valueCallback.onReceiveValue(new Uri[]{uri});
            }
        }, str, str2);
    }
}
