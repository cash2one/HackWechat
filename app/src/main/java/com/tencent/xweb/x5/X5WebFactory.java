package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.smtt.sdk.ah;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.c.h$a;
import com.tencent.xweb.g.a;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.e;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.g;
import com.tencent.xweb.x5.sdk.i;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class X5WebFactory implements h$a {
    private static final String TAG = "MicroMsg.X5WebFactory";
    static X5WebFactory sInstance;

    public static X5WebFactory getInstance() {
        if (sInstance == null) {
            sInstance = new X5WebFactory();
        }
        return sInstance;
    }

    private X5WebFactory() {
    }

    public Object excute(String str, Object[] objArr) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.equals("STR_CMD_GET_TBS_QBSDK_IMP")) {
            return new e();
        }
        if (str.equals("STR_CMD_GET_TBS_DOWNLOADER_IMP")) {
            return new g();
        }
        return null;
    }

    public com.tencent.xweb.c.g createWebView(WebView webView) {
        return new j(webView);
    }

    public void initInterface() {
        d.a(new e());
        f.a(new g());
        WebView.setX5Interface(new i());
    }

    public void initEnviroment(Context context) {
        TbsLog.setTbsLogClient(new a(this, context));
    }

    public com.tencent.xweb.c.f getJsCore(a aVar, Context context) {
        com.tencent.xweb.c.f fVar = null;
        switch (aVar) {
            case RT_TYPE_X5:
                boolean hF = ah.hF(context);
                Log.i(TAG, "canUseX5JsCore : " + hF);
                if (hF) {
                    if (ah.hE(context)) {
                        fVar = new h(context);
                    } else {
                        fVar = new f(context);
                    }
                    fVar.init(0);
                    break;
                }
                break;
        }
        return fVar;
    }

    public boolean initWebviewCore(Context context, b bVar) {
        b.a(context, bVar);
        return true;
    }

    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
    }

    public boolean hasInited() {
        return b.hasInited();
    }

    public boolean hasInitedCallback() {
        return true;
    }

    public boolean isCoreReady() {
        return b.isCoreReady();
    }

    public com.tencent.xweb.c.b.a getCookieManager() {
        return new d();
    }

    public com.tencent.xweb.c.b.b getCookieSyncManager() {
        return new e();
    }
}
