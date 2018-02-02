package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.f.a;
import com.tencent.mm.plugin.appbrand.widget.f.b;

class a$2 implements Runnable {
    final /* synthetic */ String iDZ;
    final /* synthetic */ e irw;

    a$2(e eVar, String str) {
        this.irw = eVar;
        this.iDZ = str;
    }

    public final void run() {
        n nVar = this.irw.iqC;
        if (nVar != null) {
            l aiT = nVar.aiT();
            if (aiT != null) {
                p aex = aiT.aex();
                if (aex != null) {
                    b bVar = aex.jEd;
                    String str = this.iDZ;
                    if (bVar.keY.aeM() != null && bVar.keY.mContext != null) {
                        if (bVar.keZ == null) {
                            bVar.keZ = new a(bVar.keY.mContext);
                            bVar.keZ.a(bVar.keY.aeM());
                        }
                        bVar.keY.aeM().bringChildToFront(bVar.keZ.getView());
                        bVar.keZ.vh(str);
                    }
                }
            }
        }
    }
}
