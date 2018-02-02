package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.g;

class AAQueryListUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ AAQueryListUI iih;

    AAQueryListUI$4(AAQueryListUI aAQueryListUI) {
        this.iih = aAQueryListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.iih, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new 2(this);
        gVar.bUk();
        return true;
    }
}
