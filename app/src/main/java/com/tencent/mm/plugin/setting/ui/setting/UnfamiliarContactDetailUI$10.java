package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar.a;

class UnfamiliarContactDetailUI$10 implements a {
    final /* synthetic */ UnfamiliarContactDetailUI qma;

    UnfamiliarContactDetailUI$10(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.qma = unfamiliarContactDetailUI;
    }

    public final void xh(String str) {
        UnfamiliarContactDetailUI unfamiliarContactDetailUI = this.qma;
        int intValue = (unfamiliarContactDetailUI.qlS == null || !unfamiliarContactDetailUI.qlS.containsKey(str)) ? -1 : ((Integer) unfamiliarContactDetailUI.qlS.get(str)).intValue();
        x.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[]{str, Integer.valueOf(intValue)});
        if (intValue != -1) {
            UnfamiliarContactDetailUI.j(this.qma).be(intValue);
        }
    }
}
