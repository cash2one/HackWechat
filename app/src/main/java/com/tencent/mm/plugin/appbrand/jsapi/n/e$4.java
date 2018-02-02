package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;

class e$4 implements OnMenuItemClickListener {
    final /* synthetic */ e jvd;
    final /* synthetic */ String jvh;

    e$4(e eVar, String str) {
        this.jvd = eVar;
        this.jvh = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = e.h(this.jvd).isSDCardAvailable();
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        try {
            s.a(e.f(this.jvd), this.jvh, b.cIj().getCookie(this.jvh), isSDCardAvailable);
        } catch (Exception e2) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "save to sdcard failed : %s", new Object[]{e2.getMessage()});
        }
        return true;
    }
}
