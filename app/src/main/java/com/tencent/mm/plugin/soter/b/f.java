package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e$b;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements e, com.tencent.mm.network.k {
    private com.tencent.mm.ae.e gJT;
    private q hnp;
    private b<e$b> mzK = null;

    public final /* synthetic */ void bq(Object obj) {
        a aVar = (a) obj;
        this.hnp = new b();
        c$a com_tencent_mm_plugin_soter_b_c_a = (c$a) this.hnp.Kb();
        com_tencent_mm_plugin_soter_b_c_a.rSd.wRx = aVar.AcR;
        com_tencent_mm_plugin_soter_b_c_a.rSd.wRy = aVar.AcQ;
    }

    protected final int Bh() {
        return 3;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    public final int getType() {
        return 627;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
            if (this.mzK != null) {
                this.mzK.cx(new e$b(true));
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa failed");
        if (this.mzK != null) {
            this.mzK.cx(new e$b(false));
        }
    }

    public final void execute() {
        x.v("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo NetSceneUploadSoterASKRsa doScene");
        g.CG().a(this, 0);
    }

    public final void a(b<e$b> bVar) {
        this.mzK = bVar;
    }
}
