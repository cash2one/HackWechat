package com.tencent.mm.ui.chatting.gallery;

class ImageGalleryGridUI$3 implements Runnable {
    final /* synthetic */ ImageGalleryGridUI yEd;

    ImageGalleryGridUI$3(ImageGalleryGridUI imageGalleryGridUI) {
        this.yEd = imageGalleryGridUI;
    }

    public final void run() {
        if (ImageGalleryGridUI.a(this.yEd) != null && ImageGalleryGridUI.a(this.yEd).getVisibility() != 0) {
            ImageGalleryGridUI.a(this.yEd).setVisibility(0);
        }
    }
}
