package com.tencent.mm.ui.contact;

import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.b;
import com.tencent.mm.sdk.platformtools.x;

class ChatroomContactUI$5 implements b {
    final /* synthetic */ ChatroomContactUI yRt;

    ChatroomContactUI$5(ChatroomContactUI chatroomContactUI) {
        this.yRt = chatroomContactUI;
    }

    public final void kZ(boolean z) {
        x.d("MicroMsg.ChatroomContactUI", "visible " + z);
        if (z) {
            int firstVisiblePosition = ChatroomContactUI.b(this.yRt).getFirstVisiblePosition();
            x.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  " + firstVisiblePosition);
            if (firstVisiblePosition > 0) {
                ChatroomContactUI.b(this.yRt).post(new 1(this));
            }
        }
    }
}
