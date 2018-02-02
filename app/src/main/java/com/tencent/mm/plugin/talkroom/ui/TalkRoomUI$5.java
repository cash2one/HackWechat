package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class TalkRoomUI$5 implements a {
    final /* synthetic */ TalkRoomUI scT;

    TalkRoomUI$5(TalkRoomUI talkRoomUI) {
        this.scT = talkRoomUI;
    }

    public final boolean uF() {
        x.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
        TalkRoomUI.q(this.scT);
        return false;
    }
}
