package com.tencent.mm.plugin.appbrand.launching.a;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class e extends a {
    e() {
    }

    final void a(Uri uri, int i) {
        int i2 = 1;
        String queryParameter = uri == null ? "" : uri.getQueryParameter("appid");
        switch (1.jyJ[i - 1]) {
            case 1:
                int i3;
                if (uri == null || !uri.getBooleanQueryParameter("debug", false)) {
                    boolean z = false;
                } else {
                    i3 = 1;
                }
                AppBrand404PageUI.show(j.iBl);
                if (i3 == 0) {
                    i2 = 0;
                }
                a.z(queryParameter, 2, i2 + 1);
                return;
            case 2:
                AppBrand404PageUI.show(j.iBb);
                a.z("", 3, 2);
                return;
            case 3:
                AppBrand404PageUI.show(j.iBc);
                a.z("", 4, 2);
                return;
            case 4:
                return;
            default:
                AppBrand404PageUI.show(j.iyV);
                return;
        }
    }
}
