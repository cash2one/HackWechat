package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.k;
import com.tencent.mm.ae.k.b;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.as;
import com.tencent.mm.z.aw;
import com.tencent.mm.z.aw.a;

public final class e extends k implements com.tencent.mm.network.k {
    com.tencent.mm.ae.e gJT;
    private int hmS = 2;
    private final q hnp = new b();
    String lcJ = "";

    public e(String str) {
        a aVar = (a) this.hnp.Kb();
        aVar.hgo.ksU = str;
        aVar.hgo.wpc = 1;
        x.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", new Object[]{Integer.valueOf(1), str});
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    protected final int Bh() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final void a(k.a aVar) {
    }

    public final int getType() {
        return 618;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        aw.b bVar = (aw.b) qVar.Hp();
        this.lcJ = bVar.hgp.wpd;
        x.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " mTicket: " + this.lcJ);
        if (i2 == 4 && i3 == -301) {
            as.a(true, bVar.hgp.vMr, bVar.hgp.vMs, bVar.hgp.vMq);
            this.hmS--;
            if (this.hmS <= 0) {
                x.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "reach redirect limit, invoke callback");
                this.gJT.a(3, -1, "", this);
                return;
            }
            x.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "redirect IDC");
            a(this.hmA, this.gJT);
        } else if (i2 == 4 && i3 == -102) {
            x.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.Kb().vBn.ver)});
            ar.Dm().F(new 1(this, r0));
        } else if (i2 == 0 || i3 == 0) {
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
