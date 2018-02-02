package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AlbumPreviewUI$8 implements AnimationListener {
    final /* synthetic */ AlbumPreviewUI mSQ;
    private Runnable mSV = new 1(this);

    AlbumPreviewUI$8(AlbumPreviewUI albumPreviewUI) {
        this.mSQ = albumPreviewUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        AlbumPreviewUI.G(this.mSQ).setVisibility(0);
        AlbumPreviewUI.G(this.mSQ).postDelayed(this.mSV, 4000);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
