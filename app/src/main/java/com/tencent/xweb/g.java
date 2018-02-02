package com.tencent.xweb;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.f;
import com.tencent.xweb.c.h;
import com.tencent.xweb.xwalk.b;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class g {
    public static a ApO;
    private static String ApQ = "";
    public f ApP;
    public volatile boolean iTN = false;

    public enum a {
        RT_TYPE_AUTO,
        RT_TYPE_SYS,
        RT_TYPE_XWALK,
        RT_TYPE_WEB_X5,
        RT_TYPE_DUMMY,
        RT_TYPE_X5,
        RT_TYPE_J2V8,
        RT_TYPE_NATIVE_SCRIPT,
        RT_TYPE_MMV8
    }

    public static a cIm() {
        return ApO;
    }

    public final boolean isValid() {
        return (this.ApP == null || ApO == a.RT_TYPE_AUTO || ApO == a.RT_TYPE_DUMMY) ? false : true;
    }

    public static String cIn() {
        return ApQ;
    }

    public static g a(a aVar, String str, Context context) {
        return new g(aVar, str, context);
    }

    public static a b(a aVar, String str, Context context) {
        k.iQ(context);
        if (str == null) {
            str = "";
        }
        if (k.cIo().Aqk != a.RT_TYPE_AUTO) {
            aVar = k.cIo().Aqk;
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hardcode jscore type = " + aVar);
        } else if (a.ack(str) != a.RT_TYPE_AUTO) {
            aVar = a.ack(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + str + "use cmd jscore type = " + aVar);
        }
        if (WebView.getCurWebType() == c.AqC) {
            if (a.RT_TYPE_SYS == aVar || a.RT_TYPE_MMV8 == aVar) {
                return aVar;
            }
            return a.RT_TYPE_X5;
        } else if (WebView.getCurWebType() == c.AqB) {
            if (a.RT_TYPE_NATIVE_SCRIPT == aVar || a.RT_TYPE_J2V8 == aVar || a.RT_TYPE_SYS == aVar) {
                return aVar;
            }
            return a.RT_TYPE_MMV8;
        } else if (WebView.getCurWebType() != c.AqD || a.RT_TYPE_SYS == aVar) {
            return aVar;
        } else {
            return a.RT_TYPE_MMV8;
        }
    }

    private g(a aVar, String str, Context context) {
        a aVar2;
        Log.i("JsRuntime", String.format("init JsRuntime (%s)", new Object[]{android.util.Log.getStackTraceString(new Throwable())}));
        a b = b(aVar, str, context);
        switch (1.ApR[b.ordinal()]) {
            case 1:
                this.ApP = h.a(c.AqC).getJsCore(b, context);
                if (this.ApP != null) {
                    ApQ = "x5";
                    break;
                }
                break;
            case 2:
            case 3:
                this.ApP = h.a(c.AqB).getJsCore(b, context);
                if (this.ApP != null) {
                    ApQ = b == a.RT_TYPE_J2V8 ? "j2v8" : "nativeScript";
                    break;
                }
                break;
            case 4:
                this.ApP = new b();
                this.ApP.init(0);
                ApQ = "mmv8";
                break;
        }
        if (this.ApP != null) {
            aVar2 = b;
        } else if (a.RT_TYPE_SYS == b || a.RT_TYPE_X5 == b) {
            aVar2 = a.RT_TYPE_DUMMY;
            this.ApP = new com.tencent.xweb.c.c();
        } else {
            aVar2 = a.RT_TYPE_MMV8;
            this.ApP = new b();
            this.ApP.init(0);
            ApQ = "mmv8";
        }
        ApO = aVar2;
        Log.d("JsRuntime", "xxx IJsRuntime  request=" + aVar2.toString() + ", create=" + ApQ);
    }

    public final void cleanup() {
        if (!this.iTN) {
            this.ApP.cleanup();
        }
        this.iTN = true;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.iTN) {
            this.ApP.evaluateJavascript(str, valueCallback);
        }
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.ApP.addJavascriptInterface(obj, str);
    }

    public final void pause() {
        this.ApP.pause();
    }

    public final void resume() {
        this.ApP.resume();
    }

    public final boolean BZ() {
        return this.ApP.BZ();
    }
}
