package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.by.h.d;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import java.util.HashMap;

public final class b implements ap {
    private a kEB;

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        x.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
        if (this.kEB == null) {
            this.kEB = new a();
        }
        a.xef.b(this.kEB);
        h.a(new com.tencent.mm.plugin.brandservice.ui.a.d());
        h.a(new com.tencent.mm.plugin.brandservice.ui.a.b());
    }

    public final void onAccountRelease() {
        if (this.kEB != null) {
            a.xef.c(this.kEB);
        }
        h.qh(96);
        h.qh(4192);
    }
}
