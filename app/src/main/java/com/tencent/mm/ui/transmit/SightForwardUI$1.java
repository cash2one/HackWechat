package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.plugin.sight.encode.ui.b;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.ChattingUI;

class SightForwardUI$1 implements b {
    final /* synthetic */ SightForwardUI zpT;

    SightForwardUI$1(SightForwardUI sightForwardUI) {
        this.zpT = sightForwardUI;
    }

    public final void Ju(String str) {
        Intent intent = new Intent(this.zpT.mController.xIM, ChattingUI.class);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", str);
        this.zpT.startActivity(intent);
        this.zpT.finish();
    }

    public final void bty() {
        Intent intent = new Intent();
        intent.setClass(this.zpT.mController.xIM, LauncherUI.class).addFlags(67108864);
        this.zpT.startActivity(intent);
        this.zpT.finish();
    }
}
