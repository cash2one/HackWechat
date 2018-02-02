package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.base.n;

public final class e extends a {
    public e() {
        super(m.jAT - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        if (AppBrandPerformanceManager.tT(str)) {
            nVar.f(m.jAT - 1, context.getString(j.iAr));
        }
    }

    public final void a(final Context context, p pVar, final String str, l lVar) {
        Toast.makeText(context, j.iAt, 0).show();
        c.Dm().F(new Runnable(this) {
            final /* synthetic */ e jAy;

            public final void run() {
                c.runOnUiThread(new 1(this, com.tencent.mm.plugin.appbrand.performance.a.tW(str)));
            }
        });
    }
}
