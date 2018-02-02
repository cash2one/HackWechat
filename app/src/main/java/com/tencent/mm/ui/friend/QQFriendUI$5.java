package com.tencent.mm.ui.friend;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QQFriendUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ QQFriendUI zdn;

    QQFriendUI$5(QQFriendUI qQFriendUI) {
        this.zdn = qQFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.zdn.aWs();
        this.zdn.finish();
        return true;
    }
}
