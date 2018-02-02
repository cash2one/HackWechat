package com.tencent.mm.plugin.favorite.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.base.FavSearchActionView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel$d;
import java.util.Iterator;

class FavSearchUI$4 implements OnClickListener {
    final /* synthetic */ FavSearchUI mth;

    FavSearchUI$4(FavSearchUI favSearchUI) {
        this.mth = favSearchUI;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        FavSearchActionView a = FavSearchUI.a(this.mth);
        a.mur.clear();
        a.mur.add(Integer.valueOf(intValue));
        if (a.mtA != null) {
            a.aJA();
            FavTagPanel favTagPanel = a.mtA;
            String B = j.B(a.getContext(), intValue);
            if (bh.ov(B)) {
                x.w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
            } else {
                String trim = B.trim();
                Iterator it = favTagPanel.mvo.iterator();
                while (it.hasNext()) {
                    if (trim.equals(((MMTagPanel$d) it.next()).yec)) {
                        x.w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", new Object[]{trim});
                        break;
                    }
                }
                favTagPanel.mvo.clear();
                MMTagPanel$d cpI = favTagPanel.cpI();
                favTagPanel.mvo.add(cpI);
                favTagPanel.a(cpI, trim, true);
                cpI.yed.setOnClickListener(favTagPanel.mvq);
                favTagPanel.addView(cpI.yed, favTagPanel.mvo.size() - 1);
                favTagPanel.cpJ();
            }
            if (a.mvj != null) {
                a.Aq(a.mtA.cpC());
                a.mvj.a(a.mur, a.mvi, a.mvh, false);
                g.pQN.h(11126, new Object[]{Integer.valueOf(1)});
            }
        }
    }
}
