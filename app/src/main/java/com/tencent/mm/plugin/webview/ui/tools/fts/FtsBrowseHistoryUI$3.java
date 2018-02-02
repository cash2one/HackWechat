package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.widget.g;

class FtsBrowseHistoryUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ FtsBrowseHistoryUI tDQ;

    FtsBrowseHistoryUI$3(FtsBrowseHistoryUI ftsBrowseHistoryUI) {
        this.tDQ = ftsBrowseHistoryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.tDQ, g.ztp, false);
        gVar.rKC = new c(this) {
            final /* synthetic */ FtsBrowseHistoryUI$3 tDR;

            {
                this.tDR = r1;
            }

            public final void a(n nVar) {
                if (!FtsBrowseHistoryUI.b(this.tDR.tDQ).isEmpty()) {
                    nVar.eQ(0, R.l.ekO);
                }
                if (FtsBrowseHistoryUI.bTS()) {
                    nVar.eQ(2, R.l.ekQ);
                }
                nVar.eQ(1, R.l.ekM);
            }
        };
        gVar.rKD = new 2(this, gVar);
        gVar.bUk();
        return true;
    }
}
