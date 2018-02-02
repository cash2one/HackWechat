package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.config.m.a;
import com.tencent.mm.plugin.appbrand.config.m.b;
import com.tencent.mm.plugin.appbrand.config.m.c;
import com.tencent.mm.protocal.c.cs;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class m$2 implements b {
    final /* synthetic */ String iOT;
    final /* synthetic */ c iOU;

    m$2(c cVar, String str) {
        this.iOU = cVar;
        this.iOT = str;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.b bVar) {
        if (i == 0 && i2 == 0) {
            xw xwVar = (xw) bVar.hmh.hmo;
            if (xwVar.wis == null || xwVar.wis.size() == 0) {
                x.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
                if (this.iOU != null) {
                    this.iOU.pL("");
                    return;
                }
                return;
            }
            cs csVar = (cs) xwVar.wis.get(0);
            x.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[]{csVar.vHJ, Integer.valueOf(csVar.vHI)});
            if (!bh.ov(csVar.vHJ)) {
                a.w(this.iOT, csVar.ktN, csVar.vHI);
                a.x(this.iOT, csVar.ktN, csVar.vHI);
                a.g(this.iOT, csVar.ktN, csVar.vHJ);
                if (this.iOU != null) {
                    this.iOU.pL(csVar.vHJ);
                    return;
                }
                return;
            } else if (this.iOU != null) {
                this.iOU.pL("");
                return;
            } else {
                return;
            }
        }
        x.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.iOU != null) {
            this.iOU.pL("");
        }
    }
}
