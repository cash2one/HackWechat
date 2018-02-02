package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.r;

@SuppressLint({"NewApi", "Override"})
class SystemWebViewClient extends WebViewClient {
    private static String zWA = null;
    private WebView zVo;
    private WebViewClient zWz;

    private static class SslErrorImpl implements SslError {
        android.net.http.SslError mSslError;

        SslErrorImpl(android.net.http.SslError sslError) {
            this.mSslError = sslError;
        }

        public boolean addError(int i) {
            return this.mSslError.addError(i);
        }

        public SslCertificate getCertificate() {
            return this.mSslError.getCertificate();
        }

        public int getPrimaryError() {
            return this.mSslError.getPrimaryError();
        }

        public boolean hasError(int i) {
            return this.mSslError.hasError(i);
        }
    }

    SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.zVo = webView;
        this.zWz = webViewClient;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.zWz.doUpdateVisitedHistory(this.zVo, str, z);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.zWz.onFormResubmission(this.zVo, message, message2);
    }

    public void onLoadResource(WebView webView, String str) {
        this.zWz.onLoadResource(this.zVo, str);
    }

    public void onPageFinished(WebView webView, String str) {
        if (zWA == null) {
            r cFG = r.cFG();
            if (cFG != null) {
                cFG.nT(true);
                zWA = Boolean.toString(true);
            }
        }
        WebView webView2 = this.zVo;
        webView2.zZo++;
        this.zWz.onPageFinished(this.zVo, str);
        if ("com.qzone".equals(webView.getContext().getApplicationInfo().packageName)) {
            WebView.hA(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.cFc();
        if (!(x.zYJ || this.zVo.getContext() == null || !x.hq(this.zVo.getContext()))) {
            x.zYJ = true;
            new Thread(new 1(this)).start();
        }
        if (this.zVo.getContext() != null && !v.hn(this.zVo.getContext()).zYd) {
            v.hn(this.zVo.getContext()).zYd = true;
            v.hn(this.zVo.getContext()).cEK();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.zWz.onPageStarted(this.zVo, str, bitmap);
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        if (VERSION.SDK_INT >= 21) {
            this.zWz.onReceivedClientCertRequest(this.zVo, new ClientCertRequestImpl(clientCertRequest));
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zWz.onReceivedError(this.zVo, i, str, str2);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError2 = null;
        com.tencent.smtt.export.external.interfaces.WebResourceRequest webResourceRequestImpl2 = webResourceRequest != null ? new WebResourceRequestImpl2(webResourceRequest) : null;
        if (webResourceError != null) {
            webResourceError2 = new com.tencent.smtt.export.external.interfaces.WebResourceError() {
                public CharSequence getDescription() {
                    return webResourceError.getDescription();
                }

                public int getErrorCode() {
                    return webResourceError.getErrorCode();
                }
            };
        }
        this.zWz.onReceivedError(this.zVo, webResourceRequestImpl2, webResourceError2);
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.zWz.onReceivedHttpAuthRequest(this.zVo, new HttpAuthHandlerImpl(httpAuthHandler), str, str2);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.zWz.onReceivedHttpError(this.zVo, new WebResourceRequestImpl2(webResourceRequest), new WebResourceResponseImpl2(webResourceResponse));
    }

    @TargetApi(12)
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (VERSION.SDK_INT >= 12) {
            this.zWz.onReceivedLoginRequest(this.zVo, str, str2, str3);
        }
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        if (VERSION.SDK_INT >= 8) {
            this.zWz.onReceivedSslError(this.zVo, new SslErrorHandlerImpl(sslErrorHandler), new SslErrorImpl(sslError));
        }
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        this.zWz.onScaleChanged(this.zVo, f, f2);
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        this.zWz.onTooManyRedirects(this.zVo, message, message2);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.zWz.onUnhandledKeyEvent(this.zVo, keyEvent);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (VERSION.SDK_INT < 21) {
            return null;
        }
        if (webResourceRequest == null) {
            return null;
        }
        boolean z = false;
        if (VERSION.SDK_INT >= 24) {
            Object f = o.f(webResourceRequest, "isRedirect");
            if (f instanceof Boolean) {
                z = ((Boolean) f).booleanValue();
            }
        }
        com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest = this.zWz.shouldInterceptRequest(this.zVo, new WebResourceRequestImpl(this, webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        if (shouldInterceptRequest == null) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
        int statusCode = shouldInterceptRequest.getStatusCode();
        String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
        if (statusCode == webResourceResponse.getStatusCode() && (reasonPhrase == null || reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
            return webResourceResponse;
        }
        webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
        return webResourceResponse;
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        com.tencent.smtt.export.external.interfaces.WebResourceResponse shouldInterceptRequest = this.zWz.shouldInterceptRequest(this.zVo, str);
        return shouldInterceptRequest != null ? new WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData()) : null;
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return this.zWz.shouldOverrideKeyEvent(this.zVo, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String str = null;
        if (!(webResourceRequest == null || webResourceRequest.getUrl() == null)) {
            str = webResourceRequest.getUrl().toString();
        }
        if (str == null || this.zVo.showDebugView(str) || m.cFA().bQ(this.zVo.getContext().getApplicationContext(), str)) {
            return true;
        }
        boolean z = false;
        if (VERSION.SDK_INT >= 24) {
            Object f = o.f(webResourceRequest, "isRedirect");
            if (f instanceof Boolean) {
                z = ((Boolean) f).booleanValue();
            }
        }
        return this.zWz.shouldOverrideUrlLoading(this.zVo, new WebResourceRequestImpl(this, webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return (str == null || this.zVo.showDebugView(str) || m.cFA().bQ(this.zVo.getContext().getApplicationContext(), str)) ? true : this.zWz.shouldOverrideUrlLoading(this.zVo, str);
    }
}
