package com.tencent.mm.ui.bindmobile;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.tools.l;

class BindMContactIntroUI$23 implements OnMenuItemClickListener {
    final /* synthetic */ BindMContactIntroUI ylI;
    final /* synthetic */ int ylL;

    BindMContactIntroUI$23(BindMContactIntroUI bindMContactIntroUI, int i) {
        this.ylI = bindMContactIntroUI;
        this.ylL = i;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        l lVar = new l(this.ylI.mController.xIM);
        lVar.rKC = new 1(this);
        lVar.rKD = new 2(this);
        lVar.bBX();
        return false;
    }
}
