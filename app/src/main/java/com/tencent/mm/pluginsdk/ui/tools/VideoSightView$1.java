package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;

class VideoSightView$1 implements e {
    final /* synthetic */ VideoSightView vyA;

    VideoSightView$1(VideoSightView videoSightView) {
        this.vyA = videoSightView;
    }

    public final void d(b bVar, int i) {
        if (-1 == i) {
            if (this.vyA.quG != null) {
                this.vyA.quG.onError(0, 0);
            }
        } else if (i == 0 && this.vyA.quG != null) {
            this.vyA.quG.vh();
        }
    }
}
