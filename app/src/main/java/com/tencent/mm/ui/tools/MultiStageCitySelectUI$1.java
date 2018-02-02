package com.tencent.mm.ui.tools;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class MultiStageCitySelectUI$1 implements a {
    final /* synthetic */ MultiStageCitySelectUI zlZ;

    MultiStageCitySelectUI$1(MultiStageCitySelectUI multiStageCitySelectUI) {
        this.zlZ = multiStageCitySelectUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (MultiStageCitySelectUI.a(this.zlZ) == null) {
            return false;
        }
        if (z) {
            x.i("MicroMsg.MultiStageCitySelectUI", "lat:%f lng:%f accuracy:%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2));
            ar.CG().a(new n((double) f2, (double) f), 0);
        } else {
            MultiStageCitySelectUI.b(this.zlZ);
        }
        if (MultiStageCitySelectUI.a(this.zlZ) != null) {
            MultiStageCitySelectUI.a(this.zlZ).c(MultiStageCitySelectUI.c(this.zlZ));
            MultiStageCitySelectUI.d(this.zlZ);
        }
        return false;
    }
}
