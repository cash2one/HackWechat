package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$14 implements Runnable {
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$14(OnlineVideoView onlineVideoView) {
        this.rvm = onlineVideoView;
    }

    public final void run() {
        if (!(OnlineVideoView.h(this.rvm) == null || OnlineVideoView.h(this.rvm).getVisibility() == 8)) {
            x.i("MicroMsg.OnlineVideoView", "%d hide loading.", new Object[]{Integer.valueOf(this.rvm.hashCode())});
            OnlineVideoView.h(this.rvm).setVisibility(8);
        }
        if (OnlineVideoView.i(this.rvm) != null && OnlineVideoView.i(this.rvm).getVisibility() != 8) {
            x.i("MicroMsg.OnlineVideoView", "%d hide progress.", new Object[]{Integer.valueOf(this.rvm.hashCode())});
            OnlineVideoView.i(this.rvm).setVisibility(8);
        }
    }
}
