package com.tencent.mm.plugin.mmsight.segment;

import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.segment.k.f;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$12 implements c$a {
    final /* synthetic */ VideoSegmentUI ozX;

    VideoSegmentUI$12(VideoSegmentUI videoSegmentUI) {
        this.ozX = videoSegmentUI;
    }

    public final void gF(boolean z) {
        if (z) {
            Toast.makeText(this.ozX, f.oyv, 1).show();
            x.e("MicroMsg.VideoSegmentUI", "Not Supported init SegmentSeekBar failed.");
            VideoSegmentUI.m(this.ozX);
            this.ozX.finish();
            VideoSegmentUI.b(this.ozX);
            return;
        }
        if (!(this.ozX.isFinishing() || VideoSegmentUI.j(this.ozX) == null)) {
            VideoSegmentUI.a(this.ozX, VideoSegmentUI.j(this.ozX).getDurationMs());
            x.i("MicroMsg.VideoSegmentUI", "SeekBar.onPrepared success %d", new Object[]{Integer.valueOf(VideoSegmentUI.e(this.ozX))});
            try {
                if (VideoSegmentUI.d(this.ozX) != null) {
                    VideoSegmentUI.d(this.ozX).setLoop((int) (((float) VideoSegmentUI.e(this.ozX)) * VideoSegmentUI.j(this.ozX).baZ()), (int) (((float) VideoSegmentUI.e(this.ozX)) * VideoSegmentUI.j(this.ozX).bba()));
                }
            } catch (Exception e) {
            }
        }
        VideoSegmentUI.o(this.ozX).countDown();
    }
}
