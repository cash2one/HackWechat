package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.t;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.gallery.ui.f.1;
import com.tencent.mm.sdk.platformtools.x;

class f$1$1 implements AnimationListener {
    final /* synthetic */ int mUG;
    final /* synthetic */ t mUH;
    final /* synthetic */ 1 mUI;

    f$1$1(1 1, int i, t tVar) {
        this.mUI = 1;
        this.mUG = i;
        this.mUH = tVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.mUG == 2) {
            f.b(this.mUI.mUF, f.a(this.mUI.mUF, this.mUH.ge()));
            this.mUI.fJA = f.c(this.mUI.mUF);
            x.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", new Object[]{Integer.valueOf(this.mUI.fJA)});
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
