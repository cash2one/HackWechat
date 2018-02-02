package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;

class RoomCardUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RoomCardUI lbL;

    RoomCardUI$1(RoomCardUI roomCardUI) {
        this.lbL = roomCardUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getTitle().equals(this.lbL.getString(R.l.dFl))) {
            RoomCardUI.a(this.lbL);
        }
        RoomCardUI.b(this.lbL).setEnabled(true);
        RoomCardUI.b(this.lbL).setFocusableInTouchMode(true);
        RoomCardUI.b(this.lbL).setFocusable(true);
        RoomCardUI.b(this.lbL).setCursorVisible(true);
        this.lbL.updateOptionMenuText(0, this.lbL.getString(R.l.dFl));
        this.lbL.enableOptionMenu(false);
        this.lbL.showVKB();
        RoomCardUI.b(this.lbL).setSelection(RoomCardUI.b(this.lbL).getText().toString().length());
        return true;
    }
}
