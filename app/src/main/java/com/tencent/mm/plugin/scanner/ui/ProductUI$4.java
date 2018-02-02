package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.av.b;
import com.tencent.mm.av.b.7;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.ui.MusicPreference.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class ProductUI$4 implements a {
    final /* synthetic */ ProductUI pWr;

    ProductUI$4(ProductUI productUI) {
        this.pWr = productUI;
    }

    public final void d(MusicPreference musicPreference) {
        if (musicPreference == null) {
            x.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
        } else if (bh.ov(musicPreference.pSu) && bh.ov(musicPreference.pSv)) {
            x.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
            if (!bh.ov(musicPreference.pSw)) {
                ProductUI.a(this.pWr, musicPreference.pSw);
            }
        } else {
            if (ProductUI.IJ(String.format("%s_cd_%s", new Object[]{musicPreference.pSu, musicPreference.ibD}))) {
                b.Qo();
                x.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", new Object[]{r1});
            } else if (musicPreference.getTitle() == null) {
                x.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
                return;
            } else {
                String str;
                int i = -1;
                if (ProductUI.m(this.pWr) == null) {
                    str = null;
                } else {
                    str = ProductUI.m(this.pWr).Wf();
                }
                String format = String.format("%s_cd_%s", new Object[]{musicPreference.pSu, musicPreference.ibD});
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (MusicPreference musicPreference2 : ProductUI.n(this.pWr)) {
                    int i3;
                    String format2 = String.format("%s_cd_%s", new Object[]{musicPreference2.pSu, musicPreference2.ibD});
                    if (format.equals(format2)) {
                        i3 = i2;
                    } else {
                        i3 = i;
                    }
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(((com.tencent.mm.av.a.a) g.h(com.tencent.mm.av.a.a.class)).a(5, str, musicPreference2.getTitle().toString(), "", musicPreference2.pSw, musicPreference2.pSv, musicPreference2.pSu, format2, c.FC(), str, "", "wx482a4001c37e2b74"));
                    i2++;
                    i = i3;
                }
                if (i >= 0) {
                    ag.y(new 7(arrayList, i));
                } else {
                    return;
                }
            }
            ProductUI.o(this.pWr);
        }
    }
}
