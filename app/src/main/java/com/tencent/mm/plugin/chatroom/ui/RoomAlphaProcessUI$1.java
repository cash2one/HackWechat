package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;

class RoomAlphaProcessUI$1 implements Runnable {
    final /* synthetic */ boolean lbn;
    final /* synthetic */ int lbo;
    final /* synthetic */ RoomAlphaProcessUI lbp;

    RoomAlphaProcessUI$1(RoomAlphaProcessUI roomAlphaProcessUI, boolean z, int i) {
        this.lbp = roomAlphaProcessUI;
        this.lbn = z;
        this.lbo = i;
    }

    public final void run() {
        Intent intent = new Intent(this.lbp, RoomUpgradeUI.class);
        intent.setFlags(603979776);
        intent.putExtra("room_name", RoomAlphaProcessUI.a(this.lbp));
        intent.putExtra("upgrade_success", this.lbn);
        intent.putExtra("left_quota", this.lbo);
        this.lbp.startActivity(intent);
    }
}
