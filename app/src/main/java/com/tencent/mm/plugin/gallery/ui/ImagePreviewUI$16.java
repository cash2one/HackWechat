package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;

class ImagePreviewUI$16 implements Runnable {
    final /* synthetic */ ImagePreviewUI mUl;
    final /* synthetic */ MediaItem mUo;

    ImagePreviewUI$16(ImagePreviewUI imagePreviewUI, MediaItem mediaItem) {
        this.mUl = imagePreviewUI;
        this.mUo = mediaItem;
    }

    public final void run() {
        ImagePreviewUI.a(this.mUl, this.mUo);
    }
}
