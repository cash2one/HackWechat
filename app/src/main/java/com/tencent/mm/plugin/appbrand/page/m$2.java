package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.ui.base.p$d;

class m$2 implements p$d {
    final /* synthetic */ m jDi;

    m$2(m mVar) {
        this.jDi = mVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int kY = m.kY(menuItem.getItemId());
        if (kY != 0) {
            Object obj;
            l d = n.d(this.jDi.jDh, kY - 1);
            Context context = this.jDi.jcr.mContext;
            p pVar = this.jDi.jcr;
            String str = this.jDi.mAppId;
            if (d == null) {
                obj = null;
            } else {
                a aVar = (a) n.a.jAW.jAV.get(Integer.valueOf(d.id));
                if (aVar == null) {
                    obj = null;
                } else {
                    aVar.a(context, pVar, str, d);
                    obj = 1;
                }
            }
            if (obj != null) {
                this.jDi.jDg.bxh();
            }
        }
    }
}
