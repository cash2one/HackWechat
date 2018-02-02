package com.tencent.mm.plugin.favorite.ui.base;

import com.tencent.mm.sdk.platformtools.x;

class FavVideoView$4 implements Runnable {
    final /* synthetic */ int hBA;
    final /* synthetic */ int htd;
    final /* synthetic */ FavVideoView mvJ;

    FavVideoView$4(FavVideoView favVideoView, int i, int i2) {
        this.mvJ = favVideoView;
        this.htd = i;
        this.hBA = i2;
    }

    public final void run() {
        if (!(FavVideoView.d(this.mvJ) == null || FavVideoView.d(this.mvJ).getVisibility() == 8)) {
            FavVideoView.d(this.mvJ).setVisibility(8);
        }
        if (FavVideoView.e(this.mvJ) != null) {
            if (FavVideoView.e(this.mvJ).getVisibility() != 0) {
                FavVideoView.e(this.mvJ).setVisibility(0);
            }
            x.i("MicroMsg.FavVideoView", "download video update progress offset:%d  total: %d", new Object[]{Integer.valueOf(this.htd), Integer.valueOf(this.hBA)});
            if (FavVideoView.e(this.mvJ).zua != this.hBA && this.hBA > 0) {
                FavVideoView.e(this.mvJ).setMax(this.hBA);
            }
            FavVideoView.e(this.mvJ).setProgress(this.htd);
        }
    }
}
