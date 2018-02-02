package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bm.d;

class RechargeUI$18 implements OnMenuItemClickListener {
    final /* synthetic */ RechargeUI pDQ;

    RechargeUI$18(RechargeUI rechargeUI) {
        this.pDQ = rechargeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", RechargeUI.j(this.pDQ));
        d.b(this.pDQ, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }
}
