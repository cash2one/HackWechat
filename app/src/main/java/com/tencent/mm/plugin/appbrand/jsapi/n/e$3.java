package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;

class e$3 implements OnMenuItemClickListener {
    final /* synthetic */ e jvd;
    final /* synthetic */ String jvh;

    e$3(e eVar, String str) {
        this.jvd = eVar;
        this.jvh = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        try {
            s.a(e.f(this.jvd), this.jvh, b.cIj().getCookie(this.jvh), e.h(this.jvd).isSDCardAvailable(), new 1(this));
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
        }
        return true;
    }
}
