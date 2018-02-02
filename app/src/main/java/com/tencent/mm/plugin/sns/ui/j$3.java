package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.al.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements c {
    final /* synthetic */ j rrK;

    j$3(j jVar) {
        this.rrK = jVar;
    }

    public final void LK(String str) {
        m mVar = (m) this.rrK.rrw.getTag();
        x.d("MicroMsg.BaseTimeLine", "onCommentSend click");
        if (str == null || str.trim().equals("")) {
            x.e("MicroMsg.BaseTimeLine", "onCommentSend tosendText is null or empty");
            return;
        }
        bjk bAQ = this.rrK.rrw.bAQ();
        bjv n = ai.n(mVar);
        int i = (bAQ.wMw == 0 && bAQ.wMz == 0) ? 708 : 709;
        b iu = b.iu(i);
        if (iu.opType == 708) {
            iu.mB(i.g(mVar)).ix(mVar.field_type).bU(mVar.xl(32)).mB(mVar.byA()).mB(mVar.field_userName).ix(n.wMY).ix(n.wNb);
        } else {
            String str2;
            b mB = iu.mB(i.g(mVar)).ix(mVar.field_type).bU(mVar.xl(32)).mB(mVar.byA()).mB(bAQ.vIy);
            if (bAQ.wMw == 0) {
                str2 = bAQ.wMz;
            } else {
                str2 = bAQ.wMw;
            }
            mB.mB(str2).ix(n.wMY).ix(n.wNb);
        }
        iu.Sx();
        if (this.rrK.rrt != null) {
            this.rrK.rrt.qWT.u(mVar);
        }
        if (mVar.xl(32) && this.rrK.rrw.rBe == 1) {
            i = 1;
        } else {
            i = 0;
        }
        a.a(mVar, mVar.xl(32) ? 8 : 2, str, this.rrK.rrw.bAQ(), i);
        this.rrK.qZU.E(this.rrK.rrx.rMT);
        this.rrK.bze();
        if (bh.ov(j.b(this.rrK))) {
            for (l lVar : j.rrC) {
                if (j.b(this.rrK).equals(lVar.aAM)) {
                    x.d("MicroMsg.BaseTimeLine", "remove ct");
                    j.rrC.remove(lVar);
                    return;
                }
            }
        }
    }
}
