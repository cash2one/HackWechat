package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e.b;

class ag$1 implements b {
    final /* synthetic */ ag sQn;

    ag$1(ag agVar) {
        this.sQn = agVar;
    }

    public final void bN(Object obj) {
        if (obj == null || !(obj instanceof Double)) {
            x.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
            if (this.sQn.szU != null) {
                this.sQn.szU.sLf = -1.0d;
                return;
            }
            return;
        }
        if (((Double) obj).doubleValue() < 0.0d) {
            x.v("MicroMsg.WalletUserInfoManger", "val is zero %s", new Object[]{bh.cgy().toString()});
        }
        if (this.sQn.szU != null) {
            this.sQn.szU.sLf = ((Double) obj).doubleValue();
        }
    }
}
