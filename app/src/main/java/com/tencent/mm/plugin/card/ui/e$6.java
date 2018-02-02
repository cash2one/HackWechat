package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.q;

class e$6 implements a {
    final /* synthetic */ String gIT;
    final /* synthetic */ e kRr;
    final /* synthetic */ int pa;

    e$6(e eVar, int i, String str) {
        this.kRr = eVar;
        this.pa = i;
        this.gIT = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            this.kRr.kRj = str;
            if (this.pa == 0) {
                if (this.kRr.kRn != null) {
                    this.kRr.kRn.wA(this.gIT);
                }
                g.pQN.h(11582, new Object[]{"OperGift", Integer.valueOf(1), Integer.valueOf(this.kRr.kIK.atB().kJO), this.kRr.kIK.atG(), this.kRr.kIK.atF(), this.kRr.kRi});
                h.bu(this.kRr.kQM, this.kRr.kQM.getResources().getString(R.l.dOo));
            } else if (this.pa == 1) {
                r0 = this.kRr;
                r0.kIK.atD().wLJ = r0.getString(R.l.dPs) + r0.kRh.getTitle();
                l.a(r0.kIK, r0.kRi, r0.kRo.kQy, 2);
                l.bZ(r0.kRj, r0.kRi);
                h.bu(this.kRr.kQM, this.kRr.kQM.getResources().getString(R.l.dOo));
            } else if (this.pa == 4) {
                r0 = this.kRr;
                if (TextUtils.isEmpty(r0.kIK.atH())) {
                    r0.kIK.vT(q.FS());
                }
                r0.kIK.atD().wLJ = r0.getString(R.l.dOU) + r0.kRh.getTitle();
                l.a(r0.kIK, r0.kRi, r0.kRo.kQy, 23);
                l.bZ(r0.kRj, r0.kRi);
                g.pQN.h(11582, new Object[]{"OpeRecommendCard", Integer.valueOf(this.kRr.kRo.kFm), Integer.valueOf(this.kRr.kIK.atB().kJO), this.kRr.kIK.atG(), this.kRr.kIK.atF(), this.kRr.kRi});
                h.bu(this.kRr.kQM, this.kRr.kQM.getResources().getString(R.l.dOo));
            }
        }
    }
}
