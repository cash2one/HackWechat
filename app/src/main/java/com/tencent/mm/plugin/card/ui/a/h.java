package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class h extends a {
    public h(MMActivity mMActivity) {
        super(mMActivity);
    }

    protected final void awu() {
        super.awu();
    }

    public final boolean awE() {
        ArrayList wo = b.wo(this.kIK.atG());
        if ((!this.kRo.kJZ || this.kRo.kFm == 4) && !TextUtils.isEmpty(this.kIK.atH())) {
            return true;
        }
        if (this.kRo.kJZ && wo != null && wo.size() > 0) {
            return true;
        }
        if (TextUtils.isEmpty(this.kIK.atH()) || !awF()) {
            return false;
        }
        return true;
    }

    public final boolean awF() {
        return this.kRo.kFm == 3;
    }

    public final boolean awG() {
        return false;
    }

    public final boolean awI() {
        return this.kVW;
    }

    public final boolean awL() {
        return false;
    }

    public final boolean awM() {
        return this.kVW && super.awM();
    }

    public final boolean awQ() {
        return false;
    }

    public final boolean awR() {
        return false;
    }

    public final boolean awJ() {
        return false;
    }

    public final boolean awS() {
        if (super.awS() || awT()) {
            return true;
        }
        if (this.kIK.ath() && this.kVW) {
            return true;
        }
        return false;
    }

    public final boolean awT() {
        return !this.kVW && this.kIK.atB().vSf == 1;
    }
}
