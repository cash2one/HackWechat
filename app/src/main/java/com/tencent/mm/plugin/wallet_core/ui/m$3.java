package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class m$3 implements OnClickListener {
    final /* synthetic */ m sVV;

    m$3(m mVar) {
        this.sVV = mVar;
    }

    public final void onClick(View view) {
        if (this.sVV.ofs.isShown()) {
            this.sVV.ofs.setVisibility(8);
        }
    }
}
