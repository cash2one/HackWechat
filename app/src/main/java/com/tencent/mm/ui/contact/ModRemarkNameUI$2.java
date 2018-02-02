package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ModRemarkNameUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ModRemarkNameUI yTW;

    ModRemarkNameUI$2(ModRemarkNameUI modRemarkNameUI) {
        this.yTW = modRemarkNameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (ModRemarkNameUI.b(this.yTW)) {
            case 0:
                ModRemarkNameUI.c(this.yTW);
                break;
            case 3:
                ModRemarkNameUI.d(this.yTW);
                break;
            case 4:
                ModRemarkNameUI.e(this.yTW);
                break;
        }
        return true;
    }
}
