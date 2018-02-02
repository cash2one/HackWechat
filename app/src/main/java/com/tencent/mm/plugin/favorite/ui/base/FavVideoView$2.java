package com.tencent.mm.plugin.favorite.ui.base;

class FavVideoView$2 implements Runnable {
    final /* synthetic */ FavVideoView mvJ;

    FavVideoView$2(FavVideoView favVideoView) {
        this.mvJ = favVideoView;
    }

    public final void run() {
        if (FavVideoView.a(this.mvJ) != null) {
            this.mvJ.Au(FavVideoView.c(this.mvJ));
        }
    }
}
