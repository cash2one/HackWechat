package com.tencent.mm.ui.bindmobile;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MobileFriendUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ MobileFriendUI ymF;

    MobileFriendUI$3(MobileFriendUI mobileFriendUI) {
        this.ymF = mobileFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ymF.aWs();
        this.ymF.finish();
        return true;
    }
}
