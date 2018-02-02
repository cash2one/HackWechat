package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.g.a.ak;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.widget.g.a;

class ImageGalleryUI$3 implements a {
    final /* synthetic */ ImageGalleryUI yFy;

    ImageGalleryUI$3(ImageGalleryUI imageGalleryUI) {
        this.yFy = imageGalleryUI;
    }

    public final void onDismiss() {
        b akVar = new ak();
        akVar.fow.filePath = ImageGalleryUI.b(this.yFy);
        com.tencent.mm.sdk.b.a.xef.m(akVar);
        ImageGalleryUI.u(this.yFy);
        ImageGalleryUI.e(this.yFy);
        ImageGalleryUI.a(this.yFy, null);
        ImageGalleryUI.a(this.yFy, ImageGalleryUI.b(this.yFy, 0));
    }
}
