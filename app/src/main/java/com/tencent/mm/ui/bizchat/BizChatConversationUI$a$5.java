package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;
import com.tencent.mm.ui.tools.m;

class BizChatConversationUI$a$5 implements OnMenuItemClickListener {
    final /* synthetic */ a ynJ;

    BizChatConversationUI$a$5(a aVar) {
        this.ynJ = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (a.j(this.ynJ) != null) {
            a.j(this.ynJ).dismiss();
            a.a(this.ynJ, null);
        }
        a.a(this.ynJ, new m(this.ynJ.getContext()));
        a.j(this.ynJ).rKC = new 1(this);
        a.j(this.ynJ).rKD = new 2(this);
        a.j(this.ynJ).dM();
        return false;
    }
}
