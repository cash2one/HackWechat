package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.base.stub.WXCommProvider.7;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bd.a;

class WXCommProvider$7$1 implements a {
    final /* synthetic */ 7 kvl;

    WXCommProvider$7$1(7 7) {
        this.kvl = 7;
    }

    public final void a(e eVar) {
        x.i("MicroMsg.WXCommProvider", "checkIsLogin() onSceneEnd()");
        this.kvl.kvk.countDown();
    }
}
