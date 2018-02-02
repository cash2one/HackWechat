package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.memory.c;
import com.tencent.mm.memory.e.a;
import com.tencent.mm.sdk.platformtools.ac;

class ae$8 extends a {
    final /* synthetic */ ae qWL;
    final int qWM = 120;

    ae$8(ae aeVar, c cVar) {
        this.qWL = aeVar;
        cVar.getClass();
        super(cVar);
    }

    public final /* synthetic */ Comparable Ev() {
        return Integer.valueOf(com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 120) * com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 120));
    }

    public final long Ew() {
        return 10485760;
    }

    public final int Ex() {
        return -1;
    }
}
