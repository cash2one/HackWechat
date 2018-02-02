package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.a.a.c;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$11 implements c {
    final /* synthetic */ VideoSegmentUI ozX;

    VideoSegmentUI$11(VideoSegmentUI videoSegmentUI) {
        this.ozX = videoSegmentUI;
    }

    public final void bz(Object obj) {
        try {
            if (VideoSegmentUI.d(this.ozX) != null) {
                VideoSegmentUI.d(this.ozX).start();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "hy: exception when onSeekComplete waiting for starting", new Object[0]);
        }
    }
}
