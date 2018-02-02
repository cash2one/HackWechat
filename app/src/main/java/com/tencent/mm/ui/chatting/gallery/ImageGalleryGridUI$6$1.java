package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.6;

class ImageGalleryGridUI$6$1 implements Runnable {
    final /* synthetic */ 6 yEf;

    ImageGalleryGridUI$6$1(6 6) {
        this.yEf = 6;
    }

    public final void run() {
        ImageGalleryGridUI.b(this.yEf.yEd).startAnimation(AnimationUtils.loadAnimation(this.yEf.yEd.mController.xIM, R.a.bqa));
        ImageGalleryGridUI.b(this.yEf.yEd).setVisibility(8);
    }
}
