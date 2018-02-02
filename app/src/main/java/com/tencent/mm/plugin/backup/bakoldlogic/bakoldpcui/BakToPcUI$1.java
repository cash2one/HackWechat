package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

class BakToPcUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BakToPcUI ksc;

    BakToPcUI$1(BakToPcUI bakToPcUI) {
        this.ksc = bakToPcUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a.aql().aqm().mR(1);
        BakToPcUI.a(this.ksc);
        return true;
    }
}
