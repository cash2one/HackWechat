package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$4 implements d {
    final /* synthetic */ VideoSegmentUI ozX;

    VideoSegmentUI$4(VideoSegmentUI videoSegmentUI) {
        this.ozX = videoSegmentUI;
    }

    public final void Q(int i, int i2, int i3) {
        if (i <= 0 || i2 <= 0) {
            x.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoSegmentUI.q(this.ozX))});
        } else if (VideoSegmentUI.q(this.ozX)) {
            x.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
        } else {
            x.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            VideoSegmentUI.r(this.ozX);
            if (i2 <= 0 || i <= 0) {
                x.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                VideoSegmentUI.m(this.ozX);
                this.ozX.finish();
                VideoSegmentUI.b(this.ozX);
                return;
            }
            Runnable videoSegmentUI$a = new VideoSegmentUI$a(this.ozX, VideoSegmentUI.s(this.ozX), i2, i, i3, new b(this.ozX, (byte) 0));
            if (VideoSegmentUI.s(this.ozX).getWidth() <= 0 || VideoSegmentUI.s(this.ozX).getHeight() <= 0) {
                x.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
                VideoSegmentUI.s(this.ozX).post(videoSegmentUI$a);
                return;
            }
            videoSegmentUI$a.run();
        }
    }
}
