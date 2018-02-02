package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.g;

class FavRecordDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FavRecordDetailUI pFP;

    FavRecordDetailUI$2(FavRecordDetailUI favRecordDetailUI) {
        this.pFP = favRecordDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.pFP.mController.xIM, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new 2(this);
        gVar.bUk();
        return true;
    }
}
