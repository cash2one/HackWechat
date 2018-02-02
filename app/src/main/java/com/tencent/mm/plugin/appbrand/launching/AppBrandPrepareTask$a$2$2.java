package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.g.a.bw;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.2;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandPrepareTask$a$2$2 extends c<bw> {
    final /* synthetic */ 2 jxg;

    AppBrandPrepareTask$a$2$2(2 2) {
        this.jxg = 2;
        this.xen = bw.class.getName().hashCode();
    }

    private boolean a(bw bwVar) {
        if (bwVar != null) {
            dead();
            x.i("MicroMsg.AppBrandPrepareTask", "prepareCall account notifyAllDone, start real prepare");
        }
        this.jxg.jxf.ahN();
        return false;
    }
}
