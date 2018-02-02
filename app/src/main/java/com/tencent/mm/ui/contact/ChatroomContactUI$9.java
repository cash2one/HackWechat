package com.tencent.mm.ui.contact;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class ChatroomContactUI$9 implements f {
    final /* synthetic */ ChatroomContactUI yRt;

    ChatroomContactUI$9(ChatroomContactUI chatroomContactUI) {
        this.yRt = chatroomContactUI;
    }

    public final void t(View view, int i) {
        ChatroomContactUI.b(this.yRt).performItemClick(view, i, 0);
    }
}
