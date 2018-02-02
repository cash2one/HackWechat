package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.hy;
import com.tencent.mm.protocal.c.hz;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;
    private int hlp;
    private int offset;
    private byte[] pSK;
    private int pSL = 1;
    private int pSO;

    public g(byte[] bArr, int i, int i2) {
        this.pSK = bArr;
        this.pSL = 1;
        this.hlp = i;
        this.offset = 0;
        this.pSO = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new hy();
        aVar.hmk = new hz();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanimg";
        aVar.hmi = 1062;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        hy hyVar = (hy) this.gJQ.hmg.hmo;
        hyVar.vNT = ((int) bh.Wp()) & Integer.MAX_VALUE;
        hyVar.vNU = new bdn().bj(this.pSK);
        hyVar.vNV = this.hlp;
        hyVar.vNW = this.offset;
        if (this.offset + this.pSK.length < this.hlp) {
            hyVar.vLj = 0;
        } else {
            hyVar.vLj = 1;
        }
        hyVar.vNX = this.pSL;
        hyVar.vNY = this.pSO;
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        hy hyVar = (hy) ((b) qVar).hmg.hmo;
        if (hyVar.vNT > 0 && hyVar.vNX >= 0 && hyVar.vNU != null && hyVar.vNU.wJB > 0 && hyVar.vNV > 0 && hyVar.vNW >= 0 && hyVar.vNW + hyVar.vNU.wJB <= hyVar.vNV) {
            return k.b.hmP;
        }
        x.e("MicroMsg.scanner.NetSceneScanImage", "ERR: Security Check Failed, imageType = %s, totalLen = %s, offset = %s", new Object[]{Integer.valueOf(hyVar.vNX), Integer.valueOf(hyVar.vNV), Integer.valueOf(hyVar.vNW)});
        if (hyVar.vNU != null) {
            x.e("MicroMsg.scanner.NetSceneScanImage", "buffer length = %s", new Object[]{Integer.valueOf(hyVar.vNU.wJB)});
        }
        return k.b.hmQ;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneScanImage", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1062;
    }
}
