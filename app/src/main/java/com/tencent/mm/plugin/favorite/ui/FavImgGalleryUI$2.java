package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.g.a.mr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class FavImgGalleryUI$2 extends c<mr> {
    final /* synthetic */ FavImgGalleryUI msr;

    FavImgGalleryUI$2(FavImgGalleryUI favImgGalleryUI) {
        this.msr = favImgGalleryUI;
        this.xen = mr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mr mrVar = (mr) bVar;
        FavImgGalleryUI.e(this.msr).put(mrVar.fED.filePath, mrVar);
        if (FavImgGalleryUI.h(this.msr) != null && FavImgGalleryUI.h(this.msr).rKB.isShowing()) {
            FavImgGalleryUI.a(this.msr);
        }
        return true;
    }
}
