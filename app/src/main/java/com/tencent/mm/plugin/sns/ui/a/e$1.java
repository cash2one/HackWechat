package com.tencent.mm.plugin.sns.ui.a;

import android.graphics.BitmapFactory;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;

class e$1 implements a {
    final /* synthetic */ PhotosContent rAu;
    final /* synthetic */ b rAv;
    final /* synthetic */ TagImageView rAw;
    final /* synthetic */ e rOY;

    e$1(e eVar, PhotosContent photosContent, b bVar, TagImageView tagImageView) {
        this.rOY = eVar;
        this.rAu = photosContent;
        this.rAv = bVar;
        this.rAw = tagImageView;
    }

    public final void bxc() {
    }

    public final void bxd() {
    }

    public final void KY(String str) {
        this.rOY.rOX = (MaskImageView) this.rAu.findViewById(f.qCT);
        if (this.rOY.rOX != null) {
            this.rOY.rOX.setVisibility(0);
            this.rOY.rOX.setImageBitmap(BitmapFactory.decodeFile(str));
            float a = e.a((double) this.rAv.rfe, 1, this.rAv.rfa, this.rAv.rfb);
            float a2 = e.a((double) this.rAv.rff, 1, this.rAv.rfa, this.rAv.rfb);
            float a3 = e.a((double) this.rAv.rfg, 1, this.rAv.rfa, this.rAv.rfb);
            float a4 = e.a((double) this.rAv.rfh, 1, this.rAv.rfa, this.rAv.rfb);
            LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
            layoutParams.setMargins((int) ((((float) this.rAw.getRight()) - a3) - a), (int) ((((float) this.rAw.getBottom()) - a4) - a2), 0, 0);
            this.rOY.rOX.setLayoutParams(layoutParams);
        }
    }
}
