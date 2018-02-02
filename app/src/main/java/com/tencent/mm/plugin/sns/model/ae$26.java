package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.pm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ae$26 extends c<pm> {
    final /* synthetic */ ae qWL;

    ae$26(ae aeVar) {
        this.qWL = aeVar;
        this.xen = pm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ai.bvQ();
        ae.bvv().gJP.fx("SnsInfo", "delete from SnsInfo");
        ae.bvz().Ln("@__weixintimtline");
        return false;
    }
}
