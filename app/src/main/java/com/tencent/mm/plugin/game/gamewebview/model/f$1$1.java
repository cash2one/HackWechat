package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.plugin.game.gamewebview.model.f.1;

class f$1$1 implements Runnable {
    final /* synthetic */ IPCRunCgiRespWrapper mXP;
    final /* synthetic */ 1 mXQ;

    f$1$1(1 1, IPCRunCgiRespWrapper iPCRunCgiRespWrapper) {
        this.mXQ = 1;
        this.mXP = iPCRunCgiRespWrapper;
    }

    public final void run() {
        this.mXQ.mXO.mXN.a(this.mXP.errType, this.mXP.errCode, this.mXP.fnL, this.mXP.gJQ);
    }
}
