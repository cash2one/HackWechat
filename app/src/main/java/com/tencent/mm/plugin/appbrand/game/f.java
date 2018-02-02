package com.tencent.mm.plugin.appbrand.game;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.d;
import java.net.URL;

public final class f implements b {
    private g iXl;
    private boolean qG = false;

    public f(g gVar) {
        i iVar = i.iXq;
        x.i("MicroMsg.V8JsVmManager", "GameRenderer.initJsVmContext ThreadName = [%s]", new Object[]{Thread.currentThread().getName()});
        if (iVar.iXr != null) {
            throw new IllegalStateException("Init JsVm Context second time");
        }
        int addAndGet = iVar.iXs.addAndGet(1);
        iVar.iXr = new e(true, new com.tencent.magicbrush.engine.b(), addAndGet);
        iVar.iXt.put(Integer.valueOf(addAndGet), iVar.iXr);
        x.i("MicroMsg.V8JsVmManager", "GameRenderer.initJsVmContext finished");
        this.iXl = gVar;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        a aVar = i.iXq.iXr;
        if (aVar == null) {
            throw new IllegalStateException("JsVmContext Not Initialized, main");
        } else if (str == null || str.isEmpty()) {
            x.e("WAGameJsEngine", "js script is null");
            throw new IllegalArgumentException("js script is null");
        } else if (aVar == null) {
            x.w("WAGameJsEngine", "WAGameJsEngine.evaluateJavaScriptImpl jsVmContext == null");
        } else {
            synchronized (this) {
                if (this.qG) {
                    x.w("WAGameJsEngine", "evaluateSubJavascript is mDestroyed. script : " + str);
                    return;
                }
                aVar.evaluateJavascript(str, valueCallback);
            }
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        a aVar = i.iXq.iXr;
        if (aVar == null) {
            throw new IllegalStateException("JsVmContext Not Initialized, main");
        } else if (str == null || str.isEmpty()) {
            x.e("WAGameJsEngine", "js script is null");
            throw new IllegalArgumentException("js script is null");
        } else {
            synchronized (this) {
                if (this.qG) {
                    x.w("WAGameJsEngine", "evaluateSubJavascript is mDestroyed. script : " + str);
                    return;
                }
                aVar.a(url, str, valueCallback);
            }
        }
    }

    public final void a(d dVar) {
    }

    public final void addJavascriptInterface(Object obj, String str) {
        a aVar = i.iXq.iXr;
        if (obj == null || str == null || str.isEmpty()) {
            x.w("WAGameJsEngine", "addJavaScriptInterface empty! : " + str);
        } else if (aVar == null) {
            x.w("WAGameJsEngine", "");
        } else {
            synchronized (this) {
                if (this.qG) {
                    x.w("WAGameJsEngine", "addJavaScriptInterface mDestroyed. name : " + str);
                    return;
                }
                x.i("WAGameJsEngine", "addJavaScriptInterface name : " + str);
                aVar.addJavascriptInterface(obj, str);
            }
        }
    }

    public final void destroy() {
        synchronized (this) {
            this.qG = true;
        }
    }

    public final <T extends c> T v(Class<T> cls) {
        if (cls.equals(com.tencent.mm.plugin.appbrand.g.f.class) || cls.equals(com.tencent.mm.plugin.appbrand.g.d.class)) {
            return i.iXq;
        }
        return !cls.isInstance(this) ? null : this;
    }
}
