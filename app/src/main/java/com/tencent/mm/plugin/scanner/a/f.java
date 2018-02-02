package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hw;
import com.tencent.mm.protocal.c.hx;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    public int fqb;
    public int fqc;
    private b gJQ;
    private e gJT;
    public boolean pSP = false;

    public f(int i, String str, int i2, int i3) {
        a aVar = new a();
        aVar.hmj = new hw();
        aVar.hmk = new hx();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
        aVar.hmi = 1061;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        hw hwVar = (hw) this.gJQ.hmg.hmo;
        hwVar.ktN = i;
        hwVar.vNS = str;
        hwVar.rYW = 1;
        this.fqb = i2;
        this.fqc = i3;
        x.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, type: %s, barcode: %s, scene: %s, codetype: %s, codeVersion: %s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        hw hwVar = (hw) ((b) qVar).hmg.hmo;
        if (hwVar.ktN >= 0 && hwVar.vNS != null && hwVar.vNS.length() > 0) {
            return k.b.hmP;
        }
        x.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + hwVar.ktN + ", Barcode = %s" + hwVar.vNS);
        return k.b.hmQ;
    }

    public final hx boD() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (hx) this.gJQ.hmh.hmo;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1061;
    }
}
