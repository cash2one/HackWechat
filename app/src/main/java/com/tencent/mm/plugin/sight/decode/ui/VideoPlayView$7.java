package com.tencent.mm.plugin.sight.decode.ui;

class VideoPlayView$7 implements Runnable {
    final /* synthetic */ VideoPlayView qvt;

    VideoPlayView$7(VideoPlayView videoPlayView) {
        this.qvt = videoPlayView;
    }

    public final void run() {
        if (VideoPlayView.c(this.qvt) != null) {
            VideoPlayView.c(this.qvt).db(false);
        }
    }
}
