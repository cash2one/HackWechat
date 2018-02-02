package com.tencent.mm.ui.bindqq;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VerifyQQUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ VerifyQQUI ymV;

    VerifyQQUI$1(VerifyQQUI verifyQQUI) {
        this.ymV = verifyQQUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ymV.aWs();
        VerifyQQUI.a(this.ymV);
        return true;
    }
}
