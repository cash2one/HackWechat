package com.tencent.mm.an;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au;
import com.tencent.mm.protocal.c.abf;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements a {
    final /* synthetic */ c hyF;

    c$3(c cVar) {
        this.hyF = cVar;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (kVar.getType() == au.CTRL_BYTE) {
            this.hyF.hkG = false;
            if (i == 0 && i2 == 0) {
                if (!this.hyF.hyy.isEmpty() && this.hyF.hyD.cfK()) {
                    this.hyF.hyD.J(500, 500);
                }
                if (bVar != null) {
                    c.a aVar = new c.a(this.hyF);
                    aVar.errType = i;
                    aVar.errCode = i2;
                    aVar.fnL = str;
                    aVar.hyL = (abf) bVar.hmh.hmo;
                    this.hyF.hyz.add(aVar);
                }
                if (!this.hyF.hyz.isEmpty() && this.hyF.hyE.cfK()) {
                    this.hyF.hyE.J(50, 50);
                }
            } else {
                x.e("MicroMsg.GetContactService", "tryStartNetscene onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
                this.hyF.hyD.J(10000, 10000);
            }
        }
        return 0;
    }
}
