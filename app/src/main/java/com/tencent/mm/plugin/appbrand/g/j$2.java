package com.tencent.mm.plugin.appbrand.g;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.util.Iterator;

class j$2 extends p {
    final /* synthetic */ j jvX;

    j$2(j jVar) {
        this.jvX = jVar;
    }

    public final void a(WebView webView, String str) {
        synchronized (j.a(this.jvX)) {
            Iterator it = j.a(this.jvX).iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                j.b(this.jvX, (String) pair.first, (ValueCallback) pair.second);
            }
            j.a(this.jvX).clear();
            j.b(this.jvX);
        }
    }

    public final boolean b(WebView webView, String str) {
        return true;
    }
}
