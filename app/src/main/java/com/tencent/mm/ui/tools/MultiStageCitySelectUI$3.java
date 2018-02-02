package com.tencent.mm.ui.tools;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.tools.p.b;

class MultiStageCitySelectUI$3 implements b {
    final /* synthetic */ MultiStageCitySelectUI zlZ;

    MultiStageCitySelectUI$3(MultiStageCitySelectUI multiStageCitySelectUI) {
        this.zlZ = multiStageCitySelectUI;
    }

    public final void Xs() {
    }

    public final void Xr() {
        this.zlZ.aWs();
        MultiStageCitySelectUI.g(this.zlZ);
        this.zlZ.cxR();
    }

    public final void oL(String str) {
        if (!bh.ov(str)) {
            MultiStageCitySelectUI.a(this.zlZ, str);
            MultiStageCitySelectUI.h(this.zlZ).removeAll();
            MultiStageCitySelectUI.j(this.zlZ).removeCallbacks(MultiStageCitySelectUI.i(this.zlZ));
            MultiStageCitySelectUI.j(this.zlZ).postDelayed(MultiStageCitySelectUI.i(this.zlZ), 50);
        }
    }

    public final boolean oK(String str) {
        if (bh.ov(str)) {
            return false;
        }
        MultiStageCitySelectUI.a(this.zlZ, str);
        MultiStageCitySelectUI.h(this.zlZ).removeAll();
        MultiStageCitySelectUI.j(this.zlZ).removeCallbacks(MultiStageCitySelectUI.i(this.zlZ));
        MultiStageCitySelectUI.j(this.zlZ).postDelayed(MultiStageCitySelectUI.i(this.zlZ), 50);
        return true;
    }

    public final void Xt() {
        MultiStageCitySelectUI.g(this.zlZ);
        this.zlZ.cxR();
    }

    public final void Xu() {
    }
}
