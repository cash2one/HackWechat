package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ImageGalleryUI$9 implements AnimationListener {
    final /* synthetic */ ImageGalleryUI yFy;

    ImageGalleryUI$9(ImageGalleryUI imageGalleryUI) {
        this.yFy = imageGalleryUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ImageGalleryUI.D(this.yFy);
        ImageGalleryUI.E(this.yFy);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
