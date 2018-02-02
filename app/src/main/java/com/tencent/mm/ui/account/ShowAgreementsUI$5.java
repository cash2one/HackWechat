package com.tencent.mm.ui.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ShowAgreementsUI$5 implements OnClickListener {
    final /* synthetic */ ShowAgreementsUI xSE;

    ShowAgreementsUI$5(ShowAgreementsUI showAgreementsUI) {
        this.xSE = showAgreementsUI;
    }

    public final void onClick(View view) {
        h.a(this.xSE, ShowAgreementsUI.a(this.xSE), "", this.xSE.getString(R.l.esP), this.xSE.getString(R.l.dDM), false, null, new 1(this));
    }
}
