package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public abstract class n<REQ, RESP> extends k implements com.tencent.mm.network.k {
    protected b gJQ;
    e gJT;
    private e mEQ;
    protected com.tencent.mm.plugin.voip.model.e skx = f.bGC();

    public abstract e bHJ();

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        dP(i2, i3);
        if (this.mEQ != null) {
            this.mEQ.a(i2, i3, str, this);
        }
        if (this.gJT != null) {
            ag.y(new 1(this, i2, i3, str));
        }
    }

    public int bHK() {
        return 0;
    }

    public void dP(int i, int i2) {
    }

    public final void bHM() {
        x.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        ar.CG().a(this, 0);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int bHK = bHK();
        if (bHK != 0) {
            return bHK;
        }
        this.mEQ = eVar2;
        this.gJT = bHJ();
        return a(eVar, this.gJQ, this);
    }

    public final <RESP> RESP bHN() {
        return this.gJQ.hmh.hmo;
    }

    public final <REQ> REQ bHO() {
        return this.gJQ.hmg.hmo;
    }
}
