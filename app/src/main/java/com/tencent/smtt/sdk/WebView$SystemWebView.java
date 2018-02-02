package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;

class WebView$SystemWebView extends WebView {
    final /* synthetic */ WebView this$0;

    public WebView$SystemWebView(WebView webView, Context context) {
        this(webView, context, null);
    }

    public WebView$SystemWebView(WebView webView, Context context, AttributeSet attributeSet) {
        this.this$0 = webView;
        super(context, attributeSet);
        if (!QbSdk.getIsSysWebViewForcedByOuter() || !x.hq(context)) {
            CookieSyncManager.createInstance(WebView.a(webView)).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
                WebView.mSysWebviewCreated = true;
            } catch (Exception e) {
            }
        }
    }

    public void computeScroll() {
        if (this.this$0.mWebViewCallbackClient != null) {
            this.this$0.mWebViewCallbackClient.computeScroll(this);
        } else {
            super.computeScroll();
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
            if (!WebView.cq() && WebView.cFe() != null) {
                canvas.save();
                canvas.drawPaint(WebView.cFe());
                canvas.restore();
            }
        } catch (Throwable th) {
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.this$0.mWebViewCallbackClient != null ? this.this$0.mWebViewCallbackClient.dispatchTouchEvent(motionEvent, this) : super.dispatchTouchEvent(motionEvent);
    }

    public WebSettings getSettings() {
        try {
            return super.getSettings();
        } catch (Exception e) {
            return null;
        }
    }

    public void invalidate() {
        super.invalidate();
        if (this.this$0.mWebViewCallbackClient != null) {
            ae aeVar = this.this$0.mWebViewCallbackClient;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.this$0.mWebViewCallbackClient != null ? this.this$0.mWebViewCallbackClient.onInterceptTouchEvent(motionEvent, this) : super.onInterceptTouchEvent(motionEvent);
    }

    @TargetApi(9)
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.this$0.mWebViewCallbackClient != null) {
            this.this$0.mWebViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
        } else if (VERSION.SDK_INT >= 9) {
            super.onOverScrolled(i, i2, z, z2);
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.this$0.mWebViewCallbackClient != null) {
            this.this$0.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        WebView.b(this.this$0, i, i2, i3, i4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!hasFocus()) {
            requestFocus();
        }
        if (this.this$0.mWebViewCallbackClient != null) {
            return this.this$0.mWebViewCallbackClient.onTouchEvent(motionEvent, this);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @TargetApi(9)
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return this.this$0.mWebViewCallbackClient != null ? this.this$0.mWebViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, this) : VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
    }

    public void setOverScrollMode(int i) {
        try {
            super.setOverScrollMode(i);
        } catch (Exception e) {
        }
    }

    public void super_computeScroll() {
        super.computeScroll();
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @TargetApi(9)
    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (VERSION.SDK_INT >= 9) {
            super.onOverScrolled(i, i2, z, z2);
        }
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @TargetApi(9)
    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
    }
}
