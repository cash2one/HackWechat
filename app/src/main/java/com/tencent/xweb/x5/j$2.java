package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.util.e;
import com.tencent.xweb.x5.g.a;
import com.tencent.xweb.x5.g.b;
import org.xwalk.core.Log;

class j$2 extends c {
    final /* synthetic */ j Ash;

    j$2(j jVar) {
        this.Ash = jVar;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Log.i("X5WebView", "shouldOverrideUrlLoading " + str);
        if (this.Ash.Arn != null) {
            return this.Ash.Arn.b(this.Ash.Arl, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Log.i("X5WebView", "onPageStarted " + str);
        if (this.Ash.Arn != null) {
            this.Ash.Arn.b(this.Ash.Arl, str, bitmap);
        } else {
            super.onPageStarted(webView, str, bitmap);
        }
        this.Ash.Arr = System.currentTimeMillis();
        e.cIC();
        e.cIG();
    }

    public final void onPageFinished(WebView webView, String str) {
        Log.i("X5WebView", "onPageFinished " + str);
        if (this.Ash.Arn != null) {
            this.Ash.Arn.a(this.Ash.Arl, str);
        } else {
            super.onPageFinished(webView, str);
        }
        e.gC(System.currentTimeMillis() - this.Ash.Arr);
        e.gE(System.currentTimeMillis() - this.Ash.Arr);
    }

    public final void onLoadResource(WebView webView, String str) {
        if (this.Ash.Arn != null) {
            this.Ash.Arn.f(this.Ash.Arl, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.Ash.Arn != null) {
            return a.b(this.Ash.Arn.c(this.Ash.Arl, str));
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.Ash.Arn == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return a.b(this.Ash.Arn.a(this.Ash.Arl, new b(webResourceRequest)));
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        if (this.Ash.Arn == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest, bundle);
        }
        return a.b(this.Ash.Arn.a(this.Ash.Arl, new b(webResourceRequest), bundle));
    }

    public final void onScaleChanged(WebView webView, float f, float f2) {
        if (this.Ash.Arn != null) {
            this.Ash.Arn.blg();
        } else {
            super.onScaleChanged(webView, f, f2);
        }
    }

    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (this.Ash.Arn != null) {
            this.Ash.Arn.a(this.Ash.Arl, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.Ash.Arn != null) {
            this.Ash.Arn.a(this.Ash.Arl, i, str, str2);
        } else {
            super.onReceivedError(webView, i, str, str2);
        }
        e.cID();
        e.cIH();
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Log.i("X5WebView", "onReceivedSslError " + sslError.getPrimaryError());
        if (this.Ash.Arn != null) {
            this.Ash.Arn.a(this.Ash.Arl, new a(sslErrorHandler), sslError != null ? new android.net.http.SslError(sslError.getPrimaryError(), sslError.getCertificate()) : null);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Log.i("X5WebView", "onReceivedHttpError code:" + webResourceResponse.getStatusCode());
        if (this.Ash.Arn != null) {
            this.Ash.Arn.a(new b(webResourceRequest), g.a(webResourceResponse));
        } else {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }
}
