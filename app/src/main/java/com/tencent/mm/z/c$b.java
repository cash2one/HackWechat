package com.tencent.mm.z;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;

class c$b implements Runnable {
    String fEL;
    String heK;

    public c$b(String str, String str2) {
        this.fEL = str;
        this.heK = str2;
    }

    public final void run() {
        if (!bh.ov(this.fEL) && !bh.ov(this.heK)) {
            x.d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.fEL + " to :" + this.heK);
            if (f.ze() && this.heK.substring(0, e.bnF.length()).equals(e.bnF)) {
                k.q(this.fEL + "image/", this.heK + "image/", true);
                k.q(this.fEL + "image2/", this.heK + "image2/", true);
                k.q(this.fEL + "video/", this.heK + "video/", true);
                k.q(this.fEL + "voice/", this.heK + "voice/", true);
                k.q(this.fEL + "voice2/", this.heK + "voice2/", true);
                k.q(this.fEL + "package/", this.heK + "package/", true);
                k.q(this.fEL + "emoji/", this.heK + "emoji/", true);
                k.q(this.fEL + "mailapp/", this.heK + "mailapp/", true);
                k.q(this.fEL + "brandicon/", this.heK + "brandicon/", true);
            }
        }
    }
}
