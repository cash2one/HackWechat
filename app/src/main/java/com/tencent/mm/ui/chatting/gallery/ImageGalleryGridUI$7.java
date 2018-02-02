package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.os.Build.VERSION;
import android.view.View;

class ImageGalleryGridUI$7 implements Runnable {
    final /* synthetic */ ImageGalleryGridUI yEd;
    final /* synthetic */ View yEg;
    final /* synthetic */ TimeInterpolator yEh;

    ImageGalleryGridUI$7(ImageGalleryGridUI imageGalleryGridUI, View view, TimeInterpolator timeInterpolator) {
        this.yEd = imageGalleryGridUI;
        this.yEg = view;
        this.yEh = timeInterpolator;
    }

    public final void run() {
        if (VERSION.SDK_INT >= 16) {
            this.yEg.animate().setDuration(500).alpha(0.0f).withEndAction(this.yEd.yDV).withLayer().setInterpolator(this.yEh);
        } else if (this.yEd.handler != null) {
            this.yEg.animate().setDuration(500).alpha(0.0f).setInterpolator(this.yEh);
            this.yEd.handler.postDelayed(this.yEd.yDV, 500);
        }
    }
}
