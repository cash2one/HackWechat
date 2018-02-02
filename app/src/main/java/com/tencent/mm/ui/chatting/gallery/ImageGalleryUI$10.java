package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ImageGalleryUI$10 implements AnimationListener {
    final /* synthetic */ ImageGalleryUI yFy;

    ImageGalleryUI$10(ImageGalleryUI imageGalleryUI) {
        this.yFy = imageGalleryUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (ImageGalleryUI.G(ImageGalleryUI.F(this.yFy)).getVisibility() == 0) {
            this.yFy.cuS();
            ImageGalleryUI.H(ImageGalleryUI.F(this.yFy)).setVisibility(8);
            ImageGalleryUI.A(this.yFy);
            ImageGalleryUI.B(this.yFy);
        }
    }
}
