package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a.h;
import com.tencent.mm.protocal.c.aip;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class e$4 implements Runnable {
    final /* synthetic */ e jQw;

    e$4(e eVar) {
        this.jQw = eVar;
    }

    public final void run() {
        int i = 0;
        if (e.e(this.jQw) != null) {
            aip aaQ = g.aaQ();
            if (aaQ != null) {
                int i2 = aaQ.wqc == 1 ? 1 : 0;
                if (i2 != 0) {
                    asw com_tencent_mm_protocal_c_asw = aaQ.wqd;
                    if (com_tencent_mm_protocal_c_asw == null) {
                        x.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram but invalid appInfo, just return");
                        return;
                    }
                    if (b.ceK()) {
                        i = com_tencent_mm_protocal_c_asw.type;
                    }
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1001;
                    com.tencent.mm.plugin.appbrand.launching.precondition.g.jzg.a(e.e(this.jQw), com_tencent_mm_protocal_c_asw.username, null, com_tencent_mm_protocal_c_asw.path, i, com_tencent_mm_protocal_c_asw.vOv, appBrandStatObject, null, null);
                } else if (bh.ov(aaQ.wpR)) {
                    x.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram false, url empty, just return");
                    return;
                } else {
                    ((a) com.tencent.mm.kernel.g.h(a.class)).J(e.e(this.jQw), aaQ.wpR);
                }
                e.f(this.jQw);
                h hVar = new h();
                hVar.jIl = h.b.jIy;
                hVar.jIm = aaQ.kkv;
                hVar.jIn = aaQ.wpP;
                hVar.jIp = i2 != 0 ? h.a.jIt : h.a.jIq;
                hVar.wW();
            }
        }
    }
}
