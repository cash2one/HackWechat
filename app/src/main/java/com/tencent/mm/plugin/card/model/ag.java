package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axp;
import com.tencent.mm.protocal.c.axq;
import com.tencent.mm.sdk.platformtools.x;

public final class ag extends k implements com.tencent.mm.network.k {
    public String content;
    public String fFh;
    private final b gJQ;
    private e gJT;
    public String iMN;
    public String kMf;
    public String kMg;
    public boolean kMh;
    public String kMi;
    public String kMj;
    public String kMk;
    public String kMl;
    public int status;

    public ag(int i, String str, String str2) {
        a aVar = new a();
        aVar.hmj = new axp();
        aVar.hmk = new axq();
        aVar.uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
        aVar.hmi = 1171;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        axp com_tencent_mm_protocal_c_axp = (axp) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_axp.vEM = i;
        com_tencent_mm_protocal_c_axp.vEN = str;
        com_tencent_mm_protocal_c_axp.vEO = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            axq com_tencent_mm_protocal_c_axq = (axq) this.gJQ.hmh.hmo;
            this.fFh = com_tencent_mm_protocal_c_axq.vER;
            this.kMf = com_tencent_mm_protocal_c_axq.vES;
            this.status = com_tencent_mm_protocal_c_axq.status;
            this.content = com_tencent_mm_protocal_c_axq.content;
            this.kMg = com_tencent_mm_protocal_c_axq.kLA;
            this.iMN = com_tencent_mm_protocal_c_axq.wEG;
            this.kMh = com_tencent_mm_protocal_c_axq.kMh;
            this.kMi = com_tencent_mm_protocal_c_axq.wEH;
            this.kMj = com_tencent_mm_protocal_c_axq.wEI;
            this.kMk = com_tencent_mm_protocal_c_axq.wEJ;
            this.kMl = com_tencent_mm_protocal_c_axq.wEK;
            x.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[]{this.fFh, this.kMf, Integer.valueOf(this.status), this.content, this.kMg, this.iMN, Boolean.valueOf(this.kMh)});
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1171;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
