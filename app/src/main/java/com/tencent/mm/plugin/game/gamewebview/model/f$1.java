package com.tencent.mm.plugin.game.gamewebview.model;

import com.tencent.mm.bz.a;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements i<IPCRunCgiRespWrapper> {
    final /* synthetic */ f mXO;

    public f$1(f fVar) {
        this.mXO = fVar;
    }

    public final /* synthetic */ void as(Object obj) {
        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = (IPCRunCgiRespWrapper) obj;
        if (this.mXO.mXN != null) {
            x.i("MicroMsg.GameWebViewGetA8KeyHelp", "callback(%d), this(%d)", new Object[]{Integer.valueOf(this.mXO.mXN.hashCode()), Integer.valueOf(hashCode())});
            a.Z(new 1(this, iPCRunCgiRespWrapper));
        }
    }
}
