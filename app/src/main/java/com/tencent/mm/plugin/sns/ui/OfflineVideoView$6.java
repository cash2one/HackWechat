package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class OfflineVideoView$6 implements Runnable {
    final /* synthetic */ OfflineVideoView ruP;

    OfflineVideoView$6(OfflineVideoView offlineVideoView) {
        this.ruP = offlineVideoView;
    }

    public final void run() {
        if (OfflineVideoView.d(this.ruP) != null && OfflineVideoView.d(this.ruP).getVisibility() != 8) {
            x.i("MicroMsg.OfflineVideoView", "%d hide loading.", new Object[]{Integer.valueOf(this.ruP.hashCode())});
            OfflineVideoView.d(this.ruP).setVisibility(8);
        }
    }
}
