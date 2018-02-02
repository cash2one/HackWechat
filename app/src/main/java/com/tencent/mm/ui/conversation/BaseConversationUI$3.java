package com.tencent.mm.ui.conversation;

import android.view.View;
import android.view.View.OnClickListener;

class BaseConversationUI$3 implements OnClickListener {
    final /* synthetic */ BaseConversationUI yVX;

    BaseConversationUI$3(BaseConversationUI baseConversationUI) {
        this.yVX = baseConversationUI;
    }

    public final void onClick(View view) {
        this.yVX.finish();
    }
}
