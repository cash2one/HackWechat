package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.ui.base.h;

class MallGalleryUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ MallGalleryUI pfu;

    MallGalleryUI$4(MallGalleryUI mallGalleryUI) {
        this.pfu = mallGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String[] stringArray;
        if (d.OQ("favorite")) {
            stringArray = this.pfu.getResources().getStringArray(b.uaq);
        } else {
            stringArray = this.pfu.getResources().getStringArray(b.uar);
        }
        h.a(this.pfu.mController.xIM, null, stringArray, null, false, new 1(this));
        return true;
    }
}
