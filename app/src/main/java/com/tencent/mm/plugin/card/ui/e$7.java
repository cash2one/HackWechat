package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.R;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class e$7 extends c<bu> {
    final /* synthetic */ e kRr;

    e$7(e eVar) {
        this.kRr = eVar;
        this.xen = bu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bu buVar = (bu) bVar;
        if (ar.Hj()) {
            x.i("MicroMsg.CardDetailUIContoller", "deal with card notify event ConsumedCardByOfflinePayEvent");
            if (buVar instanceof bu) {
                if (buVar.fpX.bjW == 0) {
                    d.b(this.kRr.kQM, this.kRr.kQM.getResources().getString(R.l.dPS));
                }
                return true;
            }
        }
        return false;
    }
}
