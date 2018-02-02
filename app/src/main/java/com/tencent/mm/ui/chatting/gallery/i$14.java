package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class i$14 implements Runnable {
    final /* synthetic */ i yFV;

    i$14(i iVar) {
        this.yFV = iVar;
    }

    public final void run() {
        try {
            int y;
            if (bh.ov(this.yFV.yCR.cuz().cvl().yGl.Ur())) {
                y = t.y(i.f(this.yFV).hTA, i.a(this.yFV));
            } else {
                y = this.yFV.yCR.cuz().cvl().yGl.getCurrentPosition() / 1000;
            }
            i.f(this.yFV).iH(y);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "start timer error[%s]", e.toString());
        }
        i.m(this.yFV).J(500, 500);
    }
}
