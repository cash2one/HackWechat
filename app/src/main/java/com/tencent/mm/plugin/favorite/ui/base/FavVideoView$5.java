package com.tencent.mm.plugin.favorite.ui.base;

class FavVideoView$5 implements Runnable {
    final /* synthetic */ FavVideoView mvJ;

    public FavVideoView$5(FavVideoView favVideoView) {
        this.mvJ = favVideoView;
    }

    public final void run() {
        if (!(FavVideoView.d(this.mvJ) == null || FavVideoView.d(this.mvJ).getVisibility() == 0)) {
            FavVideoView.d(this.mvJ).setVisibility(0);
        }
        if (FavVideoView.e(this.mvJ) != null && FavVideoView.e(this.mvJ).getVisibility() != 8) {
            FavVideoView.e(this.mvJ).setVisibility(8);
        }
    }
}
