package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.Gallery;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.b;

class SnsBrowseUI$6 implements b {
    final /* synthetic */ SnsBrowseUI rzl;
    final /* synthetic */ Gallery rzp;

    SnsBrowseUI$6(SnsBrowseUI snsBrowseUI, Gallery gallery) {
        this.rzl = snsBrowseUI;
        this.rzp = gallery;
    }

    public final void E(float f, float f2) {
        if ((SnsBrowseUI.f(this.rzl) == 0 || SnsBrowseUI.g(this.rzl) == 0) && this.rzl.ryY != null) {
            SnsBrowseUI.b(this.rzl, this.rzl.ryY.getHeight());
            SnsBrowseUI.a(this.rzl, this.rzl.ryY.getWidth());
        }
        if (SnsBrowseUI.f(this.rzl) != 0) {
            float f3 = 1.0f - (f2 / ((float) SnsBrowseUI.f(this.rzl)));
            if (f3 > 1.0f) {
                f3 = 1.0f;
            }
            SnsBrowseUI.a(this.rzl, f3);
            View selectedView = ((MMGestureGallery) this.rzp).getSelectedView();
            if (selectedView instanceof MultiTouchImageView) {
                selectedView.setPivotX((float) (SnsBrowseUI.g(this.rzl) / 2));
                selectedView.setPivotY((float) (SnsBrowseUI.f(this.rzl) / 2));
                selectedView.setScaleX(f3);
                selectedView.setScaleY(f3);
                selectedView.setTranslationX(f);
                selectedView.setTranslationY(f2);
                SnsBrowseUI.d(this.rzl).setAlpha(f3);
            }
        }
    }

    public final void F(float f, float f2) {
        SnsBrowseUI.e(this.rzl, (int) f);
        SnsBrowseUI.f(this.rzl, (int) f2);
    }
}
