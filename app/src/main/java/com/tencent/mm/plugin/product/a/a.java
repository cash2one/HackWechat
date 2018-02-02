package com.tencent.mm.plugin.product.a;

import com.tencent.mm.by.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.util.HashMap;

public class a implements ap {
    private c pdG = null;
    private d pdH = null;
    private com.tencent.mm.plugin.product.b.a pdI = new com.tencent.mm.plugin.product.b.a();

    public static a biM() {
        return (a) p.s(a.class);
    }

    public final HashMap<Integer, h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        this.pdG = null;
        com.tencent.mm.sdk.b.a.xef.b(this.pdI);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xef.c(this.pdI);
    }

    public static c biN() {
        g.Dh().Ct();
        if (biM().pdG == null) {
            biM().pdG = new c();
        }
        return biM().pdG;
    }

    public final d biO() {
        g.Dh().Ct();
        if (this.pdH == null) {
            this.pdH = new d();
        }
        return this.pdH;
    }
}
