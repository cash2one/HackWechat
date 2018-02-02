package com.tencent.mm.ui.contact;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;

class ChatroomContactUI$8 implements c {
    final /* synthetic */ ChatroomContactUI yRt;

    ChatroomContactUI$8(ChatroomContactUI chatroomContactUI) {
        this.yRt = chatroomContactUI;
    }

    public final int ci(View view) {
        return ChatroomContactUI.b(this.yRt).getPositionForView(view);
    }
}
