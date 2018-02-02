package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFlipper.a;

class AppPanel$1 implements a {
    final /* synthetic */ AppPanel vpq;

    AppPanel$1(AppPanel appPanel) {
        this.vpq = appPanel;
    }

    public final void dm(int i, int i2) {
        x.d("MicroMsg.AppPanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + AppPanel.a(this.vpq));
        if (!AppPanel.a(this.vpq) && i2 != 0 && i != 0) {
            if (AppPanel.b(this.vpq) == 2) {
                x.d("MicroMsg.AppPanel", "landspace");
            } else {
                x.d("MicroMsg.AppPanel", "portrait");
            }
            AppPanel.c(this.vpq);
            AppPanel.a(this.vpq, i2);
            AppPanel.b(this.vpq, i);
            AppPanel.d(this.vpq);
        } else if (i2 == 0 || i == 0) {
            x.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
        }
    }
}
