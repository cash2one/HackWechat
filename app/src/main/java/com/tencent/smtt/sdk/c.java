package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.sdk.f.a;
import java.lang.ref.WeakReference;
import java.net.URL;

public final class c {
    public final f zVp;
    public final IX5JsContext zVq;
    public a zVr;

    public c(Context context) {
        this(new f(context));
    }

    private c(f fVar) {
        IX5JsContext aVar;
        this.zVp = fVar;
        f fVar2 = this.zVp;
        if (fVar2.zVw == null) {
            aVar = new a(fVar2.mContext);
            fVar2.zVx.add(new WeakReference(aVar));
        } else {
            aVar = fVar2.zVw.createJsContext();
        }
        this.zVq = aVar;
        try {
            this.zVq.setPerContextData(this);
        } catch (AbstractMethodError e) {
        }
    }

    public static c cDP() {
        return (c) ah.cFl();
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.zVq.addJavascriptInterface(obj, str);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        this.zVq.evaluateJavascript(str, valueCallback, url);
    }
}
