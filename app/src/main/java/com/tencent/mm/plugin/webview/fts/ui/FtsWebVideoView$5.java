package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FtsWebVideoView$5 implements OnClickListener {
    final /* synthetic */ FtsWebVideoView trm;

    FtsWebVideoView$5(FtsWebVideoView ftsWebVideoView) {
        this.trm = ftsWebVideoView;
    }

    public final void onClick(View view) {
        if (FtsWebVideoView.d(this.trm).isPlaying()) {
            FtsWebVideoView.c(this.trm).bQq();
            this.trm.pause();
            return;
        }
        FtsWebVideoView.c(this.trm).bQr();
        this.trm.kk(true);
    }
}
