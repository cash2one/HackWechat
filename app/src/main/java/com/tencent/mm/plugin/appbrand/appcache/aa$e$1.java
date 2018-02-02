package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.pluginsdk.i.a.d.e;
import com.tencent.mm.pluginsdk.i.a.d.l;

class aa$e$1 implements Runnable {
    final /* synthetic */ l iFL;
    final /* synthetic */ e iFM;
    final /* synthetic */ aa.e iFN;

    aa$e$1(aa.e eVar, l lVar, e eVar2) {
        this.iFN = eVar;
        this.iFL = lVar;
        this.iFM = eVar2;
    }

    public final void run() {
        switch (this.iFL.status) {
            case 2:
                aa.e.c(this.iFM, this.iFL);
                return;
            case 3:
                aa.e.b(this.iFM, this.iFL);
                return;
            case 4:
                aa.e.d(this.iFM, this.iFL);
                return;
            default:
                return;
        }
    }
}
