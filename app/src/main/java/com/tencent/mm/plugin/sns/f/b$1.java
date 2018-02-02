package com.tencent.mm.plugin.sns.f;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements OnClickListener {
    final /* synthetic */ int qZE;
    final /* synthetic */ b qZF;
    final /* synthetic */ View qZG;
    final /* synthetic */ b qZH;
    final /* synthetic */ View zS;

    b$1(b bVar, int i, b bVar2, View view, View view2) {
        this.qZH = bVar;
        this.qZE = i;
        this.qZF = bVar2;
        this.qZG = view;
        this.zS = view2;
    }

    public final void onClick(View view) {
        b bVar = this.qZH;
        int i = this.qZE;
        b bVar2 = this.qZF;
        View view2 = this.qZG;
        AbsoluteLayout absoluteLayout = this.qZH.qZq;
        x.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + i + " " + bVar2.qQJ);
        b.b bVar3 = (b.b) bVar.qZz.get(Long.valueOf(bVar2.qQJ));
        if (bVar3 != null) {
            bVar3.KN("1:" + (i == 4 ? 3 : i) + ":" + bVar.mContext.getString(bVar.qZu[i - 1]));
        }
        if (i == 1) {
            m Lm = ae.bvv().Lm(bVar2.frH);
            if (Lm != null) {
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
                ae.bvy().delete(Lm.field_snsId);
                ae.bvA().eM(Lm.field_snsId);
                k qVar = new q(Lm.field_snsId, 8);
                g.Dk();
                g.Di().gPJ.a(qVar, 0);
                bVar.a(bVar3);
                bVar.bwm();
            }
        } else if (i == 2) {
            bVar.a(view2, absoluteLayout, bVar2);
        } else if (i == 3) {
            if (!t.ez(bVar2.qQJ)) {
                t.ex(bVar2.qQJ);
            }
            bVar.a(bVar3);
            bVar.bwm();
        } else if (i == 4) {
            if (t.ez(bVar2.qQJ)) {
                t.ey(bVar2.qQJ);
            }
            bVar.a(bVar3);
            bVar.bwm();
        }
    }
}
