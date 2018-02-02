package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.by.h.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ap;
import java.util.HashMap;

public final class b implements ap {
    private a sdT;
    private c sdU = new 1(this);
    private c sdV = new 2(this);
    private c sdW = new 3(this);
    private c sdX = new 4(this);
    private c sdY = new 5(this);

    public final a bFl() {
        if (this.sdT == null) {
            this.sdT = new a();
        }
        return this.sdT;
    }

    public final void bq(boolean z) {
        a.xef.b(this.sdU);
        a.xef.b(this.sdV);
        a.xef.b(this.sdW);
        a.xef.b(this.sdX);
        a.xef.b(this.sdY);
    }

    public final void onAccountRelease() {
        a.xef.c(this.sdU);
        a.xef.c(this.sdV);
        a.xef.c(this.sdW);
        a.xef.c(this.sdX);
        a.xef.c(this.sdY);
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }
}
