package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CollectBillUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ CollectBillUI llV;

    CollectBillUI$5(CollectBillUI collectBillUI) {
        this.llV = collectBillUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.llV.startActivity(new Intent(this.llV.mController.xIM, CollectBillListUI.class));
        return false;
    }
}
