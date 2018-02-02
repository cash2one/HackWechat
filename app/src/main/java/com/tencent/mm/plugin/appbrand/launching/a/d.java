package com.tencent.mm.plugin.appbrand.launching.a;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class d extends a {
    d() {
    }

    final void a(Uri uri, int i) {
        switch (1.jyJ[i - 1]) {
            case 1:
                AppBrand404PageUI.show(j.iyF);
                return;
            case 2:
                AppBrand404PageUI.show(j.iyG);
                return;
            case 3:
                AppBrand404PageUI.show(j.iBc);
                return;
            case 4:
                return;
            default:
                AppBrand404PageUI.show(j.iyV);
                return;
        }
    }
}
