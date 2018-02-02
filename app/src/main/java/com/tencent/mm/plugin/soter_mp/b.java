package com.tencent.mm.plugin.soter_mp;

import com.tencent.mm.by.h.d;
import com.tencent.mm.plugin.soter_mp.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import java.util.HashMap;

public final class b implements ap {
    private static com.tencent.mm.plugin.soter_mp.b.b rSS = new com.tencent.mm.plugin.soter_mp.b.b();
    private static a rST = new a();

    public final HashMap<Integer, d> Bn() {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter getBaseDBFactories");
        return null;
    }

    public final void gd(int i) {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter clearPluginData");
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter onAccountPostReset");
        if (!com.tencent.mm.sdk.b.a.xef.d(rSS)) {
            com.tencent.mm.sdk.b.a.xef.b(rSS);
        }
        if (!com.tencent.mm.sdk.b.a.xef.d(rST)) {
            com.tencent.mm.sdk.b.a.xef.b(rST);
        }
    }

    public final void br(boolean z) {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoterMp onSdcardMount");
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoterMp onAccountRelease");
    }
}
