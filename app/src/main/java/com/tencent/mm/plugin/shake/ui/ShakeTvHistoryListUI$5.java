package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.z.ar;

class ShakeTvHistoryListUI$5 implements d {
    final /* synthetic */ ShakeTvHistoryListUI qsv;

    ShakeTvHistoryListUI$5(ShakeTvHistoryListUI shakeTvHistoryListUI) {
        this.qsv = shakeTvHistoryListUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                int i2;
                g.pQN.h(12662, new Object[]{Integer.valueOf(1), bh.ou(ShakeTvHistoryListUI.d(this.qsv))});
                o brE = m.brE();
                String d = ShakeTvHistoryListUI.d(this.qsv);
                if (bh.ov(d)) {
                    i2 = -1;
                } else {
                    i2 = brE.gJP.delete(brE.getTableName(), "username = '" + d + "'", null);
                    x.d("MicroMsg.ShakeTvHistoryStorage", "delMsgByUserName = " + i2);
                }
                if (i2 < 0) {
                    x.i("MicroMsg.ShakeTvHistoryListUI", "delete tv history fail, ret[%d]", new Object[]{Integer.valueOf(i2)});
                } else {
                    ar.CG().a(new c(1, ShakeTvHistoryListUI.d(this.qsv)), 0);
                }
                ShakeTvHistoryListUI.a(this.qsv).a(null, null);
                return;
            default:
                return;
        }
    }
}
