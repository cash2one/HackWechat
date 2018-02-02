package com.tencent.mm.plugin.card.ui.a;

import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.ui.MMActivity;

public final class e extends a {
    public e(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final boolean awD() {
        if (!this.kIK.ati() || l.oa(this.kRo.kFm) || !this.kIK.atx() || this.kVW) {
            return true;
        }
        return false;
    }

    public final boolean awH() {
        return this.kIK.ati() && !l.oa(this.kRo.kFm) && this.kIK.atx() && !this.kVW;
    }

    public final boolean awI() {
        return this.kVW;
    }

    public final boolean awL() {
        return super.awL() || (this.kIK.atx() && !this.kVW && (aws() || awt()));
    }

    public final boolean awU() {
        return (!this.kIK.ati() || this.kIK.atB().vSa == null || !this.kIK.atx() || this.kVW || aws() || awt()) ? false : true;
    }

    public final boolean awQ() {
        return this.kIK.atx() && super.awQ() && !awK();
    }

    public final boolean awv() {
        return (!super.awv() || !this.kIK.atx() || this.kVW || aws() || awt()) ? false : true;
    }

    public final boolean awK() {
        return this.kIK.atB() != null && this.kIK.atB().vSo;
    }
}
