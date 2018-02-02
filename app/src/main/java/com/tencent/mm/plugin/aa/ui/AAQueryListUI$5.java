package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class AAQueryListUI$5 implements a {
    final /* synthetic */ AAQueryListUI iih;

    AAQueryListUI$5(AAQueryListUI aAQueryListUI) {
        this.iih = aAQueryListUI;
    }

    public final void aW(Object obj) {
        x.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", new Object[]{obj});
        if (AAQueryListUI.g(this.iih) != null) {
            AAQueryListUI.g(this.iih).dismiss();
            AAQueryListUI.h(this.iih);
        }
        AAQueryListUI.i(this.iih);
        if (AAQueryListUI.a(this.iih).getFooterViewsCount() > 0) {
            AAQueryListUI.a(this.iih).removeFooterView(AAQueryListUI.d(this.iih));
        }
        if (obj instanceof String) {
            Toast.makeText(this.iih, obj.toString(), 1).show();
        } else {
            Toast.makeText(this.iih, a$i.uJl, 1).show();
        }
    }
}
