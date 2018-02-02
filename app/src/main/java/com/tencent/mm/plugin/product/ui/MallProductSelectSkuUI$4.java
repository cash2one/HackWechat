package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;

class MallProductSelectSkuUI$4 implements OnClickListener {
    final /* synthetic */ MallProductSelectSkuUI pgr;

    MallProductSelectSkuUI$4(MallProductSelectSkuUI mallProductSelectSkuUI) {
        this.pgr = mallProductSelectSkuUI;
    }

    public final void onClick(View view) {
        f d = MallProductSelectSkuUI.d(this.pgr);
        if (d.pfF) {
            u.makeText(d.iQz, a$i.uLv, 1).show();
        } else if (!d.pfH.bja()) {
            String str;
            c cVar = d.pfH;
            if (cVar.pdW != null && cVar.pdW.size() < cVar.pdU && cVar.pdU > 0) {
                Iterator it = cVar.pdK.peo.peJ.iterator();
                while (it.hasNext()) {
                    m mVar = (m) it.next();
                    if (!cVar.pdW.containsKey(mVar.peV)) {
                        str = mVar.peW;
                        break;
                    }
                }
            }
            str = null;
            if (!bh.ov(str)) {
                u.makeText(d.iQz, d.iQz.getString(a$i.uqK, new Object[]{str}), 0).show();
            }
        } else if (d.pfH.pdQ != null) {
            g.Dk();
            g.Di().gPJ.a(new j(d.pfH.bjc(), f.irz), 0);
        } else {
            d.c(d.iQz, "address", ".ui.WalletAddAddressUI", 2);
        }
    }
}
