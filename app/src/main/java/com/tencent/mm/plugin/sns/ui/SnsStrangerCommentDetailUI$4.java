package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsStrangerCommentDetailUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SnsStrangerCommentDetailUI rGV;

    SnsStrangerCommentDetailUI$4(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.rGV = snsStrangerCommentDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.rGV.finish();
        return true;
    }
}
