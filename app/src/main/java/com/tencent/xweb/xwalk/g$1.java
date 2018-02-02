package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkV8;

class g$1 implements Runnable {
    final /* synthetic */ int Ate;
    final /* synthetic */ g Atf;

    g$1(g gVar, int i) {
        this.Atf = gVar;
        this.Ate = i;
    }

    public final void run() {
        if (this.Atf.Atd == null) {
            this.Atf.Atd = new XWalkV8();
            this.Atf.Atd.init(this.Ate);
        }
    }
}
