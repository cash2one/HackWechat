package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bex;
import com.tencent.mm.protocal.c.bey;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private String fod;
    private e gJT;
    private b kEK;
    private long kEM;
    public bey kEN;
    private int scene;

    public i(String str, long j, int i) {
        this.fod = str;
        this.kEM = j;
        this.scene = i;
        x.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0 && this.kEK != null) {
            this.kEN = (bey) this.kEK.hmh.hmo;
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1070;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
        this.gJT = eVar2;
        if (bh.ov(this.fod)) {
            x.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
            return -1;
        }
        a aVar = new a();
        aVar.hmi = 1070;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
        aVar.hmj = new bex();
        aVar.hmk = new bey();
        aVar.hml = 0;
        aVar.hmm = 0;
        this.kEK = aVar.JZ();
        bex com_tencent_mm_protocal_c_bex = (bex) this.kEK.hmg.hmo;
        com_tencent_mm_protocal_c_bex.wkq = this.fod;
        com_tencent_mm_protocal_c_bex.wwI = c.Je();
        com_tencent_mm_protocal_c_bex.vPp = this.kEM;
        com_tencent_mm_protocal_c_bex.wKa = this.scene;
        x.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[]{Long.valueOf(this.kEM)});
        return a(eVar, this.kEK, this);
    }
}
