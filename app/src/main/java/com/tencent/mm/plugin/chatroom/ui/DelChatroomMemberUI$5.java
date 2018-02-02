package com.tencent.mm.plugin.chatroom.ui;

class DelChatroomMemberUI$5 implements Runnable {
    final /* synthetic */ DelChatroomMemberUI laP;

    DelChatroomMemberUI$5(DelChatroomMemberUI delChatroomMemberUI) {
        this.laP = delChatroomMemberUI;
    }

    public final void run() {
        if (DelChatroomMemberUI.a(this.laP).getCount() == 0) {
            this.laP.finish();
        }
    }
}
