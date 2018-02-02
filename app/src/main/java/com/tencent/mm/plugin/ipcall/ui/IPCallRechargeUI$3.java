package com.tencent.mm.plugin.ipcall.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class IPCallRechargeUI$3 extends af {
    final /* synthetic */ IPCallRechargeUI nLL;

    IPCallRechargeUI$3(IPCallRechargeUI iPCallRechargeUI) {
        this.nLL = iPCallRechargeUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1002:
                this.nLL.nLH.setVisibility(0);
                IPCallRechargeUI.k(this.nLL);
                return;
            default:
                x.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
                return;
        }
    }
}
