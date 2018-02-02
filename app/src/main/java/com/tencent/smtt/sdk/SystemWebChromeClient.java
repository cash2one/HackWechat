package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

class SystemWebChromeClient extends WebChromeClient {
    private WebView zVo;
    private WebChromeClient zWv;

    private class JsResultImpl implements JsResult {
        android.webkit.JsResult mJsResult;

        JsResultImpl(android.webkit.JsResult jsResult) {
            this.mJsResult = jsResult;
        }

        public void cancel() {
            this.mJsResult.cancel();
        }

        public void confirm() {
            this.mJsResult.confirm();
        }
    }

    SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.zVo = webView;
        this.zWv = webChromeClient;
    }

    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = this.zWv.getDefaultVideoPoster();
        if (defaultVideoPoster == null) {
            try {
                if (VERSION.SDK_INT >= 24) {
                    defaultVideoPoster = BitmapFactory.decodeResource(this.zVo.getResources(), 17301540);
                }
            } catch (Exception e) {
            }
        }
        return defaultVideoPoster;
    }

    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        return this.zWv.getVideoLoadingProgressView();
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        this.zWv.getVisitedHistory(new 1(this, valueCallback));
    }

    public void onCloseWindow(WebView webView) {
        this.zWv.onCloseWindow(this.zVo);
    }

    public void onConsoleMessage(String str, int i, String str2) {
        this.zWv.onConsoleMessage(new ConsoleMessageImpl(str, str2, i));
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.zWv.onConsoleMessage(new ConsoleMessageImpl(consoleMessage));
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2 = this.zVo;
        webView2.getClass();
        WebViewTransport webViewTransport = new WebViewTransport(webView2);
        Message obtain = Message.obtain(message.getTarget(), new 2(this, webViewTransport, message));
        obtain.obj = webViewTransport;
        return this.zWv.onCreateWindow(this.zVo, z, z2, obtain);
    }

    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        this.zWv.onExceededDatabaseQuota(str, str2, j, j2, j3, new QuotaUpdaterImpl(this, quotaUpdater));
    }

    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        this.zWv.onGeolocationPermissionsHidePrompt();
    }

    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        this.zWv.onGeolocationPermissionsShowPrompt(str, new GeolocationPermissionsCallbackImpl(this, callback));
    }

    @TargetApi(7)
    public void onHideCustomView() {
        this.zWv.onHideCustomView();
    }

    public boolean onJsAlert(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        return this.zWv.onJsAlert(this.zVo, str, str2, new JsResultImpl(jsResult));
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        return this.zWv.onJsBeforeUnload(this.zVo, str, str2, new JsResultImpl(jsResult));
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        return this.zWv.onJsConfirm(this.zVo, str, str2, new JsResultImpl(jsResult));
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.zWv.onJsPrompt(this.zVo, str, str2, str3, new JsPromptResultImpl(this, jsPromptResult));
    }

    @TargetApi(7)
    public boolean onJsTimeout() {
        return this.zWv.onJsTimeout();
    }

    public void onProgressChanged(WebView webView, int i) {
        this.zWv.onProgressChanged(this.zVo, i);
    }

    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        this.zWv.onReachedMaxAppCacheSize(j, j2, new QuotaUpdaterImpl(this, quotaUpdater));
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        this.zWv.onReceivedIcon(this.zVo, bitmap);
    }

    public void onReceivedTitle(WebView webView, String str) {
        this.zWv.onReceivedTitle(this.zVo, str);
    }

    @TargetApi(7)
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        this.zWv.onReceivedTouchIconUrl(this.zVo, str, z);
    }

    public void onRequestFocus(WebView webView) {
        this.zWv.onRequestFocus(this.zVo);
    }

    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        this.zWv.onShowCustomView(view, i, new CustomViewCallbackImpl(this, customViewCallback));
    }

    @TargetApi(7)
    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        this.zWv.onShowCustomView(view, new CustomViewCallbackImpl(this, customViewCallback));
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        return this.zWv.onShowFileChooser(this.zVo, new 4(this, valueCallback), new 5(this, fileChooserParams));
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.zWv.openFileChooser(new 3(this, valueCallback), str, str2);
    }

    public void setupAutoFill(Message message) {
    }
}
