package com.tencent.mm.r;

import com.tencent.mm.r.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class c$1 implements a {
    final /* synthetic */ c gJM;

    c$1(c cVar) {
        this.gJM = cVar;
    }

    public final void z(List<d> list) {
        this.gJM.gJJ = false;
        if (list != null) {
            x.i("MicroMsg.FunctionMsgFetcher", "onFetchFinish, fetchSuccessList.size: %s", new Object[]{list});
            c.b(list, false);
        }
        this.gJM.Bf();
    }
}
