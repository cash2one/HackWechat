package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nk;
import com.tencent.mm.protocal.q.a;

public final class o extends n {
    public static void aqV() {
        g.Di().gPJ.a(new o(), 0);
    }

    protected final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneEncryptCheckResUpdate";
    }

    protected final nk i(q qVar) {
        return ((a) qVar).vht.vBH;
    }

    public final int getType() {
        return 722;
    }

    protected final q bZv() {
        q aVar = new a();
        a aVar2 = aVar.vhs;
        aVar2.eE(0);
        aVar2.vBE.wbf.wbd.vWp.addAll(this.vho);
        return aVar;
    }
}
