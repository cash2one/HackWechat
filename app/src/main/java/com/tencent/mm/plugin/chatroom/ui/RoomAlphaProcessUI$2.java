package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;

class RoomAlphaProcessUI$2 implements Runnable {
    final /* synthetic */ boolean lbn;
    final /* synthetic */ RoomAlphaProcessUI lbp;

    RoomAlphaProcessUI$2(RoomAlphaProcessUI roomAlphaProcessUI, boolean z) {
        this.lbp = roomAlphaProcessUI;
        this.lbn = z;
    }

    public final void run() {
        Intent intent = new Intent(this.lbp, RoomUpgradeUI.class);
        intent.setFlags(603979776);
        intent.putExtra("room_name", RoomAlphaProcessUI.a(this.lbp));
        intent.putExtra("upgrade_success", this.lbn);
        this.lbp.startActivity(intent);
    }
}
