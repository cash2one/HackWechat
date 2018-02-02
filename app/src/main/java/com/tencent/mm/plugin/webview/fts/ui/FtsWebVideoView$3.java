package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FtsWebVideoView$3 implements OnClickListener {
    final /* synthetic */ FtsWebVideoView trm;

    FtsWebVideoView$3(FtsWebVideoView ftsWebVideoView) {
        this.trm = ftsWebVideoView;
    }

    public final void onClick(View view) {
        FtsWebVideoView.v(this.trm);
        FtsWebVideoView.c(this.trm).bQr();
    }
}
