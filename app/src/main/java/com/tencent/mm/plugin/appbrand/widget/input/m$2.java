package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;

class m$2 implements Runnable {
    final /* synthetic */ String iaA;
    final /* synthetic */ Integer jXT;
    final /* synthetic */ p jdJ;

    m$2(p pVar, String str, Integer num) {
        this.jdJ = pVar;
        this.iaA = str;
        this.jXT = num;
    }

    public final void run() {
        z zVar = (z) m.amH().get(this.jdJ);
        if (zVar != null) {
            y lV = m.lV(zVar.getInputId());
            if (lV != null) {
                lV.updateValue(this.iaA, this.jXT);
            }
        }
    }
}
