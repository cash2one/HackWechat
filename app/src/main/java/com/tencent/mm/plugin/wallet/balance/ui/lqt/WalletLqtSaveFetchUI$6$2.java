package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.6;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class WalletLqtSaveFetchUI$6$2 implements a<Void, azm> {
    final /* synthetic */ 6 sBy;
    final /* synthetic */ int sBz;

    WalletLqtSaveFetchUI$6$2(6 6, int i) {
        this.sBy = 6;
        this.sBz = i;
    }

    public final /* synthetic */ Object call(Object obj) {
        azm com_tencent_mm_protocal_c_azm = (azm) obj;
        x.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azm.wGy)});
        Intent intent = new Intent(this.sBy.sBv, WalletLqtSaveFetchFinishUI.class);
        intent.putExtra("key_amount", ((double) this.sBz) / 100.0d);
        intent.putExtra("key_mode", 1);
        intent.putExtra("profile_date_wording", com_tencent_mm_protocal_c_azm.wGA);
        intent.putExtra("profile_upgrade_wording", com_tencent_mm_protocal_c_azm.wGz);
        this.sBy.sBv.startActivity(intent);
        this.sBy.sBv.finish();
        return zBS;
    }
}
