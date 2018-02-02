package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.config.m.a;
import com.tencent.mm.plugin.appbrand.config.m.b;
import com.tencent.mm.protocal.c.cs;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class m$1 implements b {
    final /* synthetic */ String iOT;

    m$1(String str) {
        this.iOT = str;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.b bVar) {
        if (i == 0 && i2 == 0) {
            xw xwVar = (xw) bVar.hmh.hmo;
            if (xwVar.wis == null || xwVar.wis.size() == 0) {
                x.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
                return;
            }
            x.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[]{Integer.valueOf(xwVar.wis.size())});
            Iterator it = xwVar.wis.iterator();
            while (it.hasNext()) {
                cs csVar = (cs) it.next();
                x.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[]{csVar.vHJ, Integer.valueOf(csVar.vHI)});
                if (!bh.ov(csVar.vHJ)) {
                    a.w(this.iOT, csVar.ktN, csVar.vHI);
                    a.x(this.iOT, csVar.ktN, csVar.vHI);
                    a.g(this.iOT, csVar.ktN, csVar.vHJ);
                }
            }
            return;
        }
        x.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }
}
