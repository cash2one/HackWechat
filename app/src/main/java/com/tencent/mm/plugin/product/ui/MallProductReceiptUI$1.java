package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.u;

class MallProductReceiptUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MallProductReceiptUI pga;

    MallProductReceiptUI$1(MallProductReceiptUI mallProductReceiptUI) {
        this.pga = mallProductReceiptUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        int i = 0;
        String obj = MallProductReceiptUI.a(this.pga).getText().toString();
        if (bh.ov(obj)) {
            u.makeText(this.pga, a$i.uLw, 0).show();
        } else {
            c b = MallProductReceiptUI.b(this.pga);
            b.pdR = new bbk();
            bbk com_tencent_mm_protocal_c_bbk = b.pdR;
            if (!bh.ov(obj)) {
                i = 1;
            }
            com_tencent_mm_protocal_c_bbk.wHN = i;
            b.pdR.ngs = obj;
            this.pga.finish();
        }
        return true;
    }
}
