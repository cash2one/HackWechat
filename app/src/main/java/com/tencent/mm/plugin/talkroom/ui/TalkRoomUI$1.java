package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class TalkRoomUI$1 implements a {
    final /* synthetic */ TalkRoomUI scT;

    TalkRoomUI$1(TalkRoomUI talkRoomUI) {
        this.scT = talkRoomUI;
    }

    public final boolean uF() {
        x.i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
        TalkRoomUI.a(this.scT);
        return false;
    }
}
