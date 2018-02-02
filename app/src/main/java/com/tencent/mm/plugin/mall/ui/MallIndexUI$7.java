package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.s.c;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;

class MallIndexUI$7 implements OnClickListener {
    final /* synthetic */ MallIndexUI omF;

    MallIndexUI$7(MallIndexUI mallIndexUI) {
        this.omF = mallIndexUI;
    }

    public final void onClick(View view) {
        Context context = this.omF;
        if (q.Gf()) {
            d.y(context, "wallet_payu", ".bind.ui.WalletPayUBankcardManageUI");
        } else {
            d.y(context, "wallet", ".bind.ui.WalletBankcardManageUI");
        }
        e.HF(5);
        g.pQN.h(14419, new Object[]{this.omF.ned, Integer.valueOf(3)});
        c.Bq().c(a.xwf, a.xwg);
    }
}
