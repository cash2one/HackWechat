package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.u;

class MallProductUI$6 implements OnClickListener {
    final /* synthetic */ MallProductUI phb;

    MallProductUI$6(MallProductUI mallProductUI) {
        this.phb = mallProductUI;
    }

    public final void onClick(View view) {
        f e = MallProductUI.e(this.phb);
        if (e.pfH.biZ()) {
            e.iQz.startActivity(new Intent(e.iQz, MallProductSelectSkuUI.class));
            g.pQN.h(11008, new Object[]{e.pfH.biV(), e.pfH.pdK.pek, Integer.valueOf(f.irz), Integer.valueOf(1)});
            return;
        }
        u.makeText(e.iQz, i.uLv, 1).show();
    }
}
