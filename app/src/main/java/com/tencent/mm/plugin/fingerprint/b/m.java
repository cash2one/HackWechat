package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class m implements k {
    public final void a(a aVar) {
        x.i("MicroMsg.SoterPrePayAuthDelegate", "hy: pre auth prepare.");
        if (bh.ov(s.sPp.mzI)) {
            x.e("MicroMsg.SoterPrePayAuthDelegate", "hy: no challenge. failed.");
            aVar.ac(-1, "no challenge");
            return;
        }
        aVar.ac(0, "");
    }
}
