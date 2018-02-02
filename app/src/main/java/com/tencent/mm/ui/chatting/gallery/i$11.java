package com.tencent.mm.ui.chatting.gallery;

import android.os.Message;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.af.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class i$11 implements a {
    final /* synthetic */ i yFV;

    i$11(i iVar) {
        this.yFV = iVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            j cuz = this.yFV.yCR.cuz();
            if (!(cuz == null || bh.ov(i.a(this.yFV)))) {
                x.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", Integer.valueOf(hashCode()), i.a(this.yFV));
                if (!i.b(this.yFV)) {
                    t.d(i.a(this.yFV), cuz.cvl().yGl.getCurrentPosition(), i.c(this.yFV));
                }
                i.a(this.yFV, cuz);
                i.d(this.yFV).bx(false);
                if (i.c(this.yFV)) {
                    com.tencent.mm.sdk.b.a.xef.c(i.e(this.yFV));
                    i.f(this.yFV).cvn();
                    i.a(this.yFV, false);
                }
            }
            i.g(this.yFV);
        }
        return false;
    }
}
