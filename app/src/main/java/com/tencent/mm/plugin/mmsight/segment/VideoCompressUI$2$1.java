package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.VideoCompressUI.2;

class VideoCompressUI$2$1 implements Runnable {
    final /* synthetic */ 2 ozJ;

    VideoCompressUI$2$1(2 2) {
        this.ozJ = 2;
    }

    public final void run() {
        if (VideoCompressUI.f(this.ozJ.ozI) != null) {
            VideoCompressUI.f(this.ozJ.ozI).dismiss();
        }
    }
}
