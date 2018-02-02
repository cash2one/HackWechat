package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bep;
import com.tencent.mm.protocal.c.beq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ae.b gJQ;
    private e gOB;
    private long lxP = 0;
    private int lyE;
    private byte[] lyP = null;
    private String lyR;
    int tll = -1;
    boolean tlm = true;

    public b(int i, String str, byte[] bArr, int i2, long j) {
        a aVar = new a();
        aVar.hmj = new bep();
        aVar.hmk = new beq();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
        aVar.hmi = 234;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.lyE = i;
        this.lyR = str;
        this.lyP = bArr;
        this.tll = i2;
        this.lxP = j;
    }

    public final int getType() {
        return 234;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        bep com_tencent_mm_protocal_c_bep = (bep) this.gJQ.hmg.hmo;
        if (bh.bw(this.lyP)) {
            com_tencent_mm_protocal_c_bep.wkp = new bdn();
            this.tlm = true;
        } else {
            com_tencent_mm_protocal_c_bep.wkp = n.N(this.lyP);
            this.tlm = false;
            com_tencent_mm_protocal_c_bep.wks = this.lxP;
        }
        x.d("MicroMsg.emoji.NetSceneSearchEmotion", com_tencent_mm_protocal_c_bep.wkp == null ? "Buf is NULL" : com_tencent_mm_protocal_c_bep.wkp.toString());
        com_tencent_mm_protocal_c_bep.vLh = this.lyE;
        com_tencent_mm_protocal_c_bep.wkq = this.lyR;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gOB.a(i2, i3, str, this);
    }

    public final beq bPc() {
        return this.gJQ == null ? null : (beq) this.gJQ.hmh.hmo;
    }
}
