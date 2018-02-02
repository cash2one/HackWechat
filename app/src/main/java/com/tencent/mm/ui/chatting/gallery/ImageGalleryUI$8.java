package com.tencent.mm.ui.chatting.gallery;

class ImageGalleryUI$8 implements Runnable {
    final /* synthetic */ int hvX;
    final /* synthetic */ ImageGalleryUI yFy;

    ImageGalleryUI$8(ImageGalleryUI imageGalleryUI, int i) {
        this.yFy = imageGalleryUI;
        this.hvX = i;
    }

    public final void run() {
        if (ImageGalleryUI.f(this.yFy) != null) {
            b f = ImageGalleryUI.f(this.yFy);
            f.yCY.pause(this.hvX);
        }
    }
}
