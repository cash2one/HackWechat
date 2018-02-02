package com.tencent.mm.plugin.appbrand.game;

import android.webkit.ValueCallback;
import com.tencent.magicbrush.engine.b;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.d;
import java.net.URL;

public final class e implements a {
    private int iXi;
    b iXj;
    private boolean iXk;

    public e(boolean z, b bVar, int i) {
        this.iXj = bVar;
        this.iXi = i;
        this.iXk = z;
    }

    public final void addJavascriptInterface(Object obj, String str) {
        if (this.iXj != null) {
            this.iXj.c(obj, str);
        }
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.iXj == null || bh.ov(str)) {
            x.e("MicroMsg.WAGameJsContextImpl", "evaluate Error : [%s], [%s]", new Object[]{this.iXj, str});
            if (valueCallback != null) {
                valueCallback.onReceiveValue("");
                return;
            }
            return;
        }
        String by = this.iXj.by(str);
        if (valueCallback != null) {
            valueCallback.onReceiveValue(bh.ou(by));
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        if (url == null) {
            evaluateJavascript(str, valueCallback);
        } else if (this.iXj == null || bh.ov(str)) {
            x.e("MicroMsg.WAGameJsContextImpl", "evaluate Error : [%s], [%s]", new Object[]{this.iXj, str});
            if (valueCallback != null) {
                valueCallback.onReceiveValue("");
            }
        } else {
            String q = this.iXj.q(str, url.toString());
            if (valueCallback != null) {
                valueCallback.onReceiveValue(bh.ou(q));
            }
        }
    }

    public final void a(d dVar) {
    }

    public final void destroy() {
        if (this.iXj != null) {
            this.iXj.dispose();
        }
    }

    public final <T extends c> T v(Class<T> cls) {
        return null;
    }

    public final boolean adH() {
        return this.iXk;
    }

    public final int adI() {
        return this.iXi;
    }

    public final void a(a aVar, String str) {
        if (aVar == null || bh.ov(str)) {
            x.e("MicroMsg.WAGameJsContextImpl", "shareObject object name is null [%s], [%s]", new Object[]{aVar, str});
        } else if (aVar instanceof e) {
            this.iXj.a(((e) aVar).iXj, str);
        } else {
            x.e("MicroMsg.WAGameJsContextImpl", "share Object with different JSContext type , [%s]", new Object[]{aVar});
        }
    }
}
