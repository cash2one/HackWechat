package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class r$2 extends RuntimeLoadModuleTask {
    final /* synthetic */ h iCJ;
    final /* synthetic */ r iCK;
    final /* synthetic */ String irZ;

    r$2(r rVar, String str, int i, int i2, String str2, String str3, h hVar) {
        this.iCK = rVar;
        this.irZ = str3;
        this.iCJ = hVar;
        super(str, i, i2, str2);
    }

    public final void pv(String str) {
        int i = 0;
        x.i("MicroMsg.AppBrand.RuntimeModularizingHelper", "onLoad, module(%s) pkgPath(%s)", new Object[]{this.irZ, str});
        if (!bh.ov(str)) {
            i = 1;
        }
        if (i != 0) {
            Iterator it = this.iCK.irF.iqx.iOI.iGO.iterator();
            while (it.hasNext()) {
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                if (this.irZ.equals(modulePkgInfo.name)) {
                    modulePkgInfo.iEa = str;
                    break;
                }
            }
            ah.j(this.iCK.irF);
            this.iCK.irF.iqB.pn(this.irZ);
        }
        ag.y(new 1(this));
        r.a(this.iCK, this.irZ, i != 0 ? c.OK : c.FAIL);
    }
}
