package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.ag.d;
import java.lang.ref.WeakReference;

class ag$d$1 implements Runnable {
    final /* synthetic */ r yFU;

    ag$d$1(r rVar) {
        this.yFU = rVar;
    }

    public final void run() {
        WeakReference weakReference = (WeakReference) d.agr().get(this.yFU.getFileName());
        if (weakReference == null) {
            x.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", this.yFU.getFileName());
            return;
        }
        d dVar = (d) weakReference.get();
        if (dVar == null) {
            x.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", this.yFU.getFileName());
            return;
        }
        dVar.yIT.setVisibility(8);
        dVar.rkR.setVisibility(8);
        dVar.yNv.setVisibility(0);
        int i = this.yFU.status;
        x.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : " + i);
        if (i == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || i == 122 || i == 120) {
            dVar.yNv.setProgress(t.f(this.yFU));
        } else {
            dVar.yNv.setProgress(t.g(this.yFU));
        }
    }
}
