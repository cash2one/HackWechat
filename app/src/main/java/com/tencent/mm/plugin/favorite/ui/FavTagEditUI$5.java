package com.tencent.mm.plugin.favorite.ui;

import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.f;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.d;
import com.tencent.mm.protocal.c.vo;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel$a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class FavTagEditUI$5 implements MMTagPanel$a {
    final /* synthetic */ FavTagEditUI mtH;

    FavTagEditUI$5(FavTagEditUI favTagEditUI) {
        this.mtH = favTagEditUI;
    }

    public final void yI(String str) {
        FavTagEditUI.d(this.mtH).removeTag(str);
        FavTagEditUI.f(this.mtH).Ap(str);
        if (FavTagEditUI.g(this.mtH) != null) {
            FavTagEditUI.g(this.mtH).bj(str, false);
        }
        FavTagEditUI.c(this.mtH);
    }

    public final void yJ(String str) {
    }

    public final void yK(String str) {
        FavTagEditUI.d(this.mtH).removeTag(str);
        FavTagEditUI.f(this.mtH).Ap(str);
        if (FavTagEditUI.g(this.mtH) != null) {
            FavTagEditUI.g(this.mtH).bj(str, false);
        }
        FavTagEditUI.c(this.mtH);
    }

    public final void yL(String str) {
        if (bh.ov(str)) {
            FavTagEditUI.i(this.mtH).setVisibility(8);
            FavTagEditUI.j(this.mtH).setVisibility(0);
        } else {
            d h = FavTagEditUI.h(this.mtH);
            h.muH.clear();
            h.muG.clear();
            h.muF = bh.az(str, "");
            f aIq = h.aIq();
            boolean ov = bh.ov(str);
            Collection arrayList = new ArrayList(16);
            Iterator it = aIq.mpI.wfh.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((vp) it.next()).wfg.iterator();
                while (it2.hasNext()) {
                    vo voVar = (vo) it2.next();
                    if (ov || voVar.tCr.contains(str)) {
                        arrayList.add(voVar.tCr);
                    }
                }
            }
            h.muG.addAll(arrayList);
            h.notifyDataSetChanged();
            FavTagEditUI.i(this.mtH).setVisibility(0);
            FavTagEditUI.j(this.mtH).setVisibility(8);
        }
        FavTagEditUI.c(this.mtH);
    }

    public final void yM(String str) {
        if (bh.ov(str)) {
            x.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
            return;
        }
        FavTagEditUI.d(this.mtH).bi(str, true);
        FavTagEditUI.c(this.mtH);
    }

    public final void aDz() {
    }

    public final void j(boolean z, int i) {
        FavTagEditUI.a(this.mtH, z);
        TextView k = FavTagEditUI.k(this.mtH);
        int i2 = (!FavTagEditUI.b(this.mtH) || i <= 0) ? 8 : 0;
        k.setVisibility(i2);
        FavTagEditUI.k(this.mtH).setText(this.mtH.getString(R.l.egL, new Object[]{Integer.valueOf(i)}));
        FavTagEditUI.c(this.mtH);
    }
}
