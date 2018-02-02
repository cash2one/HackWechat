package com.tencent.mm.ui.transmit;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bc.e;
import com.tencent.mm.sdk.platformtools.x;

class MMCreateChatroomUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MMCreateChatroomUI zof;

    MMCreateChatroomUI$1(MMCreateChatroomUI mMCreateChatroomUI) {
        this.zof = mMCreateChatroomUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!MMCreateChatroomUI.a(this.zof)) {
            MMCreateChatroomUI.a(this.zof, true);
            MMCreateChatroomUI.b(this.zof);
            if (MMCreateChatroomUI.c(this.zof) == 3) {
                MMCreateChatroomUI.d(this.zof);
                e.bR(true);
            }
        }
        x.i("MicroMsg.MMCreateChatroomUI", "Create the chatroom");
        return true;
    }
}
