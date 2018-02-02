package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ag;

class SelectContactUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SelectContactUI yUy;

    SelectContactUI$1(SelectContactUI selectContactUI) {
        this.yUy = selectContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yUy.aWs();
        this.yUy.finish();
        if (!this.yUy.getIntent().getBooleanExtra("stay_in_wechat", true)) {
            ag.h(new 1(this), 80);
        }
        return true;
    }
}
