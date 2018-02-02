package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.ui.tools.MMGestureGallery$f;

class GetHdHeadImageGalleryView$c implements MMGestureGallery$f {
    final /* synthetic */ GetHdHeadImageGalleryView vjL;

    private GetHdHeadImageGalleryView$c(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
        this.vjL = getHdHeadImageGalleryView;
    }

    public final void avW() {
        if (GetHdHeadImageGalleryView.a(this.vjL) != null) {
            GetHdHeadImageGalleryView.a(this.vjL).dismiss();
        }
    }
}
