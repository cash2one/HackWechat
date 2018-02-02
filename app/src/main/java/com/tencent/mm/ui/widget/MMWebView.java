package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import java.lang.reflect.Method;

public class MMWebView extends WebView {
    public static final c zvD = c.AqC;
    public static final String zvE = null;
    public boolean gGO;
    private OnTouchListener sqw;
    public String tGT;
    public boolean zvC;
    protected boolean zvF;
    private boolean zvG;
    public ViewGroup zvH;
    public d zvI;

    private class b {
        final /* synthetic */ MMWebView zvJ;

        private b(MMWebView mMWebView) {
            this.zvJ = mMWebView;
        }
    }

    public MMWebView(Context context) {
        this(context, null);
    }

    public MMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gGO = false;
        this.zvF = false;
        this.zvG = false;
        this.zvI = null;
        cyU();
    }

    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @TargetApi(11)
    public final void cyU() {
        try {
            if (VERSION.SDK_INT >= 11) {
                super.removeJavascriptInterface("searchBoxJavaBridge_");
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", new Object[]{e.getMessage()});
        }
    }

    public final void cyV() {
        if (VERSION.SDK_INT >= 5) {
            c cVar = new c(this, (byte) 0);
            setScrollbarFadingEnabled(true);
            setScrollBarStyle(0);
            return;
        }
        b bVar = new b();
        setScrollBarStyle(0);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!bh.ov(str)) {
            int i;
            if (d.fM(19) || this.isX5Kernel) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                super.evaluateJavascript(str, valueCallback);
            } else if (!this.zvF || !a(this, str)) {
                try {
                    if (!str.startsWith("javascript:")) {
                        str = "javascript:" + str;
                    }
                    super.loadUrl(str);
                } catch (Exception e) {
                    x.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", new Object[]{e.getMessage()});
                }
            }
        }
    }

    private static boolean a(MMWebView mMWebView, String str) {
        try {
            Object obj = new com.tencent.mm.compatible.loader.c(new com.tencent.mm.compatible.loader.c(new com.tencent.mm.compatible.loader.c(mMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
            Method declaredMethod = obj.getClass().getDeclaredMethod("sendMessage", new Class[]{Message.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[]{Message.obtain(null, JsApiUploadEncryptedFileToCDN.CTRL_INDEX, str)});
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", new Object[]{e});
            return false;
        }
    }

    public final void cyW() {
        super.setOnTouchListener(new 1(this));
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.sqw = onTouchListener;
    }

    @TargetApi(9)
    public final boolean b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean super_overScrollBy = super.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        if (i4 < 0 || (i4 == 0 && i2 < 0)) {
            this.zvG = true;
        }
        return super_overScrollBy;
    }

    public final boolean O(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean super_onTouchEvent = super.super_onTouchEvent(motionEvent);
        switch (action & 255) {
            case 0:
                this.zvG = false;
                break;
            case 2:
                if (this.zvH != null) {
                    if (!this.zvG) {
                        this.zvH.requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                    this.zvH.requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
        }
        if (!super_onTouchEvent) {
            return super_onTouchEvent;
        }
        if (this.zvG) {
            return false;
        }
        return true;
    }

    @TargetApi(9)
    public final void c(int i, int i2, boolean z, boolean z2) {
        super.super_onOverScrolled(i, i2, z, z2);
    }

    public final boolean P(MotionEvent motionEvent) {
        return super.super_dispatchTouchEvent(motionEvent);
    }

    public final boolean Q(MotionEvent motionEvent) {
        return super.super_onInterceptTouchEvent(motionEvent);
    }

    @TargetApi(9)
    public final void cyX() {
        super.super_computeScroll();
    }

    public final void x(int i, int i2, int i3, int i4) {
        super.super_onScrollChanged(i, i2, i3, i4);
    }

    public static void ge(Context context) {
        boolean z;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        x.i("MicroMsg.MMWebView", "initTbsSettings, tbsDisable = %s, minSdkVersion = %s, maxSdkVersion = %s", new Object[]{sharedPreferences.getString("tbs_webview_disable", "0"), sharedPreferences.getString("tbs_webview_min_sdk_version", null), sharedPreferences.getString("tbs_webview_max_sdk_version", null)});
        if ("1".equals(sharedPreferences.getString("tbs_webview_disable", "0"))) {
            int i = bh.getInt(r4, 0);
            int i2 = bh.getInt(r5, 0);
            int i3 = VERSION.SDK_INT;
            if (i3 >= i && (i3 <= i2 || i2 == 0)) {
                x.i("MicroMsg.MMWebView", "in selection, disable x5");
                z = false;
                x.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", new Object[]{Boolean.valueOf(z)});
                if (!z) {
                    com.tencent.xweb.x5.sdk.d.forceSysWebView();
                }
                x.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[]{Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)), Boolean.valueOf(bh.cgC())});
                if (!sharedPreferences.getBoolean("tbs_download_oversea", false) && r3) {
                    com.tencent.xweb.x5.sdk.d.forceSysWebView();
                    return;
                }
            }
        }
        z = true;
        x.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            com.tencent.xweb.x5.sdk.d.forceSysWebView();
        }
        x.i("MicroMsg.MMWebView", "initTbsSettings, tbs_download_oversea = %b, isGPVersion = %b", new Object[]{Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)), Boolean.valueOf(bh.cgC())});
        if (!sharedPreferences.getBoolean("tbs_download_oversea", false)) {
        }
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        super.onWebViewScrollChanged(i, i2, i3, i4);
        if (this.zvI != null) {
            this.zvI.onWebViewScrollChanged(i, i2, i3, i4);
        }
    }
}
