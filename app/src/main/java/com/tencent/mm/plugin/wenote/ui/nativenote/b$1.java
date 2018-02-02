package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.h;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements OnClickListener {
    final /* synthetic */ b tXs;

    b$1(b bVar) {
        this.tXs = bVar;
    }

    public final void onClick(View view) {
        x.i("WNNoteBanner", "click WNNoteBanner");
        p bWK = h.bWJ().bWK();
        if (bWK == null) {
            x.i("WNNoteBanner", "keepTopItem is null");
            this.tXs.setVisibility(8);
        } else if (bWK.tRS) {
            if (bWK.tRV) {
                g.pQN.h(14789, new Object[]{Integer.valueOf(3)});
            } else {
                g.pQN.h(14789, new Object[]{Integer.valueOf(2)});
            }
            x.i("WNNoteBanner", "isOpenFromSession: true");
            d jVar = new j();
            c.bVN().tQn = jVar;
            vg vgVar = new vg();
            vgVar.scene = 8;
            jVar.a(bWK.tRX, Long.valueOf(bWK.tRU), true, (Context) this.tXs.voC.get(), bWK.tRY, bWK.tRZ, vgVar);
        } else {
            g.pQN.h(14789, new Object[]{Integer.valueOf(1)});
            x.i("WNNoteBanner", "isOpenFromSession: false");
            d gVar = new com.tencent.mm.plugin.wenote.model.g();
            c.bVN().tQn = gVar;
            vg vgVar2 = new vg();
            vgVar2.scene = 8;
            gVar.a(bWK.tRT, (Context) this.tXs.voC.get(), Boolean.valueOf(true), bWK.tRY, bWK.tRZ, vgVar2);
        }
    }
}
