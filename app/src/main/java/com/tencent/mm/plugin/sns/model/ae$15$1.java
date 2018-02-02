package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.qw;
import com.tencent.mm.plugin.sns.model.ae.15;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.sdk.platformtools.x;

class ae$15$1 implements Runnable {
    final /* synthetic */ qw qWN;
    final /* synthetic */ 15 qWO;

    ae$15$1(15 15, qw qwVar) {
        this.qWO = 15;
        this.qWN = qwVar;
    }

    public final void run() {
        int i = (int) this.qWN.fIH.fIJ;
        j bvA = ae.bvA();
        String str = " update SnsComment set isRead = 1 where isRead = 0 and  createTime <= " + i;
        x.i("MicroMsg.SnsCommentStorage", "updateToread " + str);
        x.i("MicroMsg.SnsCore", "update msg read " + bvA.hhp.fx("SnsComment", str));
        t.buR();
    }
}
