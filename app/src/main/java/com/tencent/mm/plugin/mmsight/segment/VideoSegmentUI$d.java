package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

class VideoSegmentUI$d implements Runnable {
    final /* synthetic */ VideoSegmentUI ozX;

    private VideoSegmentUI$d(VideoSegmentUI videoSegmentUI) {
        this.ozX = videoSegmentUI;
    }

    public final void run() {
        boolean await;
        try {
            await = VideoSegmentUI.o(this.ozX).await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            x.e("MicroMsg.VideoSegmentUI", "count down latch error %s", new Object[]{e});
            await = false;
        }
        if (await) {
            try {
                if (!(VideoSegmentUI.t(this.ozX) || this.ozX.isFinishing() || VideoSegmentUI.u(this.ozX) == null || !VideoSegmentUI.u(this.ozX).isValid())) {
                    if (VideoSegmentUI.d(this.ozX) != null) {
                        VideoSegmentUI.d(this.ozX).a(null);
                        VideoSegmentUI.d(this.ozX).a(null);
                        VideoSegmentUI.d(this.ozX).release();
                        VideoSegmentUI.v(this.ozX);
                    }
                    try {
                        VideoSegmentUI.a(this.ozX, VideoSegmentUI.u(this.ozX));
                        VideoSegmentUI.d(this.ozX).setSurface(VideoSegmentUI.u(this.ozX));
                        ag.y(new 1(this));
                        return;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.VideoSegmentUI", e2, "init segmentPlayer second time %s", new Object[]{e2.getMessage()});
                        this.ozX.finish();
                        return;
                    }
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.VideoSegmentUI", e22, "Finished when init", new Object[0]);
                this.ozX.finish();
                return;
            }
        }
        String str = "MicroMsg.VideoSegmentUI";
        String str2 = "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(await);
        objArr[1] = Boolean.valueOf(VideoSegmentUI.t(this.ozX));
        objArr[2] = Boolean.valueOf(this.ozX.isFinishing());
        objArr[3] = Boolean.valueOf(VideoSegmentUI.u(this.ozX) == null);
        x.w(str, str2, objArr);
        this.ozX.finish();
    }
}
