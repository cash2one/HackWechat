package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMViewPager.b;

class ImageGalleryUI$18 implements b {
    final /* synthetic */ View vcl;
    final /* synthetic */ ImageGalleryUI yFy;

    ImageGalleryUI$18(ImageGalleryUI imageGalleryUI, View view) {
        this.yFy = imageGalleryUI;
        this.vcl = view;
    }

    public final void E(float f, float f2) {
        float f3 = 1.0f;
        float height = 1.0f - (f2 / ((float) this.yFy.mTN.getHeight()));
        if (height <= 1.0f) {
            f3 = height;
        }
        ImageGalleryUI.a(this.yFy, f3);
        if (this.vcl != null) {
            if (f == 0.0f && f2 == 0.0f) {
                ImageGalleryUI.r(this.yFy);
            } else {
                ImageGalleryUI.m(this.yFy);
            }
            this.vcl.setPivotX((float) (this.yFy.mTN.getWidth() / 2));
            this.vcl.setPivotY((float) (this.yFy.mTN.getHeight() / 2));
            this.vcl.setScaleX(f3);
            this.vcl.setScaleY(f3);
            this.vcl.setTranslationX(f);
            this.vcl.setTranslationY(f2);
            ImageGalleryUI.o(this.yFy).setAlpha(f3);
            return;
        }
        x.d("MicroMsg.ImageGalleryUI", "runDragAnimation contentView is null !!");
    }

    public final void F(float f, float f2) {
        ImageGalleryUI.c(this.yFy, (int) f);
        ImageGalleryUI.d(this.yFy, (int) f2);
    }
}
