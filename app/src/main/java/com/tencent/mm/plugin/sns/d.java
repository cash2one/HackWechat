package com.tencent.mm.plugin.sns;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.p;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bjw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<hq> implements e {
    private int qye;
    private bjv qyf;
    private m qyg;
    private ak qyh;

    public d() {
        this.xen = hq.class.getName().hashCode();
    }

    private boolean a(hq hqVar) {
        if (hqVar instanceof hq) {
            this.qye = hqVar.fxW.ftB;
            this.qyg = ae.bvv().xo(this.qye);
            this.qyf = ai.m(this.qyg);
            if (this.qyf == null || ((this.qyf.wzw != 3 || this.qyf.wNl == null || this.qyf.wNl.size() <= 0) && (this.qyf.wzw != 5 || this.qyf.wym == null || this.qyf.wym.size() <= 0))) {
                k pVar = new p(this.qyg.field_snsId);
                ((bjw) pVar.gJQ.hmg.hmo).wNr = 1;
                g.Dk();
                g.Di().gPJ.a((int) i.CTRL_INDEX, (e) this);
                g.Dk();
                g.Di().gPJ.a(pVar, 0);
                this.qyh = new ak(new 1(this), false);
                this.qyh.J(10000, 10000);
                return true;
            }
            hqVar.fxX.fxY = this.qyf;
            return true;
        }
        x.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.qyh.TG();
        if (i == 0 && i2 == 0) {
            m eR = ae.bvv().eR(this.qyg.field_snsId);
            b nyVar = new ny();
            nyVar.fFR.fxY = ai.m(eR);
            a.xef.m(nyVar);
            return;
        }
        b nyVar2 = new ny();
        nyVar2.fFR.fxY = null;
        a.xef.m(nyVar2);
    }
}
