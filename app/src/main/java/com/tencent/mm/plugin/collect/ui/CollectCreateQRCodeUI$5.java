package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class CollectCreateQRCodeUI$5 implements OnClickListener {
    final /* synthetic */ CollectCreateQRCodeUI lma;
    final /* synthetic */ m lmd;

    CollectCreateQRCodeUI$5(CollectCreateQRCodeUI collectCreateQRCodeUI, m mVar) {
        this.lma = collectCreateQRCodeUI;
        this.lmd = mVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!bh.ov(this.lmd.liO)) {
            x.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", new Object[]{this.lmd.liO});
            e.l(this.lma.mController.xIM, this.lmd.liO, true);
        }
    }
}
