package com.tencent.xweb.sys;

import android.content.Context;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.c.f;
import com.tencent.xweb.c.g;
import com.tencent.xweb.c.h$a;
import com.tencent.xweb.g.a;
import org.xwalk.core.WebViewExtensionListener;

public class SysWebFactory implements h$a {
    static SysWebFactory sInstance;

    public static SysWebFactory getInstance() {
        if (sInstance == null) {
            sInstance = new SysWebFactory();
        }
        return sInstance;
    }

    private SysWebFactory() {
    }

    public Object excute(String str, Object[] objArr) {
        if (!(str == null || str.isEmpty() || str.equals("STR_CMD_GET_DEBUG_VIEW") || !str.equals("STR_CMD_GET_UPDATER"))) {
        }
        return null;
    }

    public g createWebView(WebView webView) {
        return new e(webView);
    }

    public void initInterface() {
    }

    public void initEnviroment(Context context) {
    }

    public f getJsCore(a aVar, Context context) {
        return null;
    }

    public boolean initWebviewCore(Context context, b bVar) {
        if (bVar != null) {
            bVar.tH();
        }
        return true;
    }

    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
    }

    public boolean hasInited() {
        return true;
    }

    public boolean hasInitedCallback() {
        return a.hasInitedCallback();
    }

    public boolean isCoreReady() {
        return true;
    }

    public com.tencent.xweb.c.b.a getCookieManager() {
        return new a();
    }

    public com.tencent.xweb.c.b.b getCookieSyncManager() {
        return new b();
    }
}
