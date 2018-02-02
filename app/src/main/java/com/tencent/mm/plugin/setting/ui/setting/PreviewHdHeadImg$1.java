package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.widget.g;

class PreviewHdHeadImg$1 implements OnMenuItemClickListener {
    final /* synthetic */ PreviewHdHeadImg qhv;

    PreviewHdHeadImg$1(PreviewHdHeadImg previewHdHeadImg) {
        this.qhv = previewHdHeadImg;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.qhv, g.ztp, false);
        gVar.rKC = new c(this) {
            final /* synthetic */ PreviewHdHeadImg$1 qhw;

            {
                this.qhw = r1;
            }

            public final void a(n nVar) {
                nVar.eQ(1, R.l.eKX);
                if (b.a(PreviewHdHeadImg.a(this.qhw.qhv), true, -1) != null) {
                    nVar.eQ(2, R.l.eny);
                }
            }
        };
        gVar.rKD = new 2(this);
        gVar.bUk();
        return true;
    }
}
