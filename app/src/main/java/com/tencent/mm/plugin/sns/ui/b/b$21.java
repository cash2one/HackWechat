package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;

class b$21 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$21(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        this.rPY.cF(view);
        if (view.getTag() != null && (view.getTag() instanceof b)) {
            b bVar = (b) view.getTag();
            m Lm = ae.bvv().Lm(bVar.frH);
            if (Lm != null && Lm.xl(32)) {
                bVar.qQK = System.currentTimeMillis();
                k cVar = new c(Lm.byz(), 20, this.rPY.scene == 0 ? 1 : 2, "", Lm.byD(), Lm.bxW());
                g.Dk();
                g.Di().gPJ.a(cVar, 0);
            }
        }
    }
}
