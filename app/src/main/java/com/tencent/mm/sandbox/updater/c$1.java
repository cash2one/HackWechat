package com.tencent.mm.sandbox.updater;

import android.os.Message;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$1 extends af {
    final /* synthetic */ c xcI;

    c$1(c cVar) {
        this.xcI = cVar;
    }

    public final void handleMessage(Message message) {
        if (1 == message.what && !c.a(this.xcI)) {
            new File(this.xcI.baW()).delete();
            if (message.arg1 == 0) {
                x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
                c.b(this.xcI).a(200, 0, (bdf) message.obj);
            } else if (message.arg1 == 3) {
                c.b(this.xcI).a(3, -1, (bdf) message.obj);
            } else if (message.arg1 == 4) {
                c.b(this.xcI).a(4, -1, (bdf) message.obj);
            }
        }
        super.handleMessage(message);
    }
}
