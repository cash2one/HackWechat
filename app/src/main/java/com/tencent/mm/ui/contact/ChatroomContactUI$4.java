package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

class ChatroomContactUI$4 implements OnClickListener {
    final /* synthetic */ ChatroomContactUI yRt;

    ChatroomContactUI$4(ChatroomContactUI chatroomContactUI) {
        this.yRt = chatroomContactUI;
    }

    public final void onClick(View view) {
        c.a(ChatroomContactUI.b(this.yRt));
    }
}
