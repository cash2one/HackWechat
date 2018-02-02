package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.base.stub.WXCommProvider.6;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bd.a;

class WXCommProvider$6$1 implements a {
    final /* synthetic */ 6 kvj;

    WXCommProvider$6$1(6 6) {
        this.kvj = 6;
    }

    public final void a(e eVar) {
        x.i("MicroMsg.WXCommProvider", "checkIsLogin onSceneEnd() hasLogin:%s", new Object[]{Boolean.valueOf(WXCommProvider.kvc)});
        this.kvj.bX(Boolean.valueOf(true));
    }
}
