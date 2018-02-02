package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;

class y$11 implements Runnable {
    final /* synthetic */ y rlv;

    y$11(y yVar) {
        this.rlv = yVar;
    }

    public final void run() {
        OfflineVideoView offlineVideoView = this.rlv.rkN;
        boolean isPlaying = offlineVideoView.kTe instanceof VideoPlayerTextureView ? ((VideoPlayerTextureView) offlineVideoView.kTe).ccI() && offlineVideoView.isPlaying() : offlineVideoView.isPlaying();
        if (isPlaying) {
            this.rlv.rkN.akP();
            return;
        }
        this.rlv.rkO.db(true);
        this.rlv.rkN.bzI();
    }
}
