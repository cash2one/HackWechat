package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class m$8 implements OnClickListener {
    final /* synthetic */ m sVV;
    final /* synthetic */ OnCancelListener sWa;

    m$8(m mVar, OnCancelListener onCancelListener) {
        this.sVV = mVar;
        this.sWa = onCancelListener;
    }

    public final void onClick(View view) {
        if (this.sWa != null) {
            this.sWa.onCancel(null);
        }
        if (this.sVV.sVE != null) {
            this.sVV.sVE.bho();
        }
        this.sVV.cancel();
        if (this.sVV.sVJ.isShown()) {
            g.pQN.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            return;
        }
        g.pQN.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
    }
}
