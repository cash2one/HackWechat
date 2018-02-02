package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h$c;

class IPCallRechargeUI$9 implements h$c {
    final /* synthetic */ IPCallRechargeUI nLL;

    IPCallRechargeUI$9(IPCallRechargeUI iPCallRechargeUI) {
        this.nLL = iPCallRechargeUI;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                x.i("MicroMsg.IPCallRechargeUI", "start restore");
                IPCallRechargeUI.i(this.nLL).start();
                g.pQN.a(257, 14, 1, true);
                Intent intent = new Intent();
                intent.putExtra("key_action_type", 200002);
                intent.putExtra("key_force_google", true);
                d.b(this.nLL, "wallet_index", ".ui.WalletIapUI", intent, 2002);
                MMActivity mMActivity = this.nLL;
                if (mMActivity.isFinishing()) {
                    x.i("MicroMsg.IPCallRechargeUI", "[showLoadingDialog] acitivity is finished.");
                    return;
                }
                Context context = mMActivity.mController.xIM;
                mMActivity.getString(R.l.dGO);
                mMActivity.nIK = h.a(context, mMActivity.getString(R.l.eqO), false, null);
                return;
            default:
                return;
        }
    }
}
