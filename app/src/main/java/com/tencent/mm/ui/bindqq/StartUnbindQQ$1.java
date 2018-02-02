package com.tencent.mm.ui.bindqq;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class StartUnbindQQ$1 implements OnMenuItemClickListener {
    final /* synthetic */ StartUnbindQQ ymP;

    StartUnbindQQ$1(StartUnbindQQ startUnbindQQ) {
        this.ymP = startUnbindQQ;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ymP.finish();
        return true;
    }
}
