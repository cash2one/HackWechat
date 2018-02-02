package com.tencent.mm.plugin.sight.decode.ui;

class SnsAdNativeLandingPagesVideoPlayerLoadingBar$2 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingPagesVideoPlayerLoadingBar quW;
    final /* synthetic */ int quX;

    SnsAdNativeLandingPagesVideoPlayerLoadingBar$2(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar, int i) {
        this.quW = snsAdNativeLandingPagesVideoPlayerLoadingBar;
        this.quX = i;
    }

    public final void run() {
        this.quW.wl(this.quX);
    }
}
