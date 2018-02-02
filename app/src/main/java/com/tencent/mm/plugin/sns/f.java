package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.ht;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends c<ht> {
    private m qyg;
    private String qyj;
    private bnp qyk;

    public f() {
        this.xen = ht.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ht htVar = (ht) bVar;
        if (htVar instanceof ht) {
            this.qyj = htVar.fyb.frH;
            this.qyg = ae.bvv().Lm(this.qyj);
            this.qyk = this.qyg.bxV();
            if (this.qyk != null) {
                htVar.fyc.fyd = this.qyk;
                return true;
            }
        }
        x.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        return false;
    }
}
