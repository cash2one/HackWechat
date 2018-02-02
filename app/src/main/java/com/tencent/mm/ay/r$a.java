package com.tencent.mm.ay;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;
import java.util.List;

class r$a extends ak {
    final /* synthetic */ r hJg;

    public r$a(r rVar, List<b> list, LinkedList<Integer> linkedList) {
        this.hJg = rVar;
        super(g.Dm().oAt.getLooper(), new 1(rVar, list, linkedList), true);
    }
}
