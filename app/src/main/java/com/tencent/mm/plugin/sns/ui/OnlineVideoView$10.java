package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$10 implements Runnable {
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$10(OnlineVideoView onlineVideoView) {
        this.rvm = onlineVideoView;
    }

    public final void run() {
        if (OnlineVideoView.d(this.rvm) == null) {
            return;
        }
        if (bh.ov(OnlineVideoView.d(this.rvm).Ur())) {
            x.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[]{Integer.valueOf(this.rvm.hashCode())});
            String a = ap.a(OnlineVideoView.a(this.rvm), OnlineVideoView.e(this.rvm));
            if (!bh.ov(a)) {
                this.rvm.aI(a, false);
            }
        } else if (!OnlineVideoView.d(this.rvm).isPlaying()) {
            OnlineVideoView.d(this.rvm).start();
        }
    }
}
