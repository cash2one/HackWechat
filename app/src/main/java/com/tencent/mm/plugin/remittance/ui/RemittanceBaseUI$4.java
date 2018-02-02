package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class RemittanceBaseUI$4 implements OnClickListener {
    final /* synthetic */ RemittanceBaseUI pMw;
    final /* synthetic */ t pMx;

    RemittanceBaseUI$4(RemittanceBaseUI remittanceBaseUI, t tVar) {
        this.pMw = remittanceBaseUI;
        this.pMx = tVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[]{this.pMx.fHg.liO});
        e.l(this.pMw.mController.xIM, this.pMx.fHg.liO, false);
    }
}
