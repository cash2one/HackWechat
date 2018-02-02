package com.tencent.mm.plugin.favorite.ui.detail;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteFileDetailUI.14;
import com.tencent.mm.ui.base.h;

class FavoriteFileDetailUI$14$1 implements Runnable {
    final /* synthetic */ 14 mwz;

    FavoriteFileDetailUI$14$1(14 14) {
        this.mwz = 14;
    }

    public final void run() {
        h.h(this.mwz.mwo.mController.xIM, R.l.eTc, R.l.dSB);
        Bitmap a = com.tencent.mm.plugin.favorite.b.h.a(FavoriteFileDetailUI.a(this.mwz.mwo), FavoriteFileDetailUI.b(this.mwz.mwo));
        ImageView imageView = (ImageView) this.mwz.mwo.findViewById(R.h.cVH);
        if (imageView != null) {
            imageView.setImageBitmap(a);
            imageView.setVisibility(0);
        }
    }
}
