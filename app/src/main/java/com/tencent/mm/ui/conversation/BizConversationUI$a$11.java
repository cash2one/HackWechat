package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$11 implements OnMenuItemClickListener {
    final /* synthetic */ a yWk;

    BizConversationUI$a$11(a aVar) {
        this.yWk = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.yWk.finish();
        return true;
    }
}
