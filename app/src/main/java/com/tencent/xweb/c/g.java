package com.tencent.xweb.c;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.x5.a.a.a.a.b;
import java.util.Map;

public interface g {
    void addJavascriptInterface(Object obj, String str);

    boolean canGoBack();

    void clearMatches();

    void clearSslPreferences();

    void clearView();

    void destroy();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void findAllAsync(String str);

    void findNext(boolean z);

    String getAbstractInfo();

    int getContentHeight();

    j getCurWebChromeClient();

    p getCurWebviewClient();

    e getDefalutOpProvider();

    a getHitTestResult();

    float getScale();

    n getSettings();

    String getTitle();

    ViewGroup getTopView();

    String getUrl();

    String getVersionInfo();

    View getView();

    int getVisibleTitleHeight();

    int getWebScrollX();

    int getWebScrollY();

    View getWebViewUI();

    Object getX5WebViewExtension();

    void goBack();

    boolean hasEnteredFullscreen();

    boolean isOverScrollStart();

    void leaveFullscreen();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    @TargetApi(8)
    void loadUrl(String str, Map<String, String> map);

    void onPause();

    void onResume();

    boolean overlayHorizontalScrollbar();

    void reload();

    void removeJavascriptInterface(String str);

    void setDownloadListener(DownloadListener downloadListener);

    void setFindListener(FindListener findListener);

    void setWebChromeClient(j jVar);

    void setWebViewCallbackClient(o oVar);

    void setWebViewClient(p pVar);

    void setWebViewClientExtension(b bVar);

    void stopLoading();

    void super_computeScroll();

    boolean super_dispatchTouchEvent(MotionEvent motionEvent);

    boolean super_onInterceptTouchEvent(MotionEvent motionEvent);

    void super_onOverScrolled(int i, int i2, boolean z, boolean z2);

    void super_onScrollChanged(int i, int i2, int i3, int i4);

    boolean super_onTouchEvent(MotionEvent motionEvent);

    boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z);

    boolean zoomIn();

    boolean zoomOut();
}
