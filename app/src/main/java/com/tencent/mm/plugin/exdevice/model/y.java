package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpi;
import com.tencent.mm.protocal.c.bpj;

public final class y extends k implements com.tencent.mm.network.k {
    private String ffq;
    private String frg;
    private b gJQ;
    private e gJT;
    public String gfN;
    private int lNh = 0;

    public y(String str, String str2, String str3) {
        this.gfN = str3;
        this.ffq = str;
        this.frg = str2;
    }

    public final int getType() {
        return 1263;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new bpi();
        aVar.hmk = new bpj();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
        aVar.hmi = 1263;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bpi com_tencent_mm_protocal_c_bpi = (bpi) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bpi.gfN = this.gfN;
        com_tencent_mm_protocal_c_bpi.oWG = this.ffq;
        com_tencent_mm_protocal_c_bpi.devicetype = this.frg;
        com_tencent_mm_protocal_c_bpi.wRw = this.lNh;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
