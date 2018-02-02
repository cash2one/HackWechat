package com.tencent.mm.plugin.sight.decode.ui;

import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.1;
import com.tencent.mm.sdk.platformtools.x;

class VideoPlayView$1$1 implements Runnable {
    final /* synthetic */ int jup;
    final /* synthetic */ int qvu;
    final /* synthetic */ 1 qvv;

    VideoPlayView$1$1(1 1, int i, int i2) {
        this.qvv = 1;
        this.jup = i;
        this.qvu = i2;
    }

    public final void run() {
        x.i("MicroMsg.VideoPlayView", "play time " + this.jup + " video time " + this.qvu);
        if (this.qvu > 0) {
            VideoPlayView.b(this.qvv.qvt, this.qvu);
            if (VideoPlayView.c(this.qvv.qvt) != null && VideoPlayView.h(this.qvv.qvt)) {
                VideoPlayView.i(this.qvv.qvt);
            }
            VideoPlayView.f(this.qvv.qvt).wn(this.qvu);
        }
        if (VideoPlayView.c(this.qvv.qvt) != null) {
            if (VideoPlayView.c(this.qvv.qvt).bsW() != this.qvu) {
                VideoPlayView.c(this.qvv.qvt).wl(this.qvu);
            }
            VideoPlayView.c(this.qvv.qvt).seek(this.jup);
            VideoPlayView.c(this.qvv.qvt).db(true);
        }
        if (VideoPlayView.j(this.qvv.qvt).getVisibility() == 0) {
            VideoPlayView.j(this.qvv.qvt).setVisibility(8);
        }
        VideoPlayView.a(this.qvv.qvt, (double) this.jup);
    }
}
