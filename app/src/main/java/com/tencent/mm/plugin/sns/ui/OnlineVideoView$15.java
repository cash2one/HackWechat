package com.tencent.mm.plugin.sns.ui;

class OnlineVideoView$15 implements Runnable {
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$15(OnlineVideoView onlineVideoView) {
        this.rvm = onlineVideoView;
    }

    public final void run() {
        if (!(OnlineVideoView.d(this.rvm) == null || OnlineVideoView.k(this.rvm) == null)) {
            OnlineVideoView.k(this.rvm).iH(OnlineVideoView.d(this.rvm).getCurrentPosition() / 1000);
        }
        OnlineVideoView.l(this.rvm).J(500, 500);
    }
}
