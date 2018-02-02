package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.g.b;

class ImageGalleryUI$19 implements b {
    final /* synthetic */ ImageGalleryUI yFy;

    ImageGalleryUI$19(ImageGalleryUI imageGalleryUI) {
        this.yFy = imageGalleryUI;
    }

    public final void onAnimationStart() {
        ImageGalleryUI.a(this.yFy, true);
        ImageGalleryUI.dr(ImageGalleryUI.s(this.yFy));
        ImageGalleryUI.dr(ImageGalleryUI.t(this.yFy));
        new af().postDelayed(new 1(this), 20);
    }

    public final void onAnimationEnd() {
        x.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
        ImageGalleryUI.p(this.yFy).post(new 2(this));
        ImageGalleryUI.a(this.yFy, false);
    }
}
