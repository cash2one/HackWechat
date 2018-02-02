package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class AppBrandProfileUI$4 implements d {
    final /* synthetic */ AppBrandProfileUI jLy;

    AppBrandProfileUI$4(AppBrandProfileUI appBrandProfileUI) {
        this.jLy = appBrandProfileUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                if (AppBrandProfileUI.b(this.jLy) == null) {
                    x.e("MicroMsg.AppBrandProfileUI", "wxaExposedParams is null");
                    return;
                }
                Intent intent = new Intent();
                String a = l.a(AppBrandProfileUI.b(this.jLy));
                x.i("MicroMsg.AppBrandProfileUI", "wxaExposedParams:%s", new Object[]{AppBrandProfileUI.b(this.jLy).toString()});
                x.v("MicroMsg.AppBrandProfileUI", "KRawUrl " + a);
                intent.putExtra("rawUrl", a);
                intent.putExtra("forceHideShare", true);
                com.tencent.mm.bm.d.b(this.jLy, "webview", ".ui.tools.WebViewUI", intent);
                AppBrandProfileUI.a(this.jLy, 7, 1);
                if (AppBrandProfileUI.b(this.jLy).fqe == 3) {
                    AppBrandOnOpReportStartEvent.sG(AppBrandProfileUI.c(this.jLy).appId);
                    return;
                }
                return;
            case 2:
                com.tencent.mm.bm.d.b(this.jLy, "appbrand", ".ui.AppBrandAuthorizeUI", new Intent(this.jLy, AppBrandAuthorizeUI.class).putExtra("key_username", AppBrandProfileUI.d(this.jLy)));
                AppBrandProfileUI.a(this.jLy, 10, 1);
                return;
            default:
                return;
        }
    }
}
