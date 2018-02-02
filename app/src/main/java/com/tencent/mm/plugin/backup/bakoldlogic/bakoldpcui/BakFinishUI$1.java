package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

class BakFinishUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BakFinishUI krN;

    BakFinishUI$1(BakFinishUI bakFinishUI) {
        this.krN = bakFinishUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a.aql().aqm().krc = -1;
        BakFinishUI.a(this.krN);
        return true;
    }
}
