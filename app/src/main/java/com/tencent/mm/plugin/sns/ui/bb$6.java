package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.al$a;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.x;

class bb$6 implements SnsHeader$a {
    final /* synthetic */ bb rLm;

    bb$6(bb bbVar) {
        this.rLm = bbVar;
    }

    public final boolean eV(long j) {
        if (bb.b(this.rLm) || bb.c(this.rLm).getType() == 1) {
            this.rLm.xQ(2);
        } else {
            m mVar = new m();
            mVar.field_snsId = j;
            mVar.field_userName = bb.d(this.rLm);
            bnp SA = e.SA();
            SA.ksU = bb.d(this.rLm);
            mVar.c(SA);
            m Kl = ai.Kl(bb.d(this.rLm));
            x.d("MicroMsg.SnsActivity", "friend like %s", new Object[]{bb.d(this.rLm)});
            if (Kl == null) {
                al$a.a(mVar, 1, "");
            } else if (Kl.byp()) {
                al$a.a(mVar, 1, "");
            } else {
                al$a.a(mVar, 5, "");
            }
            k Lq = ae.bvz().Lq(bb.d(this.rLm));
            Lq.field_local_flag |= 2;
            ae.bvz().c(Lq);
            bb.e(this.rLm);
        }
        return false;
    }

    public final boolean bAV() {
        bb.c(this.rLm).bBO();
        return false;
    }
}
