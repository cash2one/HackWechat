package com.tencent.mm.plugin.mmsight.segment;

import android.view.View;
import com.tencent.mm.plugin.mmsight.segment.a.c.a;

class VideoSegmentUI$3 implements a {
    final /* synthetic */ VideoSegmentUI ozX;
    private Runnable ozY;

    VideoSegmentUI$3(VideoSegmentUI videoSegmentUI) {
        this.ozX = videoSegmentUI;
    }

    public final void sX(int i) {
        if (VideoSegmentUI.j(this.ozX) != null) {
            if (this.ozY != null) {
                ((View) VideoSegmentUI.j(this.ozX)).removeCallbacks(this.ozY);
            }
            this.ozY = new VideoSegmentUI$c(VideoSegmentUI.j(this.ozX), i, VideoSegmentUI.e(this.ozX));
            ((View) VideoSegmentUI.j(this.ozX)).post(this.ozY);
        }
    }
}
