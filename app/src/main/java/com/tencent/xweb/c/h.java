package com.tencent.xweb.c;

import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.e;
import org.xwalk.core.Log;

public final class h {
    static a AqX;
    static a AqY;
    static a AqZ;

    public static a a(c cVar) {
        Object gd;
        if (cVar == c.WV_KIND_CW) {
            if (AqX == null) {
                gd = d.gd("com.tencent.xweb.xwalk.XWalkWebFactory", "getInstance");
                if (gd == null || !(gd instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find com.tencent.xweb.XWalkWebFactory failed");
                    return null;
                }
                AqX = (a) gd;
            }
            return AqX;
        } else if (cVar == c.WV_KIND_X5) {
            if (AqY == null) {
                gd = d.gd("com.tencent.xweb.x5.X5WebFactory", "getInstance");
                if (gd == null || !(gd instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find X5WebFactory failed");
                    return null;
                }
                AqY = (a) gd;
            }
            return AqY;
        } else if (cVar != c.WV_KIND_SYS) {
            return null;
        } else {
            if (AqZ == null) {
                gd = d.gd("com.tencent.xweb.sys.SysWebFactory", "getInstance");
                if (gd == null || !(gd instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find SysWebFactory failed");
                    return null;
                }
                AqZ = (a) gd;
            }
            return AqZ;
        }
    }

    public static g a(c cVar, WebView webView) {
        g gVar = null;
        try {
            if (a(cVar) == null) {
                Log.e("WebViewWrapperFactory", "the kind of " + cVar + " this provider does not exist!");
            } else {
                gVar = a(cVar).createWebView(webView);
            }
        } catch (Exception e) {
            Log.e("WebViewWrapperFactory", "getWebView failed type = " + cVar);
            e.d(cVar);
        }
        return gVar;
    }
}
