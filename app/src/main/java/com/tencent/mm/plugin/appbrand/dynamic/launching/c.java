package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.mv;
import com.tencent.mm.protocal.c.mw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    private final String appId;
    private final String fqR;
    private final String iUm;
    private final boolean iUn;

    public enum a {
        ;

        static {
            iUo = 1;
            iUp = 2;
            iUq = 3;
            iUr = 4;
            iUs = 5;
            iUt = 6;
            iUu = new int[]{iUo, iUp, iUq, iUr, iUs, iUt};
        }
    }

    private c(String str, String str2, String str3) {
        this.appId = str;
        this.fqR = str2;
        this.iUm = str3;
        this.iUn = false;
    }

    public c(String str, String str2, String str3, byte b) {
        this(str, str2, str3);
    }

    private void h(int i, String str, String str2) {
        ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(this.appId, i, str, str2, 0, 0);
    }

    public final int adc() {
        String str = this.appId;
        String str2 = this.fqR;
        String str3 = this.iUm;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        com.tencent.mm.bq.a mvVar = new mv();
        mvVar.fFm = str;
        mvVar.vVy = str2;
        mvVar.vVz = str3;
        aVar.hmj = mvVar;
        aVar.hmk = new mw();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
        aVar.hmi = 1124;
        com.tencent.mm.ae.a.a c = com.tencent.mm.plugin.appbrand.i.c.c(aVar.JZ());
        if (c.errType == 0 && c.errCode == 0) {
            try {
                mw mwVar = (mw) c.fJJ;
                if (mwVar.vVA == null) {
                    x.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", new Object[]{this.appId});
                    return a.iUs - 1;
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
                return a.iUo - 1;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", e, "CgiCheckDemoInfo, appId %s, cast response failed", new Object[]{this.appId});
                return a.iUs - 1;
            }
        }
        x.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", new Object[]{this.appId, Integer.valueOf(c.errType), Integer.valueOf(c.errCode), c.fnL});
        return a.iUr - 1;
    }
}
