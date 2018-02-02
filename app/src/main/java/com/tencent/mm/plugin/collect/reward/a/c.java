package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdy;
import com.tencent.mm.protocal.c.bdz;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g;

public final class c extends g {
    public bdz lju;

    public c(String str, int i) {
        a aVar = new a();
        aVar.hmj = new bdy();
        aVar.hmk = new bdz();
        aVar.uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bdy com_tencent_mm_protocal_c_bdy = (bdy) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bdy.wJK = str;
        com_tencent_mm_protocal_c_bdy.scene = i;
        x.i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", str, Integer.valueOf(i));
    }

    protected final void b(int i, int i2, String str, q qVar) {
        this.lju = (bdz) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", Integer.valueOf(this.lju.liH), this.lju.liI);
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bdz com_tencent_mm_protocal_c_bdz = (bdz) ((b) qVar).hmh.hmo;
        this.zHp = com_tencent_mm_protocal_c_bdz.liH;
        this.zHq = com_tencent_mm_protocal_c_bdz.liI;
    }

    public final int getType() {
        return 2811;
    }

    public final boolean ayS() {
        return true;
    }
}
