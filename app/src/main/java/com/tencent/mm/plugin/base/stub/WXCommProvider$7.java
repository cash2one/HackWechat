package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;

class WXCommProvider$7 implements Runnable {
    final /* synthetic */ WXCommProvider kvd;
    final /* synthetic */ b kvk;

    WXCommProvider$7(WXCommProvider wXCommProvider, b bVar) {
        this.kvd = wXCommProvider;
        this.kvk = bVar;
    }

    public final void run() {
        try {
            if (ar.Hj()) {
                ar.CG().a(new bd(new 1(this)), 0);
            }
        } catch (Exception e) {
            x.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy");
            this.kvk.countDown();
        }
    }
}
