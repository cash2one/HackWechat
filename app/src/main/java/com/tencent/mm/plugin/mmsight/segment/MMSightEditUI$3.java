package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class MMSightEditUI$3 implements a {
    final /* synthetic */ MMSightEditUI oxG;

    MMSightEditUI$3(MMSightEditUI mMSightEditUI) {
        this.oxG = mMSightEditUI;
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.MMSightEditUI", "%d on error what %d extra %d", new Object[]{Integer.valueOf(this.oxG.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void hX() {
        if (MMSightEditUI.h(this.oxG) != null) {
            MMSightEditUI.h(this.oxG).start();
            MMSightEditUI.h(this.oxG);
            MMSightEditUI.h(this.oxG).setAlpha(1.0f);
            ag.h(new 1(this), 300);
        }
    }

    public final void vh() {
        MMSightEditUI.h(this.oxG).c(0.0d, true);
    }

    public final int cf(int i, int i2) {
        return 0;
    }

    public final void cg(int i, int i2) {
    }
}
