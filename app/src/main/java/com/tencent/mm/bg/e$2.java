package com.tencent.mm.bg;

import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class e$2 extends af {
    final /* synthetic */ e hYx;

    e$2(e eVar) {
        this.hYx = eVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 2) {
            if (this.hYx.hYt != null) {
                this.hYx.hYt.UT();
            }
        } else if (message.what == 0) {
            if (e.b(this.hYx) == 0) {
                x.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
                g.CG().a(349, this.hYx);
            } else {
                g.CG().a(b.CTRL_INDEX, this.hYx);
            }
            if (e.b(this.hYx) != 0) {
                e.a(this.hYx, new c(e.d(this.hYx), e.b(this.hYx)));
            } else if (e.c(this.hYx)) {
                e.a(this.hYx, new d(e.d(this.hYx), 1));
            } else {
                e.a(this.hYx, new d(e.d(this.hYx), 0));
            }
            g.CG().a(e.e(this.hYx), 0);
        } else if (message.what == 3 && this.hYx.hYt != null) {
            this.hYx.hYt.a(new String[0], -1);
        }
    }
}
