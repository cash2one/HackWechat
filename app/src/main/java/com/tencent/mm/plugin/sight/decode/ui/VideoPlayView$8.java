package com.tencent.mm.plugin.sight.decode.ui;

class VideoPlayView$8 implements Runnable {
    final /* synthetic */ VideoPlayView qvt;

    VideoPlayView$8(VideoPlayView videoPlayView) {
        this.qvt = videoPlayView;
    }

    public final void run() {
        if (!VideoPlayView.a(this.qvt).isPlaying()) {
            ((AdVideoPlayerLoadingBar) VideoPlayView.c(this.qvt)).ahe();
        }
    }
}
