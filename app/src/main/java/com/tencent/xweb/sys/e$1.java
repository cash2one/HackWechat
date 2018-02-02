package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import com.tencent.xweb.util.e;
import org.xwalk.core.Log;

class e$1 extends WebViewClient {
    final /* synthetic */ e Arw;

    e$1(e eVar) {
        this.Arw = eVar;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Log.i("SysWebView", "shouldOverrideUrlLoading " + str);
        if (this.Arw.Arn != null) {
            return this.Arw.Arn.b(this.Arw.Arl, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Log.i("SysWebView", "onPageStarted " + str);
        if (this.Arw.Arn != null) {
            this.Arw.Arn.b(this.Arw.Arl, str, bitmap);
        } else {
            super.onPageStarted(webView, str, bitmap);
        }
        this.Arw.Arr = System.currentTimeMillis();
        e.cIC();
        e.cIE();
    }

    public final void onPageFinished(WebView webView, String str) {
        Log.i("SysWebView", "onPageFinished " + str);
        if (this.Arw.Arn != null) {
            this.Arw.Arn.a(this.Arw.Arl, str);
        } else {
            super.onPageFinished(webView, str);
        }
        e.gC(System.currentTimeMillis() - this.Arw.Arr);
        e.gD(System.currentTimeMillis() - this.Arw.Arr);
    }

    public final void onLoadResource(WebView webView, String str) {
        if (this.Arw.Arn != null) {
            this.Arw.Arn.f(this.Arw.Arl, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.Arw.Arn != null) {
            return c.a(this.Arw.Arn.c(this.Arw.Arl, str));
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        m mVar = null;
        if (this.Arw.Arn == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        Bundle bundle;
        Object com_tencent_xweb_sys_c_e = new c$e(webResourceRequest);
        if (com_tencent_xweb_sys_c_e.Arg == null) {
            bundle = null;
        } else {
            bundle = com_tencent_xweb_sys_c_e.Arg.getBundle();
        }
        if (bundle != null) {
            mVar = this.Arw.Arn.a(this.Arw.Arl, com_tencent_xweb_sys_c_e, bundle);
        }
        if (mVar == null) {
            mVar = this.Arw.Arn.a(this.Arw.Arl, com_tencent_xweb_sys_c_e);
        }
        return c.a(mVar);
    }

    public final void onScaleChanged(WebView webView, float f, float f2) {
        if (this.Arw.Arn != null) {
            this.Arw.Arn.blg();
        } else {
            super.onScaleChanged(webView, f, f2);
        }
    }

    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (this.Arw.Arn != null) {
            this.Arw.Arn.a(this.Arw.Arl, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.Arw.Arn != null) {
            this.Arw.Arn.a(this.Arw.Arl, i, str, str2);
        } else {
            super.onReceivedError(webView, i, str, str2);
        }
        e.cID();
        e.cIF();
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Log.i("SysWebView", "onReceivedSslError " + sslError.getPrimaryError());
        if (this.Arw.Arn != null) {
            this.Arw.Arn.a(this.Arw.Arl, new c$a(sslErrorHandler), sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Log.i("SysWebView", "onReceivedHttpError code:" + (VERSION.SDK_INT >= 21 ? String.valueOf(webResourceResponse.getStatusCode()) : "Invalid"));
        if (this.Arw.Arn != null) {
            p pVar = this.Arw.Arn;
            l com_tencent_xweb_sys_c_e = new c$e(webResourceRequest);
            m mVar = webResourceResponse == null ? null : VERSION.SDK_INT >= 21 ? new m(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData()) : new m(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
            pVar.a(com_tencent_xweb_sys_c_e, mVar);
            return;
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }
}
