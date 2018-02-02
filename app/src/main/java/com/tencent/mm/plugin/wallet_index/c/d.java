package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alb;
import com.tencent.mm.protocal.c.alc;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class d extends l {
    public int errCode;
    private b gJQ;
    private e gJT;
    public alb tao;
    public alc tap;

    public d(int i, String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7) {
        a aVar = new a();
        aVar.hmj = new xs();
        aVar.hmk = new xt();
        aVar.uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
        aVar.hmi = 1130;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        xs xsVar = (xs) this.gJQ.hmg.hmo;
        xsVar.fFm = str;
        xsVar.wij = i;
        xsVar.wik = Integer.parseInt(str2);
        xsVar.desc = str3;
        xsVar.count = i2;
        xsVar.scene = 13;
        xsVar.wil = str4;
        xsVar.wim = str5;
        xsVar.sign = str6;
        xsVar.win = str7;
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            xt xtVar = (xt) this.gJQ.hmh.hmo;
            x.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + xtVar.fxK + ",errMsg:" + xtVar.fxL);
            int i3 = xtVar.fxK;
            String str2 = xtVar.fxL;
            if (i3 == 0) {
                this.tao = xtVar.wio;
                this.tap = xtVar.wip;
            }
            this.gJT.a(i, i3, str2, this);
            return;
        }
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return 1130;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
