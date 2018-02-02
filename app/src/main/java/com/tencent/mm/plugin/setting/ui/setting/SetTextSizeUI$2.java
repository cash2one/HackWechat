package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bv.a;

class SetTextSizeUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SetTextSizeUI qhN;

    SetTextSizeUI$2(SetTextSizeUI setTextSizeUI) {
        this.qhN = setTextSizeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a.h(this.qhN, SetTextSizeUI.a(this.qhN));
        this.qhN.finish();
        return true;
    }
}
