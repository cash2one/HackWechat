package com.tencent.mm.plugin.extaccessories;

import com.tencent.mm.by.h.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.HashMap;

public final class b implements ap {
    String gQi;
    private a mbV;

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
        ar.Hg();
        this.gQi = c.FC();
        File file = new File(this.gQi);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(this.gQi + "image/spen/");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void bq(boolean z) {
        x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
        if (this.mbV == null) {
            this.mbV = new a();
        }
        a.xef.b(this.mbV);
        ar.Dm().g(new 1(this), 5000);
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
        if (this.mbV != null) {
            a.xef.c(this.mbV);
        }
    }
}
