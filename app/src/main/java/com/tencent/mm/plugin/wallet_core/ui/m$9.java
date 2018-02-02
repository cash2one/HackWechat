package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

class m$9 implements OnClickListener {
    final /* synthetic */ PayInfo oXJ;
    final /* synthetic */ OnClickListener sWb;
    final /* synthetic */ m sWc;

    m$9(PayInfo payInfo, OnClickListener onClickListener, m mVar) {
        this.oXJ = payInfo;
        this.sWb = onClickListener;
        this.sWc = mVar;
    }

    public final void onClick(View view) {
        m.bMR().put(this.oXJ.fuH, Boolean.valueOf(true));
        this.sWb.onClick(view);
        if (this.sWc.sVT) {
            g.pQN.h(14530, new Object[]{Integer.valueOf(2)});
        }
    }
}
