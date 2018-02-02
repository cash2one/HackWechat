package com.tencent.mm.u.c;

import android.webkit.JavascriptInterface;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.c;
import com.tencent.mm.u.b.d;

public final class e {
    public volatile boolean Vx;
    public String gOP;
    public c gOQ;
    public f gOR;
    public d gOS;
    private volatile boolean gOT;
    public a gOU;

    @JavascriptInterface
    public final void publishHandler(String str, String str2, String str3) {
        int i = 0;
        String str4 = "MicroMsg.MiniJsBridge";
        String str5 = "publishHandler, event: %s, data size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 != null) {
            i = str2.length();
        }
        objArr[1] = Integer.valueOf(i);
        x.d(str4, str5, objArr);
    }

    @JavascriptInterface
    public final String invokeHandler(String str, String str2, int i) {
        if (this.Vx) {
            return this.gOQ.b(str, str2, i);
        }
        return this.gOQ.gOJ.G(str, "fail:JsApi core not started");
    }

    public final boolean a(c cVar) {
        f fVar = this.gOR;
        if (cVar == null) {
            x.i("MicroMsg.MiniJsEventDispatcher", "dispatchJsEvent failed, event is null.");
            return false;
        }
        com.tencent.mm.u.b.e fs = fVar.gOV.fs(cVar.name);
        if (fs == null) {
            x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[]{cVar});
            return false;
        } else if (fVar.gOH.gn(fs.getIndex())) {
            String jSONObject = cVar.sN().toString();
            x.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[]{cVar.name, Integer.valueOf(jSONObject.length()), Integer.valueOf(0)});
            fVar.gOS.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{cVar.name, jSONObject, "undefined", f.Cc()}), null);
            return true;
        } else {
            x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[]{cVar});
            return false;
        }
    }

    public final void b(c cVar) {
        if (!this.gOT) {
            x.v("MicroMsg.MiniJsBridge", "onPause(%s)", new Object[]{this.gOP});
            this.gOT = true;
            if (this.gOS.BZ()) {
                this.gOS.pause();
            } else {
                a(cVar);
            }
            if (this.gOU != null) {
                this.gOU.B(this.gOP, 3);
            }
        }
    }

    public final void c(c cVar) {
        if (this.gOT) {
            x.v("MicroMsg.MiniJsBridge", "onResume(%s)", new Object[]{this.gOP});
            if (this.gOS.BZ()) {
                this.gOS.resume();
            } else {
                a(cVar);
            }
            this.gOT = false;
            if (this.gOU != null) {
                this.gOU.B(this.gOP, 2);
            }
        }
    }

    public final void onStart() {
        if (!this.Vx) {
            x.v("MicroMsg.MiniJsBridge", "onStart(%s)", new Object[]{this.gOP});
            this.Vx = true;
            if (this.gOU != null) {
                this.gOU.B(this.gOP, 1);
            }
        }
    }
}
