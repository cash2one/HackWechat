package com.tencent.mm.plugin.sns.ui;

class OfflineVideoView$2 implements Runnable {
    final /* synthetic */ String mvK;
    final /* synthetic */ OfflineVideoView ruP;

    OfflineVideoView$2(OfflineVideoView offlineVideoView, String str) {
        this.ruP = offlineVideoView;
        this.mvK = str;
    }

    public final void run() {
        this.ruP.Au(this.mvK);
    }
}
