package com.tencent.mm.plugin.mmsight.segment;

import android.view.View;
import com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.d;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$d$1 implements Runnable {
    final /* synthetic */ d oAi;

    VideoSegmentUI$d$1(d dVar) {
        this.oAi = dVar;
    }

    public final void run() {
        if (VideoSegmentUI.t(this.oAi.ozX) || this.oAi.ozX.isFinishing() || VideoSegmentUI.j(this.oAi.ozX) == null || VideoSegmentUI.d(this.oAi.ozX) == null) {
            x.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
            return;
        }
        ((View) VideoSegmentUI.j(this.oAi.ozX)).setAlpha(0.0f);
        ((View) VideoSegmentUI.j(this.oAi.ozX)).setVisibility(0);
        ((View) VideoSegmentUI.j(this.oAi.ozX)).animate().setDuration(300).setStartDelay(200).alpha(1.0f);
        float baZ = VideoSegmentUI.j(this.oAi.ozX).baZ();
        float bba = VideoSegmentUI.j(this.oAi.ozX).bba();
        if ((bba - baZ) * ((float) VideoSegmentUI.e(this.oAi.ozX)) <= ((float) VideoSegmentUI.p(this.oAi.ozX))) {
            this.oAi.ozX.enableOptionMenu(true);
        }
        VideoSegmentUI.d(this.oAi.ozX).setLoop((int) (baZ * ((float) VideoSegmentUI.e(this.oAi.ozX))), (int) (bba * ((float) VideoSegmentUI.e(this.oAi.ozX))));
    }
}
