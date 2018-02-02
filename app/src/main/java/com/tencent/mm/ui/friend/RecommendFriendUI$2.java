package com.tencent.mm.ui.friend;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class RecommendFriendUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ RecommendFriendUI zdr;

    RecommendFriendUI$2(RecommendFriendUI recommendFriendUI) {
        this.zdr = recommendFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        int length = RecommendFriendUI.b(this.zdr).cwU().length;
        h.a(this.zdr.mController.xIM, this.zdr.mController.xIM.getResources().getQuantityString(R.j.duz, length, new Object[]{Integer.valueOf(length)}), this.zdr.getString(R.l.dGO), new 1(this), new 2(this));
        return true;
    }
}
