package com.tencent.mm.ui.bizchat;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$20 implements c {
    final /* synthetic */ a ynJ;

    BizChatConversationUI$a$20(a aVar) {
        this.ynJ = aVar;
    }

    public final int ci(View view) {
        return a.i(this.ynJ).getPositionForView(view);
    }
}
