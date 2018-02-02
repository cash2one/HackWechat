package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ImageFolderMgrView$1 implements AnimationListener {
    final /* synthetic */ ImageFolderMgrView mTz;

    ImageFolderMgrView$1(ImageFolderMgrView imageFolderMgrView) {
        this.mTz = imageFolderMgrView;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ImageFolderMgrView.a(this.mTz).setVisibility(8);
        ImageFolderMgrView.a(this.mTz, false);
        ImageFolderMgrView.b(this.mTz);
    }
}
