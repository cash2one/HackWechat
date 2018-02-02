package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.oq;
import com.tencent.pb.common.c.g;

class n$2 implements OnClickListener {
    final /* synthetic */ n kWJ;
    final /* synthetic */ oq kWK;
    final /* synthetic */ b kWL;

    n$2(n nVar, oq oqVar, b bVar) {
        this.kWJ = nVar;
        this.kWK = oqVar;
        this.kWL = bVar;
    }

    public final void onClick(View view) {
        if (!g.AA(this.kWK.vRy) && !g.AA(this.kWK.vRx)) {
            int intExtra;
            int intExtra2 = this.kWJ.kaY.getIntent() != null ? this.kWJ.kaY.getIntent().getIntExtra("key_from_scene", 3) : 3;
            if (this.kWJ.kaY.getIntent() != null) {
                intExtra = this.kWJ.kaY.getIntent().getIntExtra("key_from_appbrand_type", 0);
            } else {
                intExtra = 0;
            }
            com.tencent.mm.plugin.card.b.b.a(this.kWL.atF(), this.kWK, intExtra2, intExtra);
            com.tencent.mm.plugin.report.service.g.pQN.h(11941, new Object[]{Integer.valueOf(20), this.kWL.atF(), this.kWL.atG(), "", this.kWK.title});
        } else if (g.AA(this.kWK.url)) {
            d.a(this.kWJ.kaY, this.kWJ.kaY.getString(R.l.dPR), true);
        } else {
            com.tencent.mm.plugin.card.b.b.a(this.kWJ.kaY, l.v(this.kWK.url, this.kWK.vSM), 1);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(9);
            objArr[1] = this.kWL.atF();
            objArr[2] = this.kWL.atG();
            objArr[3] = "";
            objArr[4] = this.kWK.title != null ? this.kWK.title : "";
            gVar.h(11941, objArr);
        }
    }
}
