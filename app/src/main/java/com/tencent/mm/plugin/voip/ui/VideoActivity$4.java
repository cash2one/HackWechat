package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.b.b;

class VideoActivity$4 implements Runnable {
    final /* synthetic */ VideoActivity spY;

    VideoActivity$4(VideoActivity videoActivity) {
        this.spY = videoActivity;
    }

    public final void run() {
        if (b.yU(VideoActivity.b(this.spY)) && !VideoActivity.c(this.spY) && VideoActivity.d(this.spY) != null) {
            VideoActivity.d(this.spY).co(this.spY.getString(R.l.eUt), 10000);
        }
    }
}
