package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asm;
import com.tencent.mm.protocal.c.asn;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    private b gJQ;
    private e gJT;
    public String iIj;
    public String pHd;
    public asn pHl;

    public j(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new asm();
        aVar.hmk = new asn();
        aVar.hmi = 1590;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        asm com_tencent_mm_protocal_c_asm = (asm) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_asm.pHK = str;
        com_tencent_mm_protocal_c_asm.pHN = str2;
        this.pHd = str;
        this.iIj = str2;
    }

    public final int getType() {
        return 1590;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pHl = (asn) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.pHl.liH), this.pHl.liI});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        asn com_tencent_mm_protocal_c_asn = (asn) ((b) qVar).hmh.hmo;
        this.zHp = com_tencent_mm_protocal_c_asn.liH;
        this.zHq = com_tencent_mm_protocal_c_asn.liI;
    }
}
