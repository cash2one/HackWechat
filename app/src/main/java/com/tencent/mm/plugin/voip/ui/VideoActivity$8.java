package com.tencent.mm.plugin.voip.ui;

class VideoActivity$8 implements Runnable {
    final /* synthetic */ VideoActivity spY;
    final /* synthetic */ String sqa;

    VideoActivity$8(VideoActivity videoActivity, String str) {
        this.spY = videoActivity;
        this.sqa = str;
    }

    public final void run() {
        if (VideoActivity.d(this.spY) != null) {
            VideoActivity.d(this.spY).MD(this.sqa);
        }
    }
}
