package com.tencent.mm.plugin.product.ui;

import android.support.v4.view.ViewPager.e;
import com.tencent.mm.sdk.platformtools.x;

class MallGalleryUI$1 implements e {
    final /* synthetic */ MallGalleryUI pfu;

    MallGalleryUI$1(MallGalleryUI mallGalleryUI) {
        this.pfu = mallGalleryUI;
    }

    public final void ae(int i) {
        x.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", new Object[]{Integer.valueOf(i)});
        MallGalleryUI.a(this.pfu, i);
        if (MallGalleryUI.a(this.pfu)) {
            this.pfu.mController.hideTitleView();
            MallGalleryUI.b(this.pfu);
        }
    }

    public final synchronized void a(int i, float f, int i2) {
    }

    public final void af(int i) {
    }
}
