package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.r;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class i$16 implements a {
    final /* synthetic */ i yFV;

    i$16(i iVar) {
        this.yFV = iVar;
    }

    public final boolean uF() {
        j cuz = this.yFV.yCR.cuz();
        if (cuz == null) {
            return false;
        }
        if (cuz.yGi == null) {
            return false;
        }
        if (cuz.cvl().yGi.getVisibility() != 0) {
            return false;
        }
        int cuT = this.yFV.yCR.yCS.cuT();
        if (((r) this.yFV.yFE.get(cuT)) == null) {
            this.yFV.Gg(cuT);
            return false;
        } else if (cuz.cvl().yGl.isPlaying()) {
            i.a(this.yFV, cuz.cvl().yGl.getCurrentPosition());
            this.yFV.Gh(i.n(this.yFV) / 1000);
            return true;
        } else {
            x.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
            return false;
        }
    }
}
