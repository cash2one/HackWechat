package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.ui.chatting.gallery.j.4;

class j$4$1 implements Runnable {
    final /* synthetic */ 4 yGD;

    j$4$1(4 4) {
        this.yGD = 4;
    }

    public final void run() {
        this.yGD.yGA.yDo.yCS.mV(true);
        b bVar = this.yGD.yGA.yDo;
        bVar.yCY.Gg(this.yGD.yGA.mPosition);
        ImageGalleryUI.cuU();
        this.yGD.yGA.yDo.yCY.cvg();
    }
}
