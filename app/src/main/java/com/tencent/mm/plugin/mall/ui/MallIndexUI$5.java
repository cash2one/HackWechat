package com.tencent.mm.plugin.mall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.g;

class MallIndexUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ MallIndexUI omF;

    MallIndexUI$5(MallIndexUI mallIndexUI) {
        this.omF = mallIndexUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        MallIndexUI.m(this.omF);
        g.pQN.h(14419, new Object[]{this.omF.ned, Integer.valueOf(5)});
        return true;
    }
}
