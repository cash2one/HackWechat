package com.tencent.mm.plugin.favorite.ui.detail;

import com.tencent.mm.g.a.mr;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteImgDetailUI.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class FavoriteImgDetailUI$9 extends c<mr> {
    final /* synthetic */ FavoriteImgDetailUI mwK;

    FavoriteImgDetailUI$9(FavoriteImgDetailUI favoriteImgDetailUI) {
        this.mwK = favoriteImgDetailUI;
        this.xen = mr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mr mrVar = (mr) bVar;
        String str = mrVar.fED.filePath;
        a aVar = null;
        for (a aVar2 : FavoriteImgDetailUI.g(this.mwK).values()) {
            a aVar22;
            if (!str.equals(j.h(aVar22.fve))) {
                aVar22 = aVar;
            }
            aVar = aVar22;
        }
        if (aVar != null) {
            aVar.mwS = bh.az(mrVar.fED.result, "");
            aVar.fqb = mrVar.fED.fqb;
            aVar.fqc = mrVar.fED.fqc;
            if (!bh.ov(aVar.mwS) && aVar.jni.rKB.isShowing()) {
                FavoriteImgDetailUI.a(this.mwK, aVar);
            }
        }
        return true;
    }
}
