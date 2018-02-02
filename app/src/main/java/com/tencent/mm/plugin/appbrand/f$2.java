package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.f.3;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.f;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Iterator;
import java.util.LinkedList;

class f$2 implements Runnable {
    final /* synthetic */ e irs;
    final /* synthetic */ AppBrandInitConfig irt;
    final /* synthetic */ AppBrandStatObject iru;
    final /* synthetic */ f irv;

    f$2(f fVar, e eVar, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        this.irv = fVar;
        this.irs = eVar;
        this.irt = appBrandInitConfig;
        this.iru = appBrandStatObject;
    }

    public final void run() {
        boolean z = false;
        f fVar = this.irv;
        e eVar = this.irs;
        AppBrandInitConfig appBrandInitConfig = this.irt;
        AppBrandStatObject appBrandStatObject = this.iru;
        e pg = fVar.pg(appBrandInitConfig.appId);
        int indexOf = fVar.irp.indexOf(pg) - 1;
        if (indexOf >= 0) {
            LinkedList linkedList = new LinkedList();
            int i = indexOf;
            while (i >= 0 && ((e) fVar.irp.get(i)).Yy()) {
                linkedList.add(fVar.irp.get(i));
                i--;
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                e eVar2 = (e) it.next();
                if (eVar2 != eVar) {
                    fVar.d(eVar2);
                }
            }
        }
        if (!fVar.irp.contains(pg)) {
            fVar.irp.push(pg);
            if (fVar.iqD.indexOfChild(pg.iqD) == -1) {
                fVar.iqD.addView(pg.iqD);
            }
            fVar.irq.remove(pg.mAppId);
        }
        fVar.irp.remove(pg);
        fVar.irp.push(pg);
        pg.iqD.setVisibility(0);
        fVar.iqD.bringChildToFront(pg.iqD);
        pg.iqv = eVar;
        if (pg.gSX) {
            boolean z2;
            String str;
            if (appBrandInitConfig != null) {
                if (pg.iqU) {
                    pg.iqU = false;
                    z2 = true;
                } else if (appBrandInitConfig.iGA != pg.iqw.iGA) {
                    z2 = true;
                }
                pg.iqS = z2;
                if (!(appBrandInitConfig == null || appBrandStatObject == null || appBrandStatObject.scene == 1022 || appBrandStatObject.scene == 1001 || appBrandStatObject.scene == 1089 || appBrandStatObject.scene == 1090 || (bh.ov(appBrandInitConfig.iNW) && bh.ov(appBrandInitConfig.hjA) && bh.ov(pg.iqw.iNW) && bh.ov(pg.iqw.hjA)))) {
                    z = true;
                }
                pg.iqT = z;
                pg.iqw = appBrandInitConfig;
                str = appBrandInitConfig.iNW;
                pg.a(appBrandStatObject);
            }
            z2 = false;
            pg.iqS = z2;
            z = true;
            pg.iqT = z;
            pg.iqw = appBrandInitConfig;
            str = appBrandInitConfig.iNW;
            pg.a(appBrandStatObject);
        }
        if (eVar != null) {
            eVar.onPause();
            f.a(pg, eVar, new 3(fVar, eVar));
            pg.onResume();
        }
    }
}
