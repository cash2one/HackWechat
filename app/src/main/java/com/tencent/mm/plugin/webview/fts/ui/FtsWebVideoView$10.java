package com.tencent.mm.plugin.webview.fts.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class FtsWebVideoView$10 extends BroadcastReceiver {
    final /* synthetic */ FtsWebVideoView trm;

    FtsWebVideoView$10(FtsWebVideoView ftsWebVideoView) {
        this.trm = ftsWebVideoView;
    }

    public final void onReceive(Context context, Intent intent) {
        if (FtsWebVideoView.d(this.trm).isPlaying()) {
            FtsWebVideoView.a(this.trm, context);
        }
    }
}
