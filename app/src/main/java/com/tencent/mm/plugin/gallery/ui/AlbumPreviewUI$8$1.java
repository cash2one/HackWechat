package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.8;

class AlbumPreviewUI$8$1 implements Runnable {
    final /* synthetic */ 8 mSW;

    AlbumPreviewUI$8$1(8 8) {
        this.mSW = 8;
    }

    public final void run() {
        AlbumPreviewUI.G(this.mSW.mSQ).startAnimation(AnimationUtils.loadAnimation(this.mSW.mSQ.mController.xIM, R.a.bqa));
        AlbumPreviewUI.G(this.mSW.mSQ).setVisibility(8);
    }
}
