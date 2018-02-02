package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.au.a;

public final class h {
    private boolean oGM;
    private boolean oGN;

    public final void y(Activity activity) {
        if (!this.oGM) {
            this.oGM = true;
            a.a(activity, R.l.eww, null);
        }
    }

    public final void z(Activity activity) {
        if (!this.oGN) {
            this.oGN = true;
            a.a(activity, R.l.eVC, null);
        }
    }

    public final void reset() {
        this.oGN = false;
        this.oGM = false;
    }
}
