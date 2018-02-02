package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.8;
import com.tencent.mm.ui.base.p$d;

class UnfamiliarContactDetailUI$8$2 implements p$d {
    final /* synthetic */ 8 qme;

    UnfamiliarContactDetailUI$8$2(8 8) {
        this.qme = 8;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        g.Dk();
        g.Di().gPJ.b(681, UnfamiliarContactDetailUI.h(this.qme.qma));
        UnfamiliarContactDetailUI.a(this.qme.qma, UnfamiliarContactDetailUI.b(this.qme.qma), i);
        UnfamiliarContactDetailUI.b(this.qme.qma, false);
        if (UnfamiliarContactDetailUI.e(this.qme.qma) != null) {
            UnfamiliarContactDetailUI.e(this.qme.qma).UR.notifyChanged();
        }
    }
}
