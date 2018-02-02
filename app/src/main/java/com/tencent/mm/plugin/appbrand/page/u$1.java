package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.plugin.appbrand.page.u.b;

class u$1 extends x {
    final /* synthetic */ u jFr;

    u$1(u uVar) {
        this.jFr = uVar;
    }

    public final void agt() {
        u uVar = this.jFr;
        b lm = uVar.lm(uVar.jFq);
        float[] fArr = uVar.jFn;
        if (!(lm == null || lm.jFA == null || fArr == null)) {
            View view = (View) lm.jFA.get();
            if (view != null) {
                if (uVar.jFq != uVar.jFm) {
                    b lm2 = uVar.lm(uVar.jFm);
                    if (!(lm2 == null || lm2.jFA == null)) {
                        View view2 = (View) lm2.jFA.get();
                        if (view2 != null) {
                            uVar.b(uVar.jFm, fArr, view2.getVisibility(), Boolean.valueOf(lm.jFC));
                        }
                    }
                }
                int i = uVar.jFq;
                uVar.jFm = -1;
                uVar.jFq = -1;
                uVar.b(i, fArr, view.getVisibility(), Boolean.valueOf(lm.jFC));
            }
        }
        if (this.jFr.jFp != null) {
            this.jFr.jFp.agt();
            this.jFr.jFp = null;
        }
    }
}
