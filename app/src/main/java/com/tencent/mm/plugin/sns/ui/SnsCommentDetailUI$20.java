package com.tencent.mm.plugin.sns.ui;

import android.graphics.BitmapFactory;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.b;

class SnsCommentDetailUI$20 implements a {
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ PhotosContent rAu;
    final /* synthetic */ b rAv;
    final /* synthetic */ TagImageView rAw;

    SnsCommentDetailUI$20(SnsCommentDetailUI snsCommentDetailUI, PhotosContent photosContent, b bVar, TagImageView tagImageView) {
        this.rAr = snsCommentDetailUI;
        this.rAu = photosContent;
        this.rAv = bVar;
        this.rAw = tagImageView;
    }

    public final void bxc() {
    }

    public final void bxd() {
    }

    public final void KY(String str) {
        MaskImageView maskImageView = (MaskImageView) this.rAu.findViewById(f.qCT);
        if (maskImageView != null) {
            maskImageView.setVisibility(0);
            maskImageView.setImageBitmap(BitmapFactory.decodeFile(str));
            float a = e.a((double) this.rAv.rfe, 1, this.rAv.rfa, this.rAv.rfb);
            float a2 = e.a((double) this.rAv.rff, 1, this.rAv.rfa, this.rAv.rfb);
            float a3 = e.a((double) this.rAv.rfg, 1, this.rAv.rfa, this.rAv.rfb);
            float a4 = e.a((double) this.rAv.rfh, 1, this.rAv.rfa, this.rAv.rfb);
            LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
            layoutParams.setMargins((int) ((((float) this.rAw.getRight()) - a3) - a), (int) ((((float) this.rAw.getBottom()) - a4) - a2), 0, 0);
            maskImageView.setLayoutParams(layoutParams);
        }
    }
}
