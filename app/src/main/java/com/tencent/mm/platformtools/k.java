package com.tencent.mm.platformtools;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class k implements Runnable {
    String fEL;
    String heK;
    String icv;

    public k(String str, String str2, String str3) {
        this.fEL = str;
        this.heK = str2;
        this.icv = str3;
    }

    public final void run() {
        if (!bh.ov(this.fEL) && !bh.ov(this.heK)) {
            x.d("MicroMsg.MoveDataFiles", "MoveDataFiles %s :" + this.fEL + " to :" + this.heK, this.icv);
            if (f.ze() && this.heK.substring(0, e.bnF.length()).equals(e.bnF)) {
                com.tencent.mm.sdk.platformtools.k.q(this.fEL + "/" + this.icv, this.heK + "/" + this.icv, true);
            }
        }
    }
}
