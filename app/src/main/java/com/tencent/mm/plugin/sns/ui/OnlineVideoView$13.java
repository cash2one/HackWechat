package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$13 implements Runnable {
    final /* synthetic */ OnlineVideoView rvm;

    OnlineVideoView$13(OnlineVideoView onlineVideoView) {
        this.rvm = onlineVideoView;
    }

    public final void run() {
        x.i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", new Object[]{Integer.valueOf(this.rvm.hashCode()), Integer.valueOf(OnlineVideoView.j(this.rvm))});
        if (OnlineVideoView.j(this.rvm) == 1) {
            if (!(OnlineVideoView.h(this.rvm) == null || OnlineVideoView.h(this.rvm).getVisibility() == 0)) {
                OnlineVideoView.h(this.rvm).setVisibility(0);
            }
            if (!(OnlineVideoView.i(this.rvm) == null || OnlineVideoView.i(this.rvm).getVisibility() == 8)) {
                OnlineVideoView.i(this.rvm).setVisibility(8);
            }
        }
        if (OnlineVideoView.j(this.rvm) == 2) {
            if (!(OnlineVideoView.i(this.rvm) == null || OnlineVideoView.i(this.rvm).getVisibility() == 0)) {
                OnlineVideoView.i(this.rvm).setVisibility(0);
            }
            if (!(OnlineVideoView.h(this.rvm) == null || OnlineVideoView.h(this.rvm).getVisibility() == 8)) {
                OnlineVideoView.h(this.rvm).setVisibility(8);
            }
        }
        if (OnlineVideoView.j(this.rvm) == 3) {
            if (!(OnlineVideoView.i(this.rvm) == null || OnlineVideoView.i(this.rvm).getVisibility() == 0)) {
                OnlineVideoView.i(this.rvm).setVisibility(0);
                OnlineVideoView.i(this.rvm).cyN();
            }
            if (OnlineVideoView.h(this.rvm) != null && OnlineVideoView.h(this.rvm).getVisibility() != 8) {
                OnlineVideoView.h(this.rvm).setVisibility(8);
            }
        }
    }
}
