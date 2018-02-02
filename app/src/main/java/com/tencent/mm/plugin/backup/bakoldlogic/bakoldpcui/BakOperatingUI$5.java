package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BakOperatingUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ BakOperatingUI krW;

    BakOperatingUI$5(BakOperatingUI bakOperatingUI) {
        this.krW = bakOperatingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (BakOperatingUI.a(this.krW)) {
            BakOperatingUI.e(this.krW);
            return false;
        }
        BakOperatingUI.b(this.krW);
        BakOperatingUI.f(this.krW);
        return true;
    }
}
