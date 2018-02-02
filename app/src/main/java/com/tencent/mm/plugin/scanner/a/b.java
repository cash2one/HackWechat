package com.tencent.mm.plugin.scanner.a;

import android.app.Activity;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.sdk.b.c;

public final class b {
    Activity mActivity;
    String pSD;
    e pSE;
    a pSF;
    e.a pSG = new 1(this);
    public c pSH = new 2(this);
    public c pSI = new 3(this);

    public final void boC() {
        if (this.pSE != null) {
            this.pSE.bpA();
            this.pSE = null;
        }
        this.mActivity = null;
        this.pSD = null;
    }
}
