package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.widget.g;

class ContactRemarkImagePreviewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ContactRemarkImagePreviewUI yRB;

    ContactRemarkImagePreviewUI$1(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        this.yRB = contactRemarkImagePreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.yRB, g.ztp, false);
        gVar.rKC = new c(this) {
            final /* synthetic */ ContactRemarkImagePreviewUI$1 yRC;

            {
                this.yRC = r1;
            }

            public final void a(n nVar) {
                if (!ContactRemarkImagePreviewUI.a(this.yRC.yRB)) {
                    nVar.f(0, this.yRC.yRB.getString(R.l.dEw));
                }
                nVar.f(1, this.yRC.yRB.getString(R.l.eHg));
                if (d.OQ("favorite")) {
                    nVar.f(2, this.yRC.yRB.getString(R.l.eAd));
                }
            }
        };
        gVar.rKD = new 2(this);
        gVar.bUk();
        return true;
    }
}
