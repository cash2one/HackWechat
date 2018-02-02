package com.tencent.mm.plugin.favorite.ui;

import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import java.util.List;

class FavImgGalleryUI$5 implements c {
    final /* synthetic */ List lEY;
    final /* synthetic */ List lEZ;
    final /* synthetic */ FavImgGalleryUI msr;

    FavImgGalleryUI$5(FavImgGalleryUI favImgGalleryUI, List list, List list2) {
        this.msr = favImgGalleryUI;
        this.lEY = list;
        this.lEZ = list2;
    }

    public final void a(n nVar) {
        nVar.setHeaderTitle("");
        for (int i = 0; i < this.lEY.size(); i++) {
            nVar.f(((Integer) this.lEY.get(i)).intValue(), (CharSequence) this.lEZ.get(i));
        }
    }
}
