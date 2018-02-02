package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.av.b;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.bnp;

class at$6 implements OnClickListener {
    final /* synthetic */ at rFj;

    at$6(at atVar) {
        this.rFj = atVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof bnp) {
            bnp com_tencent_mm_protocal_c_bnp = (bnp) view.getTag();
            if (at.Mb(com_tencent_mm_protocal_c_bnp.nGJ)) {
                g.pQN.k(10231, "1");
                b.Qo();
            } else {
                g.pQN.k(10090, "1,0");
                if (!(a.aW(at.a(this.rFj)) || a.aU(at.a(this.rFj)))) {
                    asv a = ((com.tencent.mm.av.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.av.a.a.class)).a(ae.FC(), com_tencent_mm_protocal_c_bnp, 8);
                    a.wAy = at.b(this.rFj);
                    b.b(a);
                }
            }
            this.rFj.notifyDataSetChanged();
        }
    }
}
