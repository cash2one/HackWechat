package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class FtsBrowseHistoryUI$4 implements Runnable {
    final /* synthetic */ FtsBrowseHistoryUI tDQ;

    FtsBrowseHistoryUI$4(FtsBrowseHistoryUI ftsBrowseHistoryUI) {
        this.tDQ = ftsBrowseHistoryUI;
    }

    public final void run() {
        x.i("FtsBrowseHistoryUI", "starting load data");
        List bUb = FtsBrowseHistoryUI.b(this.tDQ).bUb();
        FtsBrowseHistoryUI.cr(bUb);
        a c = FtsBrowseHistoryUI.c(this.tDQ);
        c.hiv = bUb;
        c.UR.notifyChanged();
        x.i("FtsBrowseHistoryUI", "load data end list.size %d", new Object[]{Integer.valueOf(FtsBrowseHistoryUI.c(this.tDQ).bUa())});
        ag.y(new Runnable(this) {
            final /* synthetic */ FtsBrowseHistoryUI$4 tDU;

            {
                this.tDU = r1;
            }

            public final void run() {
                x.i("FtsBrowseHistoryUI", "updating ui");
                FtsBrowseHistoryUI.d(this.tDU.tDQ);
            }
        });
    }
}
