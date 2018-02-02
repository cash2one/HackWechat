package com.tencent.mm.modelsimple;

import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class o$1 implements Runnable {
    final /* synthetic */ String hMZ;
    final /* synthetic */ boolean hNa;
    final /* synthetic */ o hNb;

    o$1(o oVar, String str, boolean z) {
        this.hNb = oVar;
        this.hMZ = str;
        this.hNa = z;
    }

    public final void run() {
        int i;
        String str = "MicroMsg.NetSceneGetDisasterInfo";
        String str2 = "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]";
        Object[] objArr = new Object[2];
        if (this.hMZ == null) {
            i = -1;
        } else {
            i = this.hMZ.length();
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(this.hNa);
        x.i(str, str2, objArr);
        b ahVar = new ah();
        ahVar.foi.type = 5;
        ahVar.foi.fok = this.hMZ;
        a.xef.m(ahVar);
        str = ahVar.foj.fop;
        int i2 = ahVar.foj.position;
        int i3 = ahVar.foj.fom;
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i2), Boolean.valueOf(o.a(this.hNb)), o.RP()});
        if (i2 == 1 && i3 == 6) {
            if (this.hNa) {
                o.av(str, this.hMZ);
            }
            if (o.a(this.hNb)) {
                str2 = ahVar.foj.desc;
                String str3 = ahVar.foj.url;
                x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", new Object[]{Boolean.valueOf(ac.cfp())});
                if (o.b(this.hNb) == null) {
                    o.a(this.hNb, new 1(this, str2, str3));
                }
                a.xef.b(o.b(this.hNb));
            } else {
                b iyVar = new iy();
                iyVar.fzB.content = ahVar.foj.desc;
                iyVar.fzB.url = ahVar.foj.url;
                a.xef.m(iyVar);
            }
            o.RP().put(str, Long.valueOf(bh.Wq()));
        } else if (i3 == 2) {
            if (this.hNa) {
                o.av(str, this.hMZ);
            }
            o.RP().put(str, Long.valueOf(bh.Wq()));
        }
    }
}
