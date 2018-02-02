package com.tencent.mm.plugin.report.b;

import com.tencent.b.a.a.f;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.u;
import com.tencent.mm.protocal.c.azy;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements f {
    d$1() {
    }

    public final void bH(String str) {
        x.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", new Object[]{str, Integer.valueOf(d.bl())});
        if (d.vD() <= 0) {
            x.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", new Object[]{Integer.valueOf(d.bl())});
            return;
        }
        a aVar = new a();
        aVar.hmj = new azy();
        aVar.hmk = new azz();
        aVar.uri = "/cgi-bin/micromsg-bin/querymid";
        aVar.hmi = 684;
        b JZ = aVar.JZ();
        ((azy) JZ.hmg.hmo).joU = str;
        ((azy) JZ.hmg.hmo).nhx = 1;
        u.a(JZ, new 1(this), true);
    }
}
