package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView$c;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$14 implements MMSlideDelView$c {
    final /* synthetic */ a yWk;

    BizConversationUI$a$14(a aVar) {
        this.yWk = aVar;
    }

    public final int ci(View view) {
        return a.d(this.yWk).getPositionForView(view);
    }
}
