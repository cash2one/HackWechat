package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.ui.PaylistAAUI.13;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class PaylistAAUI$13$2 implements d {
    final /* synthetic */ 13 iku;

    PaylistAAUI$13$2(13 13) {
        this.iku = 13;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = 3;
        switch (menuItem.getItemId()) {
            case 1:
                if (!bh.ov(PaylistAAUI.a(this.iku.ikp))) {
                    Intent intent = new Intent(this.iku.ikp.mController.xIM, LaunchAAUI.class);
                    intent.putExtra("enter_scene", 3);
                    intent.putExtra("chatroom_name", PaylistAAUI.a(this.iku.ikp));
                    this.iku.ikp.startActivity(intent);
                }
                if (this.iku.ikt.vDh == a.ifR) {
                    i2 = 1;
                } else if (this.iku.ikt.vDh == a.ifQ) {
                    i2 = 2;
                }
                x.d("MicroMsg.PaylistAAUI", "test");
                g.pQN.h(13721, Integer.valueOf(7), Integer.valueOf(i2));
                return;
            case 2:
                g.pQN.h(13721, Integer.valueOf(4), Integer.valueOf(5));
                h.a(this.iku.ikp, i.uGQ, -1, i.uGS, i.dEn, new 1(this), null);
                return;
            default:
                return;
        }
    }
}
