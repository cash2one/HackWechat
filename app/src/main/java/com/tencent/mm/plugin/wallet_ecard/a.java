package com.tencent.mm.plugin.wallet_ecard;

import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ap;
import java.util.HashMap;

public class a implements ap {
    private c<cl> sYL = new 1(this);
    private c<ld> sYM = new 2(this);

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        this.sYL.ceO();
        this.sYM.ceO();
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        this.sYL.dead();
        this.sYM.dead();
    }
}
