package com.tencent.mm.ui.bindqq;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BindQQUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ BindQQUI ymH;

    BindQQUI$4(BindQQUI bindQQUI) {
        this.ymH = bindQQUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ymH.aWs();
        this.ymH.finish();
        return true;
    }
}
