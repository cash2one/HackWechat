package com.tencent.mm.plugin.chatroom.ui;

import android.os.Build.VERSION;

class SeeRoomMemberUI$1 implements Runnable {
    final /* synthetic */ SeeRoomMemberUI lde;

    SeeRoomMemberUI$1(SeeRoomMemberUI seeRoomMemberUI) {
        this.lde = seeRoomMemberUI;
    }

    public final void run() {
        if (VERSION.SDK_INT >= 19) {
            SeeRoomMemberUI.b(this.lde).scrollListBy(SeeRoomMemberUI.a(this.lde));
            return;
        }
        SeeRoomMemberUI.a(SeeRoomMemberUI.b(this.lde), "trackMotionScroll", new Object[]{Integer.valueOf(-SeeRoomMemberUI.a(this.lde)), Integer.valueOf(-SeeRoomMemberUI.a(this.lde))}, new Class[]{Integer.TYPE, Integer.TYPE});
    }
}
