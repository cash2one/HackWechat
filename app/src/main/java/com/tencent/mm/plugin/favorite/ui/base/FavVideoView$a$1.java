package com.tencent.mm.plugin.favorite.ui.base;

import com.tencent.mm.plugin.favorite.ui.base.FavVideoView.a;

class FavVideoView$a$1 implements Runnable {
    final /* synthetic */ a mvL;

    FavVideoView$a$1(a aVar) {
        this.mvL = aVar;
    }

    public final void run() {
        if (FavVideoView.a(this.mvL.mvJ) != null) {
            this.mvL.mvJ.Au(FavVideoView.c(this.mvL.mvJ));
        }
    }
}
