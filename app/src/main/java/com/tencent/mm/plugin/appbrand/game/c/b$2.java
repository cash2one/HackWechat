package com.tencent.mm.plugin.appbrand.game.c;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.util.Iterator;

class b$2 extends p {
    final /* synthetic */ b iYt;

    b$2(b bVar) {
        this.iYt = bVar;
    }

    public final m c(WebView webView, String str) {
        return rM(str);
    }

    public final m a(WebView webView, l lVar) {
        return rM(lVar.getUrl().toString());
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        return rM(lVar.getUrl().toString());
    }

    private static m rM(String str) {
        if ("wagame://WAGameVConsole.html".equals(str)) {
            return v.pF("WAGameVConsole.html");
        }
        return null;
    }

    public final void a(WebView webView, String str) {
        b.a(this.iYt);
        if (b.b(this.iYt) != null && !b.b(this.iYt).isEmpty()) {
            Iterator it = b.b(this.iYt).iterator();
            while (it.hasNext()) {
                b.a(this.iYt, (String) it.next());
            }
        }
    }
}
