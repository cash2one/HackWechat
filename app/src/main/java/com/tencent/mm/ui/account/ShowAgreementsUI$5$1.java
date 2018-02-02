package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.account.ShowAgreementsUI.5;

class ShowAgreementsUI$5$1 implements OnClickListener {
    final /* synthetic */ 5 xSF;

    ShowAgreementsUI$5$1(5 5) {
        this.xSF = 5;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.a(712, 4, 1, true);
        this.xSF.xSE.setResult(102002);
        this.xSF.xSE.finish();
    }
}
