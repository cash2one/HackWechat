package com.tencent.mm.modelvoice;

import com.tencent.mm.modelvoice.RemoteController.RemoteControlReceiver;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class RemoteController$RemoteControlReceiver$1 implements a {
    final /* synthetic */ RemoteControlReceiver hWK;

    RemoteController$RemoteControlReceiver$1(RemoteControlReceiver remoteControlReceiver) {
        this.hWK = remoteControlReceiver;
    }

    public final boolean uF() {
        x.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
        RemoteControlReceiver.Uw();
        return false;
    }
}
