package com.tencent.mm.modelfriend;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.protocal.c.bmg;
import com.tencent.mm.protocal.p.a;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.as;
import java.util.Iterator;

public final class u extends k implements com.tencent.mm.network.k {
    private e gJT;
    private int hmS;
    public q hnp;

    private u(int i, String str, String str2, String str3) {
        this.hmS = 2;
        this.hnp = new a();
        a aVar = (a) this.hnp.Kb();
        aVar.vBC.vJL = i;
        aVar.vBC.vLN = str;
        aVar.vBC.lOo = w.cfi();
        aVar.vBC.vMp = bh.VB(str2);
        aVar.vBC.vZH = str3;
        aVar.vBC.vJz = ar.CB();
        aVar.vBC.vZI = com.tencent.mm.compatible.d.q.getSimCountryIso();
        aVar.vBC.vZJ = 1;
    }

    public u(String str, String str2, String str3) {
        this(2, str, str2, str3);
    }

    public u(String str, String str2) {
        this(1, str, str2, "");
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        b bVar = (b) qVar.Hp();
        if (i2 == 4 && i3 == -301) {
            as.a(true, bVar.vBD.vMr, bVar.vBD.vMs, bVar.vBD.vMq);
            this.hmS--;
            if (this.hmS <= 0) {
                this.gJT.a(3, -1, "", this);
            } else {
                a(this.hmA, this.gJT);
            }
        } else if (i2 == 0 && i3 == 0) {
            as.a(false, bVar.vBD.vMr, bVar.vBD.vMs, bVar.vBD.vMq);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.c.b.jd(Og());
            }
            this.gJT.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.gJT.a(i2, i3, str, this);
        }
    }

    protected final int Bh() {
        return 5;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    public final int Og() {
        bin com_tencent_mm_protocal_c_bin = ((b) this.hnp.Hp()).vBD.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 1) {
                    return bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 0);
                }
            }
        }
        return 0;
    }

    public final int getType() {
        return 481;
    }
}
