package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$12 implements Runnable {
    final /* synthetic */ int hBA;
    final /* synthetic */ int htd;
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$12(OnlineVideoView onlineVideoView, int i, int i2) {
        this.rvm = onlineVideoView;
        this.htd = i;
        this.hBA = i2;
    }

    public final void run() {
        if (!(OnlineVideoView.h(this.rvm) == null || OnlineVideoView.h(this.rvm).getVisibility() == 8)) {
            OnlineVideoView.h(this.rvm).setVisibility(8);
        }
        if (OnlineVideoView.i(this.rvm) != null) {
            if (OnlineVideoView.i(this.rvm).getVisibility() != 0) {
                OnlineVideoView.i(this.rvm).setVisibility(0);
            }
            x.i("MicroMsg.OnlineVideoView", "%d update progress %d %d", new Object[]{Integer.valueOf(this.rvm.hashCode()), Integer.valueOf(this.htd), Integer.valueOf(this.hBA)});
            if (OnlineVideoView.i(this.rvm).zua != this.hBA && this.hBA > 0) {
                OnlineVideoView.i(this.rvm).setMax(this.hBA);
            }
            OnlineVideoView.i(this.rvm).setProgress(this.htd);
        }
    }
}
