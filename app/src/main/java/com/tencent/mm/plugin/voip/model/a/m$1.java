package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.protocal.c.bvg;

class m$1 implements e {
    final /* synthetic */ m snV;

    m$1(m mVar) {
        this.snV = mVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        a.et("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
        try {
            if (((bvg) this.snV.bHN()).wbh != this.snV.skx.ske.nDx) {
                a.es("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
                return;
            }
        } catch (Exception e) {
        }
        if (i != 0) {
            a.es("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
            this.snV.skx.ske.spH.skR = 11;
            this.snV.skx.ske.spH.skT = i2;
            this.snV.skx.ske.spH.skS = i2;
            this.snV.skx.ske.spH.slj = 3;
            if (i == 1) {
                this.snV.skx.ske.spH.sld = 8;
            } else {
                this.snV.skx.ske.spH.sld = 99;
            }
            this.snV.skx.p(1, -9004, "");
            return;
        }
        this.snV.skx.skh.o(kVar);
    }
}
