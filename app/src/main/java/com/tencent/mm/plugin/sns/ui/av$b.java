package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.z.ak.b.a;

public class av$b implements a {
    int mPosition;
    x rHG = null;

    public av$b(x xVar, int i) {
        this.rHG = xVar;
        this.mPosition = i;
    }

    public final void v(String str, boolean z) {
        if (z) {
            g.Dk();
            if (g.Dh().Cy()) {
                ae.aNT().post(new Runnable(this) {
                    final /* synthetic */ av$b rHH;

                    {
                        this.rHH = r1;
                    }

                    public final void run() {
                        if (this.rHH.rHG.bzu() != null) {
                            ((aw) this.rHH.rHG.bzu()).Hn(this.rHH.mPosition);
                        }
                        this.rHH.rHG.notifyDataSetChanged();
                    }
                });
            }
        }
    }
}
