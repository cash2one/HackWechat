package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.f;
import com.tencent.mm.sdk.platformtools.bh;

class MallProductUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ MallProductUI phb;

    MallProductUI$2(MallProductUI mallProductUI) {
        this.phb = mallProductUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        f e = MallProductUI.e(this.phb);
        if (!bh.ov(e.pfH.pdM)) {
            g.Dk();
            g.Di().gPJ.a(new f(e.pfH.bjc(), e.pfH.pdM), 0);
        }
        e.pfH.clear();
        this.phb.finish();
        return true;
    }
}
