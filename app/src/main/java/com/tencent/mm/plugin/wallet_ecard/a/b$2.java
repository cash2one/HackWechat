package com.tencent.mm.plugin.wallet_ecard.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.protocal.c.axk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$2 implements OnClickListener {
    final /* synthetic */ axk sZs;
    final /* synthetic */ WalletBaseUI sZt;

    b$2(axk com_tencent_mm_protocal_c_axk, WalletBaseUI walletBaseUI) {
        this.sZs = com_tencent_mm_protocal_c_axk;
        this.sZt = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c cCc;
        if (this.sZs.wqk == a.sYT) {
            x.i("MicroMsg.ECardUtil", "do end process");
            cCc = this.sZt.cCc();
            if (cCc != null) {
                cCc.b(this.sZt, new Bundle());
            } else {
                this.sZt.finish();
            }
        } else if (this.sZs.wqk == a.sYW) {
            x.i("MicroMsg.ECardUtil", "back bank list");
            cCc = this.sZt.cCc();
            if (cCc != null) {
                cCc.d(this.sZt, 100);
            } else {
                this.sZt.finish();
            }
        }
        dialogInterface.dismiss();
    }
}
