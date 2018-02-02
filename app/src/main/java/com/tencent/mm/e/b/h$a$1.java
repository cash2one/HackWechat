package com.tencent.mm.e.b;

import android.os.Message;
import com.tencent.mm.e.b.h.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class h$a$1 extends af {
    final /* synthetic */ h flL;
    final /* synthetic */ a flM;

    h$a$1(a aVar, h hVar) {
        this.flM = aVar;
        this.flL = hVar;
    }

    public final void handleMessage(Message message) {
        if (this.flM.flK.flE > 0) {
            x.d("MicroMsg.SceneVoice.Recorder", "On Part :" + (this.flM.flK.flG == null));
            this.flM.flK.flE = 2;
            if (this.flM.flK.flG != null) {
                this.flM.flK.flG.Ka();
            }
        }
    }
}
