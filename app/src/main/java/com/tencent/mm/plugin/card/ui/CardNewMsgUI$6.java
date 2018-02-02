package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.g;

class CardNewMsgUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ CardNewMsgUI kUG;

    CardNewMsgUI$6(CardNewMsgUI cardNewMsgUI) {
        this.kUG = cardNewMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g.pQN.h(11582, new Object[]{"CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", ""});
        CardNewMsgUI.h(this.kUG);
        return true;
    }
}
