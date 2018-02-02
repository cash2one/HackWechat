package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SelectMemberUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SelectMemberUI ldP;

    SelectMemberUI$4(SelectMemberUI selectMemberUI) {
        this.ldP = selectMemberUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ldP.setResult(0);
        this.ldP.finish();
        return true;
    }
}
