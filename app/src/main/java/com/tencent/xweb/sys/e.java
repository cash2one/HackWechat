package com.tencent.xweb.sys;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView.FindListener;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.c.g;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.sys.SysWebView.1;
import com.tencent.xweb.util.d;
import com.tencent.xweb.x5.a.a.a.a.b;
import java.util.Map;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public final class e implements g {
    WebView Arl;
    a Arm;
    p Arn;
    j Aro;
    d Arp;
    f Arq;
    long Arr = 0;
    private WebChromeClient Ars = new 1(this);
    private WebViewClient Art = new 1(this);
    b Aru;
    final String Arv = "xwalkTempCallBack";

    public e(WebView webView) {
        this.Arl = webView;
        this.Arm = new a(this, webView.getContext());
        getSettings();
        this.Arp = new d(this.Arm);
        this.Arm.setWebChromeClient(this.Ars);
        this.Arm.setWebViewClient(this.Art);
        if (VERSION.SDK_INT < 19) {
            this.Aru = new b();
            this.Arm.addJavascriptInterface(this.Aru, "xwalkTempCallBack");
        }
    }

    public final n getSettings() {
        if (this.Arq != null) {
            return this.Arq;
        }
        if (this.Arm == null) {
            return null;
        }
        this.Arq = new f(this.Arm);
        return this.Arq;
    }

    public final View getWebViewUI() {
        return this.Arm;
    }

    public final ViewGroup getTopView() {
        return this.Arm;
    }

    public final void setWebViewClient(p pVar) {
        this.Arn = pVar;
    }

    public final void setWebChromeClient(j jVar) {
        this.Aro = jVar;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        this.Arm.setDownloadListener(downloadListener);
    }

    public final void setFindListener(FindListener findListener) {
        this.Arm.setFindListener(findListener);
    }

    public final void loadUrl(String str) {
        this.Arm.loadUrl(str);
    }

    public final boolean canGoBack() {
        return this.Arm.canGoBack();
    }

    public final void goBack() {
        this.Arm.goBack();
    }

    public final boolean hasEnteredFullscreen() {
        return false;
    }

    public final void leaveFullscreen() {
    }

    public final void clearView() {
        this.Arm.clearView();
    }

    public final void destroy() {
        this.Arm.destroy();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (str != null) {
            if (VERSION.SDK_INT >= 19) {
                this.Arm.evaluateJavascript(str, valueCallback);
            } else if (valueCallback == null) {
                this.Arm.loadUrl(str);
            } else {
                String stringBuilder;
                if (str.trim().startsWith("javascript:")) {
                    str = str.replaceFirst("javascript:", "");
                }
                if (this.Aru == null) {
                    this.Aru = new b();
                    this.Arm.addJavascriptInterface(this.Aru, "xwalkTempCallBack");
                }
                b bVar = this.Aru;
                if (valueCallback != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    int i = bVar.Ary;
                    bVar.Ary = i + 1;
                    stringBuilder = stringBuilder2.append(i).toString();
                    bVar.Arx.put(stringBuilder, valueCallback);
                } else {
                    stringBuilder = "";
                }
                this.Arm.loadUrl("javascript:xwalkTempCallBack.notifyJava(" + stringBuilder + ", " + str + ")");
            }
        }
    }

    public final com.tencent.xweb.c.e getDefalutOpProvider() {
        return this.Arp;
    }

    public final void reload() {
        this.Arm.reload();
    }

    public final void clearSslPreferences() {
        this.Arm.clearSslPreferences();
    }

    public final void loadData(String str, String str2, String str3) {
        this.Arm.loadData(str, str2, str3);
    }

    public final int getContentHeight() {
        return this.Arm.getContentHeight();
    }

    public final float getScale() {
        return this.Arm.getScale();
    }

    public final int getVisibleTitleHeight() {
        Object g = d.g(this.Arm, "getVisibleTitleHeight");
        return g == null ? 0 : ((Integer) g).intValue();
    }

    public final boolean overlayHorizontalScrollbar() {
        return this.Arm.overlayHorizontalScrollbar();
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.Arm.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final boolean zoomOut() {
        return this.Arm.zoomOut();
    }

    public final boolean zoomIn() {
        return this.Arm.zoomIn();
    }

    public final void loadUrl(String str, Map<String, String> map) {
        this.Arm.loadUrl(str, map);
    }

    @SuppressLint({"JavascriptInterface"})
    public final void addJavascriptInterface(Object obj, String str) {
        this.Arm.addJavascriptInterface(obj, str);
    }

    public final View getView() {
        return this.Arm;
    }

    public final String getUrl() {
        return this.Arm.getUrl();
    }

    public final void removeJavascriptInterface(String str) {
        this.Arm.removeJavascriptInterface(str);
    }

    public final void stopLoading() {
        this.Arm.stopLoading();
    }

    public final void setWebViewCallbackClient(o oVar) {
        if (this.Arm != null) {
            this.Arm.juK = oVar;
        }
    }

    public final a getHitTestResult() {
        HitTestResult hitTestResult = this.Arm.getHitTestResult();
        a aVar = new a();
        aVar.mType = hitTestResult.getType();
        aVar.mExtra = hitTestResult.getExtra();
        return aVar;
    }

    public final String getTitle() {
        return this.Arm.getTitle();
    }

    public final void clearMatches() {
        this.Arm.clearMatches();
    }

    public final void findNext(boolean z) {
        this.Arm.findNext(z);
    }

    public final void findAllAsync(String str) {
        this.Arm.findAllAsync(str);
    }

    public final String getVersionInfo() {
        return "webviewtype = WV_KIND_SYS, V8 type=" + com.tencent.xweb.g.cIn();
    }

    public final String getAbstractInfo() {
        return getVersionInfo();
    }

    public final p getCurWebviewClient() {
        return this.Arn;
    }

    public final j getCurWebChromeClient() {
        return this.Aro;
    }

    public final int getWebScrollY() {
        return this.Arm.getScrollY();
    }

    public final int getWebScrollX() {
        return getWebViewUI().getScrollX();
    }

    public final boolean isOverScrollStart() {
        return getWebViewUI().getScrollY() == 0;
    }

    public final Object getX5WebViewExtension() {
        return null;
    }

    public final void setWebViewClientExtension(b bVar) {
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
    }

    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void super_computeScroll() {
    }

    public final void super_onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public final boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return false;
    }

    public final void onResume() {
        this.Arm.onResume();
    }

    public final void onPause() {
        this.Arm.onPause();
    }
}
