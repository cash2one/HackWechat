package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.e.3;
import java.util.List;

class e$2 implements Runnable {
    final /* synthetic */ e rqm;
    final /* synthetic */ List rqn;
    final /* synthetic */ boolean rqo;

    e$2(e eVar, List list, boolean z) {
        this.rqm = eVar;
        this.rqn = list;
        this.rqo = z;
    }

    public final void run() {
        this.rqm.bT(this.rqn);
        ae.bvf().post(new 3(this.rqm, this.rqo));
    }
}
