package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.d.a.a.t;
import com.tencent.mm.plugin.card.a.j$b;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.oq;
import com.tencent.pb.common.c.g;

class h$2 implements OnClickListener {
    final /* synthetic */ b kWx;
    final /* synthetic */ h kWy;

    h$2(h hVar, b bVar) {
        this.kWy = hVar;
        this.kWx = bVar;
    }

    public final void onClick(View view) {
        if (this.kWx.atu()) {
            j$b com_tencent_mm_plugin_card_a_j_b = new j$b();
            com.tencent.mm.plugin.card.b.b.a(this.kWy.kWw.kaY, com_tencent_mm_plugin_card_a_j_b.kJD, com_tencent_mm_plugin_card_a_j_b.kJE, false, this.kWx);
        } else {
            oq oqVar = this.kWx.atB().vSm;
            if (oqVar != null && !g.AA(oqVar.vRy) && !g.AA(oqVar.vRx)) {
                int intExtra;
                int intExtra2;
                if (this.kWy.kaY.getIntent() != null) {
                    intExtra = this.kWy.kaY.getIntent().getIntExtra("key_from_scene", 3);
                } else {
                    intExtra = 3;
                }
                if (this.kWy.kaY.getIntent() != null) {
                    intExtra2 = this.kWy.kaY.getIntent().getIntExtra("key_from_appbrand_type", 0);
                } else {
                    intExtra2 = 0;
                }
                com.tencent.mm.plugin.card.b.b.a(this.kWx.atF(), oqVar, intExtra, intExtra2);
                com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(20), this.kWx.atF(), this.kWx.atG(), "", oqVar.title});
            } else if (!(oqVar == null || TextUtils.isEmpty(oqVar.url))) {
                com.tencent.mm.plugin.card.b.b.a(this.kWy.kWw.kaY, l.v(oqVar.url, oqVar.vSM), 1);
                com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(9), this.kWx.atF(), this.kWx.atG(), "", oqVar.title});
                if (l.a(oqVar, this.kWx.atF())) {
                    String atF = this.kWx.atF();
                    String str = oqVar.title;
                    l.wU(atF);
                    com.tencent.mm.plugin.card.b.b.a(this.kWy.kWw.kaY, this.kWx.atB().kLa);
                }
            }
        }
        t.finish();
    }
}
