package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.i.c;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.protocal.c.mv;
import com.tencent.mm.protocal.c.mw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class ae {
    private final String appId;
    private final String fqR;
    private final String iUm;
    private final boolean iUn;

    public ae(String str, String str2, String str3, boolean z) {
        this.appId = str;
        this.fqR = str2;
        this.iUm = str3;
        this.iUn = z;
    }

    private void h(int i, String str, String str2) {
        if (f.Zo().a(this.appId, i, str, str2, 0, 0) && this.iUn) {
            d.aJ(this.appId, 2);
        }
    }

    public final int adc() {
        String str = this.appId;
        String str2 = this.fqR;
        String str3 = this.iUm;
        a aVar = new a();
        com.tencent.mm.bq.a mvVar = new mv();
        mvVar.fFm = str;
        mvVar.vVy = str2;
        mvVar.vVz = str3;
        aVar.hmj = mvVar;
        aVar.hmk = new mw();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
        aVar.hmi = 1124;
        com.tencent.mm.ae.a.a c = c.c(aVar.JZ());
        if (c.errType == 0 && c.errCode == 0) {
            try {
                mw mwVar = (mw) c.fJJ;
                if (mwVar.vVA == null) {
                    x.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[]{this.appId});
                    return a.jyv.ordinal();
                }
                x.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", new Object[]{this.appId, Integer.valueOf(mwVar.vVA.lOr), Boolean.valueOf(mwVar.vVB), mwVar.vVC, mwVar.vVD});
                if (mwVar.vVA.lOr != 0) {
                    return mwVar.vVA.lOr;
                }
                if (!(!mwVar.vVB || bh.ov(mwVar.vVD) || bh.ov(mwVar.vVC))) {
                    h(2, mwVar.vVC, mwVar.vVD);
                }
                if (!(!mwVar.vVE || bh.ov(mwVar.vVG) || bh.ov(mwVar.vVF))) {
                    h(10001, mwVar.vVF, mwVar.vVG);
                }
                if (!bh.ov(mwVar.vVH)) {
                    ((i) f.u(i.class)).m(this.appId, 2, mwVar.vVH);
                }
                return a.jyr.ordinal();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", e, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[]{this.appId});
                return a.jyv.ordinal();
            }
        }
        x.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[]{this.appId, Integer.valueOf(c.errType), Integer.valueOf(c.errCode), c.fnL});
        return a.jyu.ordinal();
    }
}
