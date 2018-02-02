package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class HardCoderSettingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ HardCoderSettingUI zkJ;

    HardCoderSettingUI$1(HardCoderSettingUI hardCoderSettingUI) {
        this.zkJ = hardCoderSettingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.zkJ.finish();
        return true;
    }
}
