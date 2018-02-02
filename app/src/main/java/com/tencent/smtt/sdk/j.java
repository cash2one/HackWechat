package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.r;
import com.tencent.wcdb.database.SQLiteDatabase;

final class j extends X5ProxyWebViewClient {
    private static String zWA = null;
    private WebView zVo;
    private WebViewClient zWz;

    public j(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.zVo = webView;
        this.zWz = webViewClient;
        this.zWz.zZG = this;
    }

    private void abe(String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            if (this.zVo.getContext() != null) {
                this.zVo.getContext().startActivity(intent);
            }
        } catch (Exception e) {
        }
    }

    public final void countPVContentCacheCallBack(String str) {
        WebView webView = this.zVo;
        webView.zZo++;
    }

    public final void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.doUpdateVisitedHistory(this.zVo, str, z);
    }

    public final void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onDetectedBlankScreen(str, i);
    }

    public final void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onFormResubmission(this.zVo, message, message2);
    }

    public final void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onLoadResource(this.zVo, str);
    }

    public final void onPageFinished(IX5WebViewBase iX5WebViewBase, int i, int i2, String str) {
        if (zWA == null) {
            r cFG = r.cFG();
            if (cFG != null) {
                cFG.nT(false);
                zWA = Boolean.toString(false);
            }
        }
        this.zVo.zZl = iX5WebViewBase;
        WebView webView = this.zVo;
        webView.zZo++;
        this.zWz.onPageFinished(this.zVo, str);
        if ("com.qzone".equals(iX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
            WebView.hA(iX5WebViewBase.getView().getContext());
        }
        TbsLog.app_extra("SmttWebViewClient", iX5WebViewBase.getView().getContext());
        try {
            super.onPageFinished(iX5WebViewBase, i, i2, str);
        } catch (Exception e) {
        }
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

    public final void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        onPageFinished(iX5WebViewBase, 0, 0, str);
    }

    public final void onPageStarted(IX5WebViewBase iX5WebViewBase, int i, int i2, String str, Bitmap bitmap) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onPageStarted(this.zVo, str, bitmap);
    }

    public final void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
    }

    public final void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onReceivedClientCertRequest(this.zVo, clientCertRequest);
    }

    public final void onReceivedError(IX5WebViewBase iX5WebViewBase, int i, String str, String str2) {
        if (i < -15) {
            if (i == -17) {
                i = -1;
            } else {
                return;
            }
        }
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onReceivedError(this.zVo, i, str, str2);
    }

    public final void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onReceivedError(this.zVo, webResourceRequest, webResourceError);
    }

    public final void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onReceivedHttpAuthRequest(this.zVo, httpAuthHandler, str, str2);
    }

    public final void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onReceivedHttpError(this.zVo, webResourceRequest, webResourceResponse);
    }

    public final void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onReceivedLoginRequest(this.zVo, str, str2, str3);
    }

    public final void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onReceivedSslError(this.zVo, sslErrorHandler, sslError);
    }

    public final void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f, float f2) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onScaleChanged(this.zVo, f, f2);
    }

    public final void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onTooManyRedirects(this.zVo, message, message2);
    }

    public final void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.zVo.zZl = iX5WebViewBase;
        this.zWz.onUnhandledKeyEvent(this.zVo, keyEvent);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        this.zVo.zZl = iX5WebViewBase;
        return this.zWz.shouldInterceptRequest(this.zVo, webResourceRequest);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        this.zVo.zZl = iX5WebViewBase;
        return this.zWz.shouldInterceptRequest(this.zVo, webResourceRequest, bundle);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        this.zVo.zZl = iX5WebViewBase;
        return this.zWz.shouldInterceptRequest(this.zVo, str);
    }

    public final boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.zVo.zZl = iX5WebViewBase;
        return this.zWz.shouldOverrideKeyEvent(this.zVo, keyEvent);
    }

    public final boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.zVo.showDebugView(uri)) {
            return true;
        }
        this.zVo.zZl = iX5WebViewBase;
        if (m.cFA().bQ(this.zVo.getContext().getApplicationContext(), uri)) {
            return true;
        }
        boolean shouldOverrideUrlLoading = this.zWz.shouldOverrideUrlLoading(this.zVo, webResourceRequest);
        if (!shouldOverrideUrlLoading) {
            if (uri.startsWith("wtai://wp/mc;")) {
                this.zVo.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(uri.substring(13)).toString())));
                return true;
            } else if (uri.startsWith(WebView.SCHEME_TEL)) {
                abe(uri);
                return true;
            }
        }
        return shouldOverrideUrlLoading;
    }

    public final boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        if (str == null || this.zVo.showDebugView(str)) {
            return true;
        }
        this.zVo.zZl = iX5WebViewBase;
        if (m.cFA().bQ(this.zVo.getContext().getApplicationContext(), str)) {
            return true;
        }
        boolean shouldOverrideUrlLoading = this.zWz.shouldOverrideUrlLoading(this.zVo, str);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                this.zVo.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str.substring(13)).toString())));
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                abe(str);
                return true;
            }
        }
        return shouldOverrideUrlLoading;
    }

    public final void w(String str, Bitmap bitmap) {
        super.onPageStarted(this.zVo.zZl, 0, 0, str, bitmap);
    }
}
