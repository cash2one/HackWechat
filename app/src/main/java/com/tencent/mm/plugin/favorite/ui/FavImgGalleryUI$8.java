package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.sdk.platformtools.x;

class FavImgGalleryUI$8 implements Runnable {
    final /* synthetic */ FavImgGalleryUI msr;
    final /* synthetic */ int mss;

    FavImgGalleryUI$8(FavImgGalleryUI favImgGalleryUI, int i) {
        this.msr = favImgGalleryUI;
        this.mss = i;
    }

    public final void run() {
        if (this.mss != -1) {
            x.d("MicroMsg.FavImgGalleryUI", "match selection %d", new Object[]{Integer.valueOf(this.mss)});
            FavImgGalleryUI.f(this.msr).setSelection(this.mss);
            FavImgGalleryUI.a(this.msr, this.mss);
        } else if (FavImgGalleryUI.c(this.msr) - 1 >= 0 && FavImgGalleryUI.c(this.msr) - 1 < FavImgGalleryUI.g(this.msr).size()) {
            x.d("MicroMsg.FavImgGalleryUI", "adjust selection %d, list size %d", new Object[]{Integer.valueOf(FavImgGalleryUI.c(this.msr) - 1), Integer.valueOf(FavImgGalleryUI.g(this.msr).size())});
            FavImgGalleryUI.f(this.msr).setSelection(FavImgGalleryUI.c(this.msr) - 1);
            FavImgGalleryUI.a(this.msr, FavImgGalleryUI.c(this.msr) - 1);
        } else if (FavImgGalleryUI.g(this.msr).size() > 0) {
            x.d("MicroMsg.FavImgGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[]{Integer.valueOf(FavImgGalleryUI.g(this.msr).size())});
            FavImgGalleryUI.f(this.msr).setSelection(0);
            FavImgGalleryUI.a(this.msr, 0);
        } else {
            x.w("MicroMsg.FavImgGalleryUI", "data list size %d, empty, finish", new Object[]{Integer.valueOf(FavImgGalleryUI.g(this.msr).size())});
            this.msr.finish();
        }
    }
}
