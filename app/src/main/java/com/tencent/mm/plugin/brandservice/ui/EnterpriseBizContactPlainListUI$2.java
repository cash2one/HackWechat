package com.tencent.mm.plugin.brandservice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EnterpriseBizContactPlainListUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ EnterpriseBizContactPlainListUI kGD;

    EnterpriseBizContactPlainListUI$2(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI) {
        this.kGD = enterpriseBizContactPlainListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kGD.aWs();
        this.kGD.finish();
        return true;
    }
}
