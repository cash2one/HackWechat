package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.x;

class b$22 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$22(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.TimelineClickListener", "unlike click");
        b bVar = (b) view.getTag();
        m Lm = ae.bvv().Lm(bVar.frH);
        if (Lm != null) {
            int i;
            if (Lm.xl(32)) {
                Object obj;
                a bxT = Lm.bxT();
                if (bxT == null) {
                    obj = "";
                } else {
                    String str = bxT.iTh;
                }
                ((c) g.h(c.class)).a(11855, Lm.byC(), new Object[]{Integer.valueOf(3), obj, Integer.valueOf(Lm.byC())});
            }
            if (bVar.qQI.rMn.ref.bws().size() > 0) {
                i = 1;
            } else {
                i = 0;
            }
            a.b.a aVar;
            k qVar;
            if (i != 0) {
                this.rPY.bzh();
                aVar = new a.b.a();
                aVar.res = a.b.a.reo;
                aVar.qQK = bVar.qQK;
                aVar.reu = 0;
                qVar = new q(Lm.field_snsId, 8, aVar);
                g.Dk();
                g.Di().gPJ.a(qVar, 0);
            } else if (!bVar.qQI.rMn.rej) {
                this.rPY.cG(view);
                aVar = new a.b.a();
                aVar.qQK = bVar.qQK;
                aVar.reu = System.currentTimeMillis();
                qVar = new q(Lm.field_snsId, 8, aVar);
                g.Dk();
                g.Di().gPJ.a(qVar, 0);
            }
        }
    }
}
