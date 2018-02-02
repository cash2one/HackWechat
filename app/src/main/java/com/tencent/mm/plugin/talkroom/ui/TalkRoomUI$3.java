package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.mm.plugin.talkroom.model.b;

class TalkRoomUI$3 implements Runnable {
    final /* synthetic */ String nUM;
    final /* synthetic */ TalkRoomUI scT;

    TalkRoomUI$3(TalkRoomUI talkRoomUI, String str) {
        this.scT = talkRoomUI;
        this.nUM = str;
    }

    public final void run() {
        b.bEC().cl(this.nUM, 0);
    }
}
