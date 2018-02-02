package com.tencent.xweb.xwalk;

import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.m;
import com.tencent.xweb.util.e;
import com.tencent.xweb.xwalk.e.g;
import com.tencent.xweb.xwalk.e.h;
import org.xwalk.core.ClientCertRequest;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;

class h$2 extends k {
    final /* synthetic */ h Atn;

    h$2(h hVar, XWalkView xWalkView) {
        this.Atn = hVar;
        super(xWalkView);
    }

    public final boolean shouldOverrideUrlLoading(XWalkView xWalkView, String str) {
        boolean b = this.Atn.iTV.b(this.Atn.Arl, str);
        Log.i("XWWebView", "shouldOverrideUrlLoading ret =  " + b + " url = " + str);
        return b;
    }

    public final void onLoadStarted(XWalkView xWalkView, String str) {
        this.Atn.iTV.f(this.Atn.Arl, str);
    }

    public final WebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, String str) {
        m c = this.Atn.iTV.c(this.Atn.Arl, str);
        if (c == null) {
            return null;
        }
        return (c.mStatusCode == 0 || VERSION.SDK_INT < 21) ? new WebResourceResponse(c.mMimeType, c.mEncoding, c.mInputStream) : new WebResourceResponse(c.mMimeType, c.mEncoding, c.mStatusCode, c.mReasonPhrase, c.mResponseHeaders, c.mInputStream);
    }

    public final XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest) {
        m a;
        m a2;
        Object hVar = new h(xWalkWebResourceRequest);
        Bundle bundle = hVar.Arg == null ? null : hVar.Arg.getBundle();
        if (bundle != null) {
            a = this.Atn.iTV.a(this.Atn.Arl, hVar, bundle);
        } else {
            a = null;
        }
        if (a == null) {
            a2 = this.Atn.iTV.a(this.Atn.Arl, hVar);
        } else {
            a2 = a;
        }
        if (a2 != null) {
            return createXWalkWebResourceResponse(a2.mMimeType, a2.mEncoding, a2.mInputStream, a2.mStatusCode, a2.mReasonPhrase, a2.mResponseHeaders);
        }
        return null;
    }

    public final void onReceivedLoadError(XWalkView xWalkView, int i, String str, String str2) {
        Log.i("XWWebView", "onReceivedError " + str2);
        super.onReceivedLoadError(xWalkView, i, str, str2);
        this.Atn.Atj = true;
        this.Atn.iTV.a(this.Atn.Arl, i, str, str2);
        this.Atn.Atc.loadDataWithBaseURL("file:///android_asset/", String.format("<html>\n<head>\n</head>\n<body>\n<p><b><font size=\"15\">\n\n\n网页无法打开</font></b></p>\n<p><font size=\"7\">位于<b>%s</b>的网页无法加载，因为:</font></p>\n<p><font size=\"7\">错误码:%s</font></p>\n\n</body>\n\n</html>", new Object[]{str2, str}), "text/html", ProtocolPackage.ServerEncoding, null);
        e.c(str2, i, System.currentTimeMillis() - this.Atn.Arr, this.Atn.type);
    }

    public final void onReceivedSslError(XWalkView xWalkView, ValueCallback<Boolean> valueCallback, SslError sslError) {
        Log.i("XWWebView", "onReceivedSslError " + sslError.getPrimaryError());
        this.Atn.iTV.a(this.Atn.Arl, new g(valueCallback), sslError);
    }

    public final void onProgressChanged(XWalkView xWalkView, int i) {
        Log.i("XWWebView", "onProgressChanged, progress = " + i);
        this.Atn.jFi.a(this.Atn.Arl, i);
    }

    public final void onDocumentLoadedInFrame(XWalkView xWalkView, long j) {
        super.onDocumentLoadedInFrame(xWalkView, j);
    }

    public final void onLoadFinished(XWalkView xWalkView, String str) {
        super.onLoadFinished(xWalkView, str);
    }

    public final void onReceivedClientCertRequest(XWalkView xWalkView, ClientCertRequest clientCertRequest) {
        super.onReceivedClientCertRequest(xWalkView, clientCertRequest);
    }

    public final void onReceivedResponseHeaders(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest, XWalkWebResourceResponse xWalkWebResourceResponse) {
        if (xWalkWebResourceResponse.getStatusCode() == HardCoderJNI.SCENE_QUIT_CHATTING) {
            String str = (String) xWalkWebResourceResponse.getResponseHeaders().get("location");
            if (str == null || str.isEmpty()) {
                str = (String) xWalkWebResourceResponse.getResponseHeaders().get("Location");
            }
            if (str != null && str.trim().startsWith("weixin://")) {
                this.Atn.iTV.b(this.Atn.Arl, str, null);
                this.Atn.Atc.postDelayed(new 1(this, str), 300);
            }
        } else if (xWalkWebResourceResponse.getStatusCode() >= 400) {
            Log.i("XWWebView", "onReceivedHttpError code:" + xWalkWebResourceResponse.getStatusCode());
            this.Atn.iTV.a(new h(xWalkWebResourceRequest), xWalkWebResourceResponse == null ? null : new m(xWalkWebResourceResponse.getMimeType(), xWalkWebResourceResponse.getEncoding(), xWalkWebResourceResponse.getStatusCode(), xWalkWebResourceResponse.getReasonPhrase(), xWalkWebResourceResponse.getResponseHeaders(), xWalkWebResourceResponse.getData()));
        }
        super.onReceivedResponseHeaders(xWalkView, xWalkWebResourceRequest, xWalkWebResourceResponse);
    }

    public final void doUpdateVisitedHistory(XWalkView xWalkView, String str, boolean z) {
        if (str == null || !str.startsWith("data:text/html;charset=utf-8")) {
            this.Atn.iTV.a(this.Atn.Arl, str, z);
        }
    }

    public final void onReceivedHttpAuthRequest(XWalkView xWalkView, XWalkHttpAuthHandler xWalkHttpAuthHandler, String str, String str2) {
        super.onReceivedHttpAuthRequest(xWalkView, xWalkHttpAuthHandler, str, str2);
    }
}
