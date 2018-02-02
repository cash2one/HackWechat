package com.tencent.mm.plugin.card.ui.a;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;

public final class f extends a {
    public f(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean awI() {
        return this.kVW;
    }

    public final boolean awJ() {
        return this.kIK.atx() && super.awJ() && (this.kIK.atv() || !bh.ov(this.kIK.atC().code));
    }

    public final boolean awK() {
        return true;
    }

    public final boolean awN() {
        return this.kIK.atx() && super.awN();
    }
}
