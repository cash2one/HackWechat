package com.tencent.mm.plugin.auto.a;

import com.tencent.mm.by.h.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import java.util.HashMap;

public final class b implements ap {
    private a kio = new a();

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
        a.xef.b(this.kio.kim);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
        a.xef.c(this.kio.kim);
    }
}
