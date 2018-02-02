package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.4;

class AlbumPreviewUI$4$1 implements Runnable {
    final /* synthetic */ 4 mST;

    AlbumPreviewUI$4$1(4 4) {
        this.mST = 4;
    }

    public final void run() {
        AlbumPreviewUI.x(this.mST.mSQ).startAnimation(AnimationUtils.loadAnimation(this.mST.mSQ.mController.xIM, R.a.bqa));
        AlbumPreviewUI.x(this.mST.mSQ).setVisibility(8);
    }
}
