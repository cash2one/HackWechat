package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.nj;
import com.tencent.mm.protocal.c.nk;

public final class m extends n {
    protected final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
    }

    protected final nk i(q qVar) {
        return (nk) ((b) qVar).hmh.hmo;
    }

    public m(int i) {
        bde com_tencent_mm_protocal_c_bde = new bde();
        com_tencent_mm_protocal_c_bde.ktN = i;
        this.vho.clear();
        this.vho.add(com_tencent_mm_protocal_c_bde);
    }

    protected final q bZv() {
        a aVar = new a();
        com.tencent.mm.bq.a njVar = new nj();
        njVar.vWp.addAll(this.vho);
        aVar.hmj = njVar;
        aVar.hmk = new nk();
        aVar.uri = "/cgi-bin/micromsg-bin/checkresupdate";
        aVar.hmi = 721;
        aVar.hml = 0;
        aVar.hmm = 0;
        return aVar.JZ();
    }

    public final int getType() {
        return 721;
    }
}
