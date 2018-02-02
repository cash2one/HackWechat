package com.tencent.mm.plugin.sns.ui.widget;

import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class b {
    private static b rRK = new b();
    private a rRI = null;
    public int rRJ = 0;

    public static b bCD() {
        return rRK;
    }

    public final a bCE() {
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), (int) (14.0f * com.tencent.mm.bv.a.eu(ac.getContext())));
        if (this.rRI == null || ((int) this.rRI.gUh) != fromDPToPix) {
            this.rRI = com.tencent.mm.kiss.widget.textview.a.b.Ek().P((float) fromDPToPix).gG(ac.getContext().getResources().getColor(c.qyx)).gF(16).gTR;
        }
        return this.rRI;
    }
}
