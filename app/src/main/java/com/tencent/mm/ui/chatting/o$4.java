package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.ui.base.p.d;

class o$4 implements d {
    final /* synthetic */ int xMz;
    final /* synthetic */ o ysq;

    o$4(o oVar, int i) {
        this.ysq = oVar;
        this.xMz = i;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                Intent intent = new Intent();
                g.pQN.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                k.a(o.f(this.ysq), new Intent(), this.ysq.crz(), this.xMz);
                return;
            case 5:
                com.tencent.mm.bm.d.b(o.f(this.ysq).getContext(), "mmsight", ".ui.SightSettingsUI", new Intent());
                return;
            default:
                return;
        }
    }
}
