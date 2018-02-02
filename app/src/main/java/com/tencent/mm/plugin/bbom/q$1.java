package com.tencent.mm.plugin.bbom;

import com.tencent.mm.z.am;
import java.util.List;

class q$1 implements Runnable {
    final /* synthetic */ am kvM;
    final /* synthetic */ List kvN;
    final /* synthetic */ q kvO;

    q$1(q qVar, am amVar, List list) {
        this.kvO = qVar;
        this.kvM = amVar;
        this.kvN = list;
    }

    public final void run() {
        this.kvM.y(this.kvN);
    }
}
