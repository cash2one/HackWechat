package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;

class ImageGalleryGridUI$8 implements Runnable {
    final /* synthetic */ ImageGalleryGridUI yEd;

    ImageGalleryGridUI$8(ImageGalleryGridUI imageGalleryGridUI) {
        this.yEd = imageGalleryGridUI;
    }

    @TargetApi(12)
    public final void run() {
        if (this.yEd.yDW != null) {
            this.yEd.yDW.setVisibility(8);
            this.yEd.yDW = null;
        }
    }
}
