package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;

public final class f {
    final Context mContext;
    public final IX5JsVirtualMachine zVw;
    public final HashSet<WeakReference<a>> zVx;

    private static class a implements IX5JsContext {
        public WebView zVo;

        public a(Context context) {
            this.zVo = new WebView(context);
            this.zVo.getSettings().setJavaScriptEnabled(true);
        }

        public final void addJavascriptInterface(Object obj, String str) {
            if (this.zVo != null) {
                this.zVo.addJavascriptInterface(obj, str);
                this.zVo.loadUrl("about:blank");
            }
        }

        public final void destroy() {
            if (this.zVo != null) {
                this.zVo.clearHistory();
                this.zVo.clearCache(true);
                this.zVo.loadUrl("about:blank");
                this.zVo.freeMemory();
                this.zVo.pauseTimers();
                this.zVo.destroy();
                this.zVo = null;
            }
        }

        public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
            if (this.zVo != null) {
                this.zVo.evaluateJavascript(str, valueCallback == null ? null : new 1(this, valueCallback));
            }
        }

        public final IX5JsValue evaluateScript(String str, URL url) {
            if (this.zVo != null) {
                this.zVo.evaluateJavascript(str, null);
            }
            return null;
        }

        public final void evaluateScriptAsync(String str, ValueCallback<IX5JsValue> valueCallback, URL url) {
            if (this.zVo != null) {
                this.zVo.evaluateJavascript(str, valueCallback == null ? null : new 2(this, valueCallback));
            }
        }

        public final void removeJavascriptInterface(String str) {
            if (this.zVo != null) {
                this.zVo.removeJavascriptInterface(str);
            }
        }

        public final void setExceptionHandler(ValueCallback<IX5JsError> valueCallback) {
        }

        public final void setName(String str) {
        }

        public final void setPerContextData(Object obj) {
        }

        public final void stealValueFromOtherCtx(String str, IX5JsContext iX5JsContext, String str2) {
        }
    }

    public f(Context context) {
        this(context, (byte) 0);
    }

    private f(Context context, byte b) {
        this.zVx = new HashSet();
        this.mContext = context;
        this.zVw = ah.a(context, null);
    }
}
