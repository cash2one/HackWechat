package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajn;
import com.tencent.mm.protocal.c.ajo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g;

public final class u extends g {
    public ajo odc;

    public u(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hmj = new ajn();
        aVar.hmk = new ajo();
        aVar.hmi = 2929;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/businesscallbackwxhb";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ajn com_tencent_mm_protocal_c_ajn = (ajn) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ajn.nZa = str;
        com_tencent_mm_protocal_c_ajn.lie = str2;
        com_tencent_mm_protocal_c_ajn.odz = str3;
        x.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "sendId: %s, %s", new Object[]{str, str3});
    }

    protected final void b(int i, int i2, String str, q qVar) {
        this.odc = (ajo) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneLuckyMoneyBusinessCallback", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.odc.liH), this.odc.liI});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        ajo com_tencent_mm_protocal_c_ajo = (ajo) ((b) qVar).hmh.hmo;
        this.zHp = com_tencent_mm_protocal_c_ajo.liH;
        this.zHq = com_tencent_mm_protocal_c_ajo.liI;
    }

    public final int getType() {
        return 2929;
    }
}
