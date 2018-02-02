package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.c.b;

class VideoSegmentUI$2 implements b {
    final /* synthetic */ VideoSegmentUI ozX;

    VideoSegmentUI$2(VideoSegmentUI videoSegmentUI) {
        this.ozX = videoSegmentUI;
    }

    public final void A(float f, float f2) {
        if (VideoSegmentUI.d(this.ozX) != null) {
            int e = VideoSegmentUI.e(this.ozX);
            VideoSegmentUI.d(this.ozX).setLoop((int) (((float) e) * f), (int) (((float) e) * f2));
            VideoSegmentUI.d(this.ozX).seekTo((int) (((float) e) * f));
        }
    }

    public final void bbb() {
        if (VideoSegmentUI.d(this.ozX) != null) {
            VideoSegmentUI.d(this.ozX).pause();
        }
    }

    public final void B(float f, float f2) {
        if (VideoSegmentUI.d(this.ozX) != null) {
            int e = (int) (((float) VideoSegmentUI.e(this.ozX)) * f);
            VideoSegmentUI.d(this.ozX).setLoop(e, (int) (((float) VideoSegmentUI.e(this.ozX)) * f2));
            VideoSegmentUI.d(this.ozX).seekTo(e);
        }
    }

    public final void C(float f, float f2) {
        if ((f2 - f) * ((float) VideoSegmentUI.e(this.ozX)) <= ((float) VideoSegmentUI.p(this.ozX))) {
            this.ozX.enableOptionMenu(true);
        } else {
            this.ozX.enableOptionMenu(false);
        }
    }
}
