package com.tencent.xweb.x5;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView$HitTestResult;
import com.tencent.smtt.sdk.ah;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.e;
import com.tencent.xweb.c.g;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.x5.a.a;
import com.tencent.xweb.x5.a.a.a.a.b;
import com.tencent.xweb.x5.a.d;
import com.tencent.xweb.x5.a.f;
import com.tencent.xweb.x5.sdk.ProxyWebViewSuperWrapper;
import java.util.Map;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public final class j implements g {
    WebView Arl;
    p Arn;
    com.tencent.xweb.j Aro;
    long Arr = 0;
    i Asd;
    k Ase;
    private b Asf = new 1(this);
    private c Asg = new 2(this);
    com.tencent.smtt.sdk.WebView zVo;

    public j(WebView webView) {
        this.Arl = webView;
        this.zVo = new a(this, webView.getContext());
        this.Asd = new i(this.zVo);
        this.zVo.setWebChromeClient(this.Asf);
        this.zVo.setWebViewClient(this.Asg);
        this.Asd.ArW = this.Asg;
        this.Asd.ArX = this.Asf;
    }

    public final Object getX5WebViewExtension() {
        return this.zVo.getX5WebViewExtension();
    }

    public final void setWebViewClientExtension(b bVar) {
        this.zVo.setWebViewClientExtension(new ProxyWebViewSuperWrapper(bVar));
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        return this.zVo.super_onTouchEvent(motionEvent);
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.zVo.super_onInterceptTouchEvent(motionEvent);
    }

    public final void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        this.zVo.super_onOverScrolled(i, i2, z, z2);
    }

    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return this.zVo.super_dispatchTouchEvent(motionEvent);
    }

    public final void super_computeScroll() {
        this.zVo.super_computeScroll();
    }

    public final void super_onScrollChanged(int i, int i2, int i3, int i4) {
        this.zVo.super_onScrollChanged(i, i2, i3, i4);
    }

    public final boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return this.zVo.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final void onResume() {
        this.zVo.onResume();
    }

    public final void onPause() {
        this.zVo.onPause();
    }

    public final n getSettings() {
        if (this.Ase != null) {
            return this.Ase;
        }
        if (this.zVo == null) {
            return null;
        }
        this.Ase = new k(this.zVo);
        return this.Ase;
    }

    public final View getView() {
        return this.zVo.getView();
    }

    public final ViewGroup getTopView() {
        return (ViewGroup) this.zVo.getView();
    }

    public final View getWebViewUI() {
        return this.zVo;
    }

    public final void setWebViewClient(p pVar) {
        this.Arn = pVar;
    }

    public final void setWebChromeClient(com.tencent.xweb.j jVar) {
        this.Aro = jVar;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        this.zVo.setDownloadListener(new a(downloadListener));
    }

    public final void setFindListener(FindListener findListener) {
        this.zVo.setFindListener(new a.b(findListener));
    }

    public final void loadUrl(String str) {
        this.zVo.loadUrl(str);
    }

    public final boolean canGoBack() {
        return this.zVo.canGoBack();
    }

    public final void goBack() {
        this.zVo.goBack();
    }

    public final boolean hasEnteredFullscreen() {
        return false;
    }

    public final void leaveFullscreen() {
    }

    public final void clearView() {
        this.zVo.clearView();
    }

    public final void destroy() {
        this.zVo.destroy();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.zVo.evaluateJavascript(str, new d(valueCallback));
    }

    public final e getDefalutOpProvider() {
        return this.Asd;
    }

    public final void reload() {
        this.zVo.reload();
    }

    public final void clearSslPreferences() {
        this.zVo.clearSslPreferences();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zVo.loadData(str, str2, str3);
    }

    public final int getContentHeight() {
        return this.zVo.getContentHeight();
    }

    public final float getScale() {
        return this.zVo.getScale();
    }

    public final int getVisibleTitleHeight() {
        return this.zVo.getVisibleTitleHeight();
    }

    public final boolean overlayHorizontalScrollbar() {
        return this.zVo.overlayHorizontalScrollbar();
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zVo.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final boolean zoomOut() {
        return this.zVo.zoomOut();
    }

    public final boolean zoomIn() {
        return this.zVo.zoomIn();
    }

    public final void loadUrl(String str, Map<String, String> map) {
        this.zVo.loadUrl(str, map);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.zVo.addJavascriptInterface(obj, str);
    }

    public final String getUrl() {
        return this.zVo.getUrl();
    }

    public final void removeJavascriptInterface(String str) {
        this.zVo.removeJavascriptInterface(str);
    }

    public final void stopLoading() {
        this.zVo.stopLoading();
    }

    public final void setWebViewCallbackClient(o oVar) {
        this.zVo.setWebViewCallbackClient(new f(oVar));
    }

    public final WebView.a getHitTestResult() {
        WebView$HitTestResult hitTestResult = this.zVo.getHitTestResult();
        WebView.a aVar = new WebView.a();
        aVar.mType = hitTestResult.getType();
        aVar.mExtra = hitTestResult.getExtra();
        return aVar;
    }

    public final String getTitle() {
        return this.zVo.getTitle();
    }

    public final void clearMatches() {
        this.zVo.clearMatches();
    }

    public final void findNext(boolean z) {
        this.zVo.findNext(z);
    }

    public final void findAllAsync(String str) {
        this.zVo.findAllAsync(str);
    }

    public final String getVersionInfo() {
        if ((this.zVo.getX5WebViewExtension() != null ? 1 : null) != null) {
            return "use x5 and x5 kernel, wrapper version = 3, V8 type=" + com.tencent.xweb.g.cIn();
        }
        return "use x5 but sys kernel, wrapper version = 3, V8 type=" + com.tencent.xweb.g.cIn();
    }

    public final String getAbstractInfo() {
        return "webviewtype = x5, is using x5 core = " + (this.zVo.getX5WebViewExtension() != null) + "\n core version = " + QbSdk.getTbsVersion(this.Arl.getContext()) + "\n miniqbversion = " + QbSdk.getMiniQBVersion(this.Arl.getContext()) + "\n canUseX5JsCore = " + ah.hF(this.Arl.getContext()) + "\n canUseNativeBuffer = " + ah.hG(this.Arl.getContext());
    }

    public final p getCurWebviewClient() {
        return this.Arn;
    }

    public final com.tencent.xweb.j getCurWebChromeClient() {
        return this.Aro;
    }

    public final int getWebScrollY() {
        return this.zVo.getWebScrollY();
    }

    public final int getWebScrollX() {
        return getWebViewUI().getScrollX();
    }

    public final boolean isOverScrollStart() {
        return getView().getScrollY() == 0;
    }
}
