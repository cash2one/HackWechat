package com.tencent.mm.plugin.exdevice.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a<RequestType extends com.tencent.mm.bq.a, ResponseType extends com.tencent.mm.bq.a> extends k implements com.tencent.mm.network.k {
    private e gOB;
    protected b lJU;

    public abstract RequestType aDC();

    public abstract ResponseType aDD();

    public abstract String getUri();

    public void g(RequestType requestType) {
    }

    public final ResponseType apH() {
        if (this.lJU == null || this.lJU.hmh.hmo == null) {
            return null;
        }
        return this.lJU.hmh.hmo;
    }

    public void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        if (this.lJU == null) {
            com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
            aVar.hmi = getType();
            aVar.uri = getUri();
            aVar.hmj = aDC();
            aVar.hmk = aDD();
            aVar.hml = 0;
            aVar.hmm = 0;
            this.lJU = aVar.JZ();
            g(this.lJU.hmg.hmo);
        }
        return a(eVar, this.lJU, this);
    }
}
