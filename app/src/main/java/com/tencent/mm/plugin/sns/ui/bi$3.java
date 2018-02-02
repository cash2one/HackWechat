package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class bi$3 implements Runnable {
    final /* synthetic */ bi rMW;

    bi$3(bi biVar) {
        this.rMW = biVar;
    }

    public final void run() {
        x.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + this.rMW.rMO + " position:" + this.rMW.position + " list.bottom:" + this.rMW.nKG.getBottom());
    }
}
