package com.tencent.mm.plugin.voip.ui;

class VideoActivity$7 implements Runnable {
    final /* synthetic */ int kvg;
    final /* synthetic */ VideoActivity spY;

    VideoActivity$7(VideoActivity videoActivity, int i) {
        this.spY = videoActivity;
        this.kvg = i;
    }

    public final void run() {
        VideoActivity.a(this.spY, this.kvg);
    }
}
