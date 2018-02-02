package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.R;

class VideoActivity$9 implements Runnable {
    final /* synthetic */ VideoActivity spY;

    VideoActivity$9(VideoActivity videoActivity) {
        this.spY = videoActivity;
    }

    public final void run() {
        if (VideoActivity.d(this.spY) != null) {
            VideoActivity.d(this.spY).co(this.spY.getString(R.l.eVK), -1);
        }
        VideoActivity.e(this.spY);
    }
}
