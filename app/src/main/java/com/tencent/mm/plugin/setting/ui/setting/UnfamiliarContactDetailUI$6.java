package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.R;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.f;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class UnfamiliarContactDetailUI$6 implements g {
    final /* synthetic */ UnfamiliarContactDetailUI qma;

    UnfamiliarContactDetailUI$6(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.qma = unfamiliarContactDetailUI;
    }

    public final void ds(int i, int i2) {
        f.qmy += i;
        UnfamiliarContactDetailUI.c(this.qma, false);
        UnfamiliarContactDetailUI.g(this.qma).setText(this.qma.getString(R.l.eRJ) + "(" + UnfamiliarContactDetailUI.f(this.qma).size() + ")");
        if (UnfamiliarContactDetailUI.e(this.qma) != null) {
            UnfamiliarContactDetailUI.e(this.qma).UR.notifyChanged();
        }
        if (i2 < i) {
            x.w("MicroMsg.UnfamiliarContactUI", "[onDelSuccess] realDeleteCount:%s count:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
            h.b(this.qma.mController.xIM, this.qma.getString(R.l.eRH, new Object[]{Integer.valueOf(i - i2)}), "", true);
        }
    }

    public final void brj() {
        UnfamiliarContactDetailUI.c(this.qma, true);
    }
}
