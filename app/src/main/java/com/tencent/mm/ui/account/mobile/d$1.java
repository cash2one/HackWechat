package com.tencent.mm.ui.account.mobile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;

class d$1 implements OnClickListener {
    final /* synthetic */ MobileInputUI xTP;
    final /* synthetic */ d xTS;

    d$1(d dVar, MobileInputUI mobileInputUI) {
        this.xTS = dVar;
        this.xTP = mobileInputUI;
    }

    public final void onClick(View view) {
        bh.F(this.xTP, this.xTP.getString(R.l.eSl));
    }
}
