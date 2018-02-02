package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FtsWebVideoView$1 implements OnClickListener {
    final /* synthetic */ FtsWebVideoView trm;

    FtsWebVideoView$1(FtsWebVideoView ftsWebVideoView) {
        this.trm = ftsWebVideoView;
    }

    public final void onClick(View view) {
        this.trm.pause();
    }
}
