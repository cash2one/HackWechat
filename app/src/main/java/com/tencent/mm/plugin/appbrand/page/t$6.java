package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.HashMap;

class t$6 extends p {
    final /* synthetic */ t jFj;

    t$6(t tVar) {
        this.jFj = tVar;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        x.i("MicroMsg.AppBrandWebView", "onPageStarted, url = %s", new Object[]{str});
        t.a(this.jFj, false);
    }

    public final void a(WebView webView, String str) {
        x.i("MicroMsg.AppBrandWebView", "onPageFinished, url = %s", new Object[]{str});
        if (!t.c(this.jFj)) {
            t.a(this.jFj, true);
            t.a(this.jFj, System.currentTimeMillis());
            t.d(this.jFj);
        }
    }

    public final boolean b(WebView webView, String str) {
        x.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[]{str});
        return true;
    }

    public final void a(WebView webView, h hVar, SslError sslError) {
        x.e("MicroMsg.AppBrandWebView", "SSL Error, Page URL: %s, Code %d", new Object[]{this.jFj.iZW, Integer.valueOf(sslError.getPrimaryError())});
        t.a(this.jFj, hVar, sslError);
    }

    private m tP(String str) {
        m pF;
        boolean z = false;
        if (t.b(this.jFj) == null || !t.b(this.jFj).iqP.YV()) {
            boolean z2 = false;
        } else {
            int i = 1;
        }
        if (str.startsWith(t.e(this.jFj))) {
            if ((t.f(this.jFj) || r0 != 0) && str.equals(t.g(this.jFj))) {
                pF = v.pF("WAPageFrame.html");
            } else {
                pF = ah.c(t.b(this.jFj), str.replaceFirst(t.e(this.jFj), ""));
            }
            if (pF == null) {
                x.e("MicroMsg.AppBrandWebView", "getAppResourceResponse %s not found", new Object[]{str});
                pF = new m("image/*", ProtocolPackage.ServerEncoding, TencentLocation.ERROR_UNKNOWN, "Not Found", new HashMap(), new ByteArrayInputStream(new byte[0]));
            }
        } else if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(t.a(this.jFj), str);
            if (itemByLocalId != null) {
                try {
                    pF = new m(itemByLocalId.mimeType, ProtocolPackage.ServerEncoding, new FileInputStream(itemByLocalId.hhZ));
                } catch (Throwable e) {
                    x.e("MicroMsg.AppBrandWebView", "tryInterceptWebViewRequest with localId(%s), exp = %s", new Object[]{str, bh.i(e)});
                }
            }
            pF = null;
        } else {
            pF = ah.c(t.b(this.jFj), str);
        }
        if (!(pF == null || pF.mStatusCode == TencentLocation.ERROR_UNKNOWN)) {
            pF.setStatusCodeAndReasonPhrase(200, "Ok");
            pF.mResponseHeaders = new HashMap();
        }
        String str2 = "MicroMsg.AppBrandWebView";
        String str3 = "tryInterceptWebViewRequest, reqURL = %s, WebResourceResponse == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (pF == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        return pF;
    }

    public final m c(WebView webView, String str) {
        if (bh.ov(str)) {
            return null;
        }
        return tP(str);
    }

    public final m a(WebView webView, l lVar) {
        if (lVar == null || lVar.getUrl() == null || bh.ov(lVar.getUrl().toString())) {
            return null;
        }
        return tP(lVar.getUrl().toString());
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        if (lVar == null || lVar.getUrl() == null || bh.ov(lVar.getUrl().toString())) {
            return null;
        }
        return tP(lVar.getUrl().toString());
    }

    public final void a(WebView webView, int i, String str, String str2) {
        x.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[]{Integer.valueOf(i), str, str2});
    }

    public final void a(l lVar, m mVar) {
        Uri url = lVar.getUrl();
        String uri = url == null ? "null" : url.toString();
        x.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[]{uri, mVar.mMimeType, Integer.valueOf(mVar.mStatusCode)});
    }
}
