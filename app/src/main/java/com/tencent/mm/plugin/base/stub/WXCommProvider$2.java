package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.g.a.er;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$2 implements a {
    final /* synthetic */ WXCommProvider kvd;

    WXCommProvider$2(WXCommProvider wXCommProvider) {
        this.kvd = wXCommProvider;
    }

    public final boolean uF() {
        if (com.tencent.mm.sdk.b.a.xef == null || !com.tencent.mm.sdk.b.a.xef.B(er.class)) {
            return true;
        }
        synchronized (WXCommProvider.aqZ()) {
            x.i("MicroMsg.WXCommProvider", "The lock was released.");
            WXCommProvider.anB();
            WXCommProvider.aqZ().notifyAll();
        }
        return false;
    }
}
