package com.tencent.mm.pluginsdk.ui.tools;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FileSelectorFolderView$1 implements AnimationListener {
    final /* synthetic */ FileSelectorFolderView vwT;

    FileSelectorFolderView$1(FileSelectorFolderView fileSelectorFolderView) {
        this.vwT = fileSelectorFolderView;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        FileSelectorFolderView.a(this.vwT).setVisibility(8);
        FileSelectorFolderView.a(this.vwT, false);
        FileSelectorFolderView.b(this.vwT);
    }
}
