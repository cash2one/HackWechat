package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class m$1 implements c {
    final /* synthetic */ m jDi;

    m$1(m mVar) {
        this.jDi = mVar;
    }

    public final void a(n nVar) {
        for (l lVar : this.jDi.jDh) {
            if (!(lVar == null || lVar.jAF)) {
                Context context = this.jDi.jcr.mContext;
                p pVar = this.jDi.jcr;
                String str = this.jDi.mAppId;
                this.jDi.jDg.ztf.booleanValue();
                if (lVar != null) {
                    a aVar = (a) com.tencent.mm.plugin.appbrand.menu.n.a.jAW.jAV.get(Integer.valueOf(lVar.id));
                    if (aVar != null) {
                        aVar.a(context, pVar, nVar, str);
                    }
                }
            }
        }
    }
}
