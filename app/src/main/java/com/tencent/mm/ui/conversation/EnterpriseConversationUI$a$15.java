package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.tools.m;

class EnterpriseConversationUI$a$15 implements OnMenuItemClickListener {
    final /* synthetic */ a yZh;

    EnterpriseConversationUI$a$15(a aVar) {
        this.yZh = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (a.d(this.yZh) != null) {
            a.d(this.yZh).dismiss();
            a.a(this.yZh, null);
        }
        a.a(this.yZh, new m(this.yZh.getContext()));
        a.d(this.yZh).rKC = new 1(this);
        a.d(this.yZh).rKD = new 2(this);
        a.d(this.yZh).dM();
        g.df(a.c(this.yZh), 1);
        return false;
    }
}
