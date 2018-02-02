package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$10 implements b {
    final /* synthetic */ VideoSegmentUI ozX;

    VideoSegmentUI$10(VideoSegmentUI videoSegmentUI) {
        this.ozX = videoSegmentUI;
    }

    public final void by(Object obj) {
        x.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", new Object[]{obj});
        try {
            if (VideoSegmentUI.d(this.ozX) != null) {
                VideoSegmentUI.n(this.ozX);
                VideoSegmentUI.d(this.ozX).start();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "hy: exception when onPrepared waiting for starting", new Object[0]);
        }
    }
}
