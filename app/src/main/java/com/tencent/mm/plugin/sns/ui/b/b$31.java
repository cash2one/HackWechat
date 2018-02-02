package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.a$c;
import com.tencent.mm.sdk.platformtools.x;

class b$31 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$31(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof a$c) {
            m Lm = ae.bvv().Lm(((a$c) view.getTag()).frH);
            if (Lm != null && Lm.xl(32)) {
                x.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                k cVar = new c(Lm.byz(), 24, this.rPY.scene == 0 ? 1 : 2, "", Lm.byD(), Lm.bxW());
                g.Dk();
                g.Di().gPJ.a(cVar, 0);
                this.rPY.cC(view);
            }
        }
    }
}
