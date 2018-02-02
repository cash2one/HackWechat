package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.protocal.c.lx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g;

public final class e extends g {
    private final String TAG = "MicroMsg.NetSceneBeforeTransfer";
    public lx pKl;

    public e(String str) {
        a aVar = new a();
        aVar.hmj = new lw();
        aVar.hmk = new lx();
        aVar.hmi = 2783;
        aVar.uri = "/cgi-bin/mmpay-bin/beforetransfer";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        lw lwVar = (lw) this.gJQ.hmg.hmo;
        lwVar.vHu = str;
        if (!f.ccT()) {
            lwVar.vUz = f.ccU();
        }
        x.d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", new Object[]{str});
    }

    protected final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.pKl = (lx) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.pKl.liH), this.pKl.liI});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final void f(q qVar) {
        lx lxVar = (lx) ((b) qVar).hmh.hmo;
        this.zHp = lxVar.liH;
        this.zHq = lxVar.liI;
    }

    public final int getType() {
        return 2783;
    }
}
