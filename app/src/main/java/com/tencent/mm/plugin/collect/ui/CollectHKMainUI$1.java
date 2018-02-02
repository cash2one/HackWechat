package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.wallet_core.ui.e;

class CollectHKMainUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CollectHKMainUI lmf;

    CollectHKMainUI$1(CollectHKMainUI collectHKMainUI) {
        this.lmf = collectHKMainUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        e.l(this.lmf.mController.xIM, "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
        return false;
    }
}
