package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.g.a.id;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$3 implements Runnable {
    final /* synthetic */ WXCommProvider kvd;
    final /* synthetic */ id kve;

    WXCommProvider$3(WXCommProvider wXCommProvider, id idVar) {
        this.kvd = wXCommProvider;
        this.kve = idVar;
    }

    public final void run() {
        if (!a.xef.m(this.kve)) {
            x.e("MicroMsg.WXCommProvider", "handle scan result failed again");
        }
    }
}
