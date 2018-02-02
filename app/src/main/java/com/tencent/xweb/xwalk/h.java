package com.tencent.xweb.xwalk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import android.widget.AbsoluteLayout;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.c.g;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.x5.a.a.a.a.b;
import com.tencent.xweb.xwalk.a.d;
import com.tencent.xweb.xwalk.e.e;
import com.tencent.xweb.xwalk.e.f;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkHitTestResult;
import org.xwalk.core.XWalkLibraryLoader;
import org.xwalk.core.XWalkNavigationHistory.Direction;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkView;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class h implements g {
    WebView Arl;
    long Arr = 0;
    j Ata;
    k Atb;
    XWalkView Atc;
    i Atg;
    AbsoluteLayout Ath;
    f Ati;
    boolean Atj = false;
    String Atk = null;
    boolean Atl = false;
    p iTV = new p();
    j jFi = new j();
    o juK;
    int mApkVersion = XWalkEnvironment.getAvailableVersion();
    int type = 0;

    public static synchronized boolean ec(Context context) {
        boolean isXWalkReady;
        synchronized (h.class) {
            d.iT(context);
            isXWalkReady = d.isXWalkReady();
        }
        return isXWalkReady;
    }

    private void cIZ() {
        if (this.Ata == null) {
            this.Ata = new 1(this, this.Atc);
            this.Ati.Ata = this.Ata;
            this.Atc.setUIClient(this.Ata);
            this.Atb = new 2(this, this.Atc);
            this.Ati.Atb = this.Atb;
            this.Atc.setResourceClient(this.Atb);
        }
    }

    public h(WebView webView) {
        Context xWalkContextWrapper = new XWalkContextWrapper(webView.getContext(), this.mApkVersion);
        XWalkLibraryLoader.prepareToInit(xWalkContextWrapper);
        try {
            XWalkPreferences.setValue(XWalkPreferences.XWEB_VERSION, String.valueOf(this.mApkVersion));
            XWalkPreferences.setValue(XWalkPreferences.XWEBSDK_VERSION, "17");
        } catch (Exception e) {
            Log.e("XWWebView", e.getMessage());
        }
        this.Atc = new a(this, xWalkContextWrapper);
        this.Ath = new AbsoluteLayout(xWalkContextWrapper);
        this.Atc.getXWalkContentView().addView(this.Ath);
        this.Atc.setCustomOnScrollChangedListener(new 3(this));
        this.Atc.setCustomOnOverScrolledListener(new 4(this));
        this.Ati = new f(this.Atc);
        this.Arl = webView;
        this.Atg = new i(this.Atc);
        this.Atc.getSettings().SetLogCallBack(new 5(this));
    }

    public final void setWebViewClient(p pVar) {
        if (pVar == null) {
            this.iTV = new p();
            this.iTV.Aqd = this.Ati;
            return;
        }
        cIZ();
        this.iTV = pVar;
    }

    public final void setWebChromeClient(j jVar) {
        if (jVar == null) {
            this.jFi = new j();
            return;
        }
        cIZ();
        this.jFi = jVar;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        this.Atc.setDownloadListener(new e(this.Arl.getContext(), downloadListener));
    }

    public final void setFindListener(FindListener findListener) {
        this.Atc.setFindListener(new f(findListener));
    }

    public final void loadUrl(String str) {
        if (str == null || !str.trim().startsWith("javascript:")) {
            this.Atj = false;
            this.Atc.loadUrl(str);
            return;
        }
        this.Atc.evaluateJavascript(str, null);
    }

    public final boolean canGoBack() {
        return !this.Atj && this.Atc.getNavigationHistory().canGoBack();
    }

    public final void goBack() {
        if (this.Atc.getNavigationHistory().canGoBack()) {
            this.Atc.getNavigationHistory().navigate(Direction.BACKWARD, 1);
            if (this.Atc.getNavigationHistory() != null && this.Atc.getNavigationHistory().getCurrentItem() != null) {
                this.jFi.d(this.Arl, this.Atc.getNavigationHistory().getCurrentItem().getTitle());
            }
        }
    }

    public final boolean hasEnteredFullscreen() {
        return this.Atc.hasEnteredFullscreen();
    }

    public final void leaveFullscreen() {
        this.Atc.leaveFullscreen();
    }

    public final void clearView() {
    }

    public final void destroy() {
        this.Atc.onDestroy();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.Atc.evaluateJavascript(str, valueCallback);
    }

    public final com.tencent.xweb.c.e getDefalutOpProvider() {
        return this.Ati;
    }

    public final void reload() {
        this.Atc.reload(0);
    }

    public final void clearSslPreferences() {
        this.Atc.clearSslPreferences();
    }

    public final void loadData(String str, String str2, String str3) {
        this.Atc.loadData(str, str2, str3);
    }

    public final int getContentHeight() {
        return this.Atc.getContentHeight();
    }

    public final float getScale() {
        return this.Atc.getScale();
    }

    public final int getVisibleTitleHeight() {
        return 0;
    }

    public final boolean overlayHorizontalScrollbar() {
        int scrollBarStyle = this.Atc.getScrollBarStyle();
        if (scrollBarStyle == 0 || scrollBarStyle == 33554432) {
            return true;
        }
        return false;
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.Atc.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final boolean zoomOut() {
        return this.Atc.zoomOut();
    }

    public final boolean zoomIn() {
        return this.Atc.zoomIn();
    }

    public final void loadUrl(String str, Map<String, String> map) {
        this.Atc.loadUrl(str, map);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.Atc.addJavascriptInterface(obj, str);
    }

    public final View getView() {
        return this.Atc;
    }

    public final String getUrl() {
        return this.Atc.getUrl();
    }

    public final void removeJavascriptInterface(String str) {
        this.Atc.removeJavascriptInterface(str);
    }

    public final void stopLoading() {
        this.Atc.stopLoading();
    }

    public final void setWebViewCallbackClient(o oVar) {
        this.juK = oVar;
    }

    public final a getHitTestResult() {
        a aVar = new a();
        XWalkHitTestResult hitTestResult = this.Atc.getHitTestResult();
        aVar.mType = hitTestResult.getType().ordinal();
        aVar.mExtra = hitTestResult.getExtra();
        return aVar;
    }

    public final String getTitle() {
        return this.Atc.getTitle();
    }

    public final n getSettings() {
        return this.Atg;
    }

    public final View getWebViewUI() {
        return this.Atc;
    }

    public final ViewGroup getTopView() {
        return this.Ath;
    }

    public final void clearMatches() {
        this.Atc.clearMatches();
    }

    public final void findNext(boolean z) {
        this.Atc.findNext(z);
    }

    public final void findAllAsync(String str) {
        this.Atc.findAllAsync(str);
    }

    public final String getVersionInfo() {
        return "webviewType = WV_KIND_CW,V8 type=" + com.tencent.xweb.g.cIn() + " ,apkversion = " + this.mApkVersion + " , " + XWalkEnvironment.getAvailableVersionDetail() + " sdk = 17";
    }

    public final String getAbstractInfo() {
        return "webviewtype = xwalk, sdkver = 17\n apkver = " + XWalkEnvironment.getAvailableVersion();
    }

    public final p getCurWebviewClient() {
        return this.iTV;
    }

    public final j getCurWebChromeClient() {
        return this.jFi;
    }

    public final int getWebScrollY() {
        return this.Atc.computeVerticalScrollOffset();
    }

    public final int getWebScrollX() {
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            return ((XWalkView) webViewUI).computeHorizontalScrollOffset();
        }
        return webViewUI.getScrollX();
    }

    public final boolean isOverScrollStart() {
        int computeVerticalScrollOffset;
        boolean z = this.Atl;
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            computeVerticalScrollOffset = ((XWalkView) webViewUI).computeVerticalScrollOffset();
        } else {
            computeVerticalScrollOffset = webViewUI.getScrollY();
        }
        if (computeVerticalScrollOffset == 0 && z) {
            return true;
        }
        return false;
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
    }

    public final void onPause() {
    }
}
