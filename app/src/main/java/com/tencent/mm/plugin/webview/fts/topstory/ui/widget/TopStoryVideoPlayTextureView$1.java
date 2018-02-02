package com.tencent.mm.plugin.webview.fts.topstory.ui.widget;

class TopStoryVideoPlayTextureView$1 implements Runnable {
    final /* synthetic */ TopStoryVideoPlayTextureView tqy;

    TopStoryVideoPlayTextureView$1(TopStoryVideoPlayTextureView topStoryVideoPlayTextureView) {
        this.tqy = topStoryVideoPlayTextureView;
    }

    public final void run() {
        synchronized (TopStoryVideoPlayTextureView.a(this.tqy)) {
            TopStoryVideoPlayTextureView.b(this.tqy);
        }
    }
}
