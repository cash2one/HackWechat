package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;

class WXCommProvider$6 extends bc<Boolean> {
    final /* synthetic */ WXCommProvider kvd;

    WXCommProvider$6(WXCommProvider wXCommProvider, Boolean bool) {
        this.kvd = wXCommProvider;
        super(4000, bool, true);
    }

    protected final /* synthetic */ Object run() {
        return ajr();
    }

    private Boolean ajr() {
        try {
            x.i("MicroMsg.WXCommProvider", "checkIsLogin run");
            if (!ar.Hj()) {
                return Boolean.valueOf(false);
            }
            x.i("MicroMsg.WXCommProvider", "checkIsLogin doScene");
            return Boolean.valueOf(ar.CG().a(new bd(new 1(this)), 0));
        } catch (Exception e) {
            x.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy.");
            bX(Boolean.valueOf(false));
            return Boolean.valueOf(false);
        }
    }
}
