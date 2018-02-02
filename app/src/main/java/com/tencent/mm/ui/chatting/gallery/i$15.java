package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.ak.a;

class i$15 implements a {
    final /* synthetic */ i yFV;

    i$15(i iVar) {
        this.yFV = iVar;
    }

    public final boolean uF() {
        if (!i.f(this.yFV).isStreaming()) {
            return false;
        }
        j cuz = this.yFV.yCR.cuz();
        if (cuz == null || cuz.yGi == null || cuz.cvl().yGi.getVisibility() != 0) {
            return false;
        }
        boolean z = true;
        if (cuz.cvl().yGl.isPlaying()) {
            z = i.b(this.yFV, cuz);
        }
        if (!z) {
            return false;
        }
        return i.f(this.yFV).iH(cuz.cvl().yGl.getCurrentPosition() / 1000);
    }
}
