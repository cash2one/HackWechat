package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class RemittanceDetailUI$9 implements OnClickListener {
    final /* synthetic */ RemittanceDetailUI pOO;

    RemittanceDetailUI$9(RemittanceDetailUI remittanceDetailUI) {
        this.pOO = remittanceDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.bu(this.pOO.mController.xIM, this.pOO.getString(i.uNk));
    }
}
