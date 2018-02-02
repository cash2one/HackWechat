package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CropImageNewUI$19 implements OnMenuItemClickListener {
    final /* synthetic */ CropImageNewUI zhm;

    CropImageNewUI$19(CropImageNewUI cropImageNewUI) {
        this.zhm = cropImageNewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.zhm.finish();
        return true;
    }
}
