package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdv;
import com.tencent.mm.protocal.c.bdw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g;

public final class k extends g {
    public bdw liF;

    public k(String str, int i) {
        a aVar = new a();
        aVar.hmj = new bdv();
        aVar.hmk = new bdw();
        aVar.hmi = 1800;
        aVar.uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bdv com_tencent_mm_protocal_c_bdv = (bdv) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bdv.wJK = str;
        com_tencent_mm_protocal_c_bdv.scene = i;
        x.i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", new Object[]{str, Integer.valueOf(i)});
    }

    protected final void b(int i, int i2, String str, q qVar) {
        this.liF = (bdw) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.liF.liH), this.liF.liI});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bdw com_tencent_mm_protocal_c_bdw = (bdw) ((b) qVar).hmh.hmo;
        this.zHp = com_tencent_mm_protocal_c_bdw.liH;
        this.zHq = com_tencent_mm_protocal_c_bdw.liI;
    }

    public final int getType() {
        return 1800;
    }
}
