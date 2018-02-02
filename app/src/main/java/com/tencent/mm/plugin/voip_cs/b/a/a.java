package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class a {
    private static a sxc;
    public h snl = new h(ac.getContext());

    private a() {
    }

    public static a bIZ() {
        if (sxc == null) {
            sxc = new a();
        }
        return sxc;
    }

    public static a bJa() {
        if (sxc == null) {
            sxc = bIZ();
        }
        return sxc;
    }

    public final void bJb() {
        if (this.snl != null) {
            this.snl.m(R.k.dAk, 0, true);
        }
    }

    public final void stopRing() {
        if (this.snl != null) {
            this.snl.stop();
        }
    }

    public final boolean bHv() {
        if (this.snl != null) {
            return this.snl.aip();
        }
        return true;
    }
}
