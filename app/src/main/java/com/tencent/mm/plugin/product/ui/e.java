package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.sdk.platformtools.x;

public final class e {
    int pfD;
    int pfE;

    public e(int i, int i2) {
        this.pfE = i;
        this.pfD = i2;
    }

    public final boolean bjl() {
        boolean z = (this.pfE & 1) > 0;
        x.d("MicroMsg.MallProductConfig", "isFreePost, ret = " + z);
        return z;
    }
}
