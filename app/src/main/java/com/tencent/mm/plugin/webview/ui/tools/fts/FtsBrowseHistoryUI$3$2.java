package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.fts.FtsBrowseHistoryUI.3;
import com.tencent.mm.ui.base.j.b;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;

class FtsBrowseHistoryUI$3$2 implements d {
    final /* synthetic */ 3 tDR;
    final /* synthetic */ g tDS;

    FtsBrowseHistoryUI$3$2(3 3, g gVar) {
        this.tDR = 3;
        this.tDS = gVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        b bVar;
        switch (menuItem.getItemId()) {
            case 0:
                bVar = new b(this.tDR.tDQ.mController.xIM);
                bVar.YK(this.tDR.tDQ.mController.xIM.getString(R.l.ekN));
                bVar.a(new 1(this)).pyk.show();
                return;
            case 1:
                this.tDS.bxh();
                return;
            case 2:
                bVar = new b(this.tDR.tDQ.mController.xIM);
                bVar.YK(this.tDR.tDQ.mController.xIM.getString(R.l.ekP));
                bVar.a(new 2(this)).pyk.show();
                return;
            default:
                return;
        }
    }
}
