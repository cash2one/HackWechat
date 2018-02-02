package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcw;
import com.tencent.mm.protocal.c.bcx;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    private b gJQ;
    private e gJT;
    public bcx pHp;

    public n(String str, String str2, String str3, int i, int i2, String str4, int i3, int i4, String str5) {
        a aVar = new a();
        aVar.hmj = new bcw();
        aVar.hmk = new bcx();
        aVar.hmi = 1380;
        aVar.uri = "/cgi-bin/mmpay-bin/request_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bcw com_tencent_mm_protocal_c_bcw = (bcw) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bcw.pHK = str;
        com_tencent_mm_protocal_c_bcw.pHL = str2;
        com_tencent_mm_protocal_c_bcw.oZz = str3;
        com_tencent_mm_protocal_c_bcw.pHx = i;
        com_tencent_mm_protocal_c_bcw.wIW = i2;
        com_tencent_mm_protocal_c_bcw.wIX = str4;
        com_tencent_mm_protocal_c_bcw.wIY = i3;
        com_tencent_mm_protocal_c_bcw.wIZ = i4;
        com_tencent_mm_protocal_c_bcw.vIK = str5;
    }

    public final int getType() {
        return 1380;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pHp = (bcx) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.pHp.liH), this.pHp.liI);
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        bcx com_tencent_mm_protocal_c_bcx = (bcx) ((b) qVar).hmh.hmo;
        this.zHp = com_tencent_mm_protocal_c_bcx.liH;
        this.zHq = com_tencent_mm_protocal_c_bcx.liI;
    }

    public final boolean ayS() {
        if (this.pHp.wJa == null || this.pHp.wJa.fDt != 1) {
            return true;
        }
        return false;
    }
}
