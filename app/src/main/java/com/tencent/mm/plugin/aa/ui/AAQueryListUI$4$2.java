package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.aa.ui.AAQueryListUI.4;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;

class AAQueryListUI$4$2 implements d {
    final /* synthetic */ 4 iii;

    AAQueryListUI$4$2(4 4) {
        this.iii = 4;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                x.i("MicroMsg.AAQueryListUI", "go to launch list: %d", new Object[]{Integer.valueOf(AAQueryListUI.e(this.iii.iih))});
                if (AAQueryListUI.e(this.iii.iih) != 1) {
                    AAQueryListUI.a(this.iii.iih, 1);
                    this.iii.iih.setMMTitle(i.uHh);
                    AAQueryListUI.f(this.iii.iih).mode = AAQueryListUI.e(this.iii.iih);
                    AAQueryListUI.f(this.iii.iih).WP();
                    AAQueryListUI.f(this.iii.iih).notifyDataSetChanged();
                    AAQueryListUI.a(this.iii.iih, true, AAQueryListUI.e(this.iii.iih));
                    return;
                }
                return;
            case 2:
                x.i("MicroMsg.AAQueryListUI", "go to pay query list: %d", new Object[]{Integer.valueOf(AAQueryListUI.e(this.iii.iih))});
                if (AAQueryListUI.e(this.iii.iih) != 2) {
                    this.iii.iih.setMMTitle(i.uHk);
                    AAQueryListUI.f(this.iii.iih).mode = AAQueryListUI.e(this.iii.iih);
                    AAQueryListUI.f(this.iii.iih).WP();
                    AAQueryListUI.f(this.iii.iih).notifyDataSetChanged();
                    AAQueryListUI.a(this.iii.iih, 2);
                    AAQueryListUI.a(this.iii.iih, true, AAQueryListUI.e(this.iii.iih));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
