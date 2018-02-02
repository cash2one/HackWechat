package com.tencent.mm.plugin.s;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.bh;

public final class g {
    public long aep = 0;
    private boolean kTc;
    public boolean opA = false;
    boolean opB = false;
    boolean opC = false;
    public long opq = 0;
    public long opr = 0;
    public long ops = -1;
    public long opt = 0;
    public long opu = 0;
    public long opv = 0;
    public long opw = 10;
    public boolean opx = true;
    public boolean opy = true;
    public boolean opz = false;

    public g(boolean z) {
        this.kTc = z;
    }

    public final String asP() {
        return hashCode();
    }

    public final void Fd(String str) {
        if (this.opx) {
            com.tencent.mm.plugin.report.service.g.pQN.a(354, 152, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(500), Long.valueOf(bh.Wo()), str});
        }
    }

    public final void Fe(String str) {
        if (this.opx) {
            com.tencent.mm.plugin.report.service.g.pQN.a(354, 153, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(HardCoderJNI.SCENE_DB), Long.valueOf(bh.Wo()), str});
        }
    }

    public final void aZF() {
        if (this.opx) {
            com.tencent.mm.plugin.report.service.g.pQN.a(354, 155, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(503), Long.valueOf(bh.Wo()), ""});
        }
    }
}
