package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;

public final class b extends a {
    public b() {
        super(m.jAG - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        if (pVar.aeL()) {
            nVar.f(this.jAX, context.getString(j.iyE));
        }
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        pVar.irP.iqC.aiR();
        if (pVar.jDS != null) {
            com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 20, "", bh.Wo(), 1, 0);
        }
    }
}
