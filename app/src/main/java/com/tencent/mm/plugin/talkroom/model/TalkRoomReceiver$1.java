package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.sdk.platformtools.aa.b;
import com.tencent.mm.sdk.platformtools.ac;

class TalkRoomReceiver$1 implements b {
    TalkRoomReceiver$1() {
    }

    public final void prepare() {
        TalkRoomReceiver.aB(ac.getContext());
    }

    public final void cancel() {
        TalkRoomReceiver.aC(ac.getContext());
    }
}
